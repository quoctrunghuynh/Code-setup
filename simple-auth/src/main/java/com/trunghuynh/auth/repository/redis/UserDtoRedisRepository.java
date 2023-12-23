package com.trunghuynh.auth.repository.redis;

import com.trunghuynh.auth.entity.User;
import com.trunghuynh.auth.payload.user.response.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDtoRedisRepository {
    public final static String KEY = "UserDto";
    private final RedisTemplate<String, UserDto> template;

    public UserDtoRedisRepository(RedisTemplate<String, UserDto> template) {
        this.template = template;
    }

    public UserDto findUserDtoWithId(Long id) {
        return (UserDto) template.opsForHash().get(KEY, id);
    }

    public void saveUserDto(UserDto userDto) {
        template.opsForHash().put(KEY, userDto.getId(), userDto);
    }

    public void updateUserDtoByUser(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        template.opsForHash().put(KEY, userDto.getId(), userDto);
    }

    public void deleteUserDtoByUser(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        template.opsForHash().delete(KEY, userDto.getId());
    }
}
