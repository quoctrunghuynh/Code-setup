package com.trunghuynh.casestudy.model.mapper;

import com.trunghuynh.casestudy.model.dto.request.RegisterRequest;
import com.trunghuynh.casestudy.model.dto.response.UserResponseDto;
import com.trunghuynh.casestudy.model.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserMapper implements GeneralMapper<User,UserResponseDto> {
    public User registerDtoToEntity(RegisterRequest request){
        User user = new User();
        BeanUtils.copyProperties(request,user);
        return user;
    }

    @Override
    public UserResponseDto convert(User source) {
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(source,userResponseDto);
        return userResponseDto;
    }

    @Override
    public User revert(UserResponseDto target) {
        User user = new User();
        BeanUtils.copyProperties(target,user);
        return user;
    }

    @Override
    public List<UserResponseDto> convert(List<User> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<User> revert(List<UserResponseDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
