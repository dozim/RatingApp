package com.doz.service;

import com.doz.mapper.UserMapper;
import com.doz.model.User;
import com.doz.model.dto.UserDto;
import com.doz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserService {

    public final UserRepository userRepository;
    public final UserMapper userMapper;

    public UserDto getUserDto(long id) {
        User user = this.userRepository.getById(id);
        return this.userMapper.map(user);
    }

    public User getUser(long id) {
        return this.userRepository.getById(id);
    }

    @Transactional
    @Modifying
    public UserDto save(User user) {
        return this.userMapper.map(this.userRepository.save(user));
    }
}
