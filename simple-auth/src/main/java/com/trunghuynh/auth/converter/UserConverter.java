package com.trunghuynh.auth.converter;

import com.trunghuynh.auth.entity.User;
import com.trunghuynh.auth.payload.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter implements GeneralConverter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        UserDto target = new UserDto();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    @Override
    public User revert(UserDto target) {
        User source = new User();
        BeanUtils.copyProperties(target, source);
        return source;
    }

    @Override
    public List<UserDto> convert(List<User> sources) {
        return sources.stream().map(this::convert).toList();
    }

    @Override
    public List<User> revert(List<UserDto> targets) {
        return targets.stream().map(this::revert).toList();
    }
}
