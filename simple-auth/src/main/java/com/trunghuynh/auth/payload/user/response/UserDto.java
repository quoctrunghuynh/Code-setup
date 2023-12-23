package com.trunghuynh.auth.payload.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
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
