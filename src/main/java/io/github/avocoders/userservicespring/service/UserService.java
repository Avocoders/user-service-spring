package io.github.avocoders.userservicespring.service;

import io.github.avocoders.userservicespring.dto.CreateUserRequest;
import io.github.avocoders.userservicespring.dto.UserResponse;
import io.github.avocoders.userservicespring.entity.User;
import io.github.avocoders.userservicespring.exception.UserNotFoundException;
import io.github.avocoders.userservicespring.mapper.UserMapper;
import io.github.avocoders.userservicespring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse create(CreateUserRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public UserResponse getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User foundUser = optionalUser.orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.toResponse(foundUser);
    }

}
