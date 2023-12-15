package com.trunghuynh.casestudy.model.service.user;

import com.trunghuynh.casestudy.Jwt.JwtService;
import com.trunghuynh.casestudy.model.dto.request.RegisterRequest;
import com.trunghuynh.casestudy.model.dto.response.AddressResponseDto;
import com.trunghuynh.casestudy.model.dto.response.UserResponseDto;
import com.trunghuynh.casestudy.model.entity.user.User;
import com.trunghuynh.casestudy.model.mapper.AddressMapper;
import com.trunghuynh.casestudy.model.mapper.UserMapper;
import com.trunghuynh.casestudy.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(RegisterRequest request) {
        User user = userMapper.registerDtoToEntity(request);
        userRepository.save(user);
    }

    @Override
    public UserResponseDto getEmailFromToken(String token) {
        String noBearerToken = token.substring(7);
        String email = jwtService.extractUsername(noBearerToken);
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            UserResponseDto userResponseDto = userMapper.convert(user);
            List<AddressResponseDto> addressList = addressMapper.convert(user.getAddresses());
            userResponseDto.setAddress(addressList);
            return userResponseDto;
        }
        return null;
    }
}
