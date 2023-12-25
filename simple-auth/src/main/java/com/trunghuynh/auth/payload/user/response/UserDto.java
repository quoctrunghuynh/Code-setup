package com.trunghuynh.auth.payload.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("UserDto")
public class UserDto implements Serializable {
    private Long id;
    private String lastname;
    private String firstname;
    private LocalDateTime createdAt;
}
