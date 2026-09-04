package io.github.avocoders.userservicespring.service;

import io.github.avocoders.userservicespring.dto.CreateUserRequest;
import io.github.avocoders.userservicespring.dto.UpdateUserRequest;
import io.github.avocoders.userservicespring.dto.UserResponse;
import io.github.avocoders.userservicespring.entity.User;
import io.github.avocoders.userservicespring.exception.UserNotFoundException;
import io.github.avocoders.userservicespring.mapper.UserMapper;
import io.github.avocoders.userservicespring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        User foundUser = findUserById(id);
        return userMapper.toResponse(foundUser);
    }

    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toResponse).toList();
    }

    public UserResponse update(Long id, UpdateUserRequest request) {
        User foundUser = findUserById(id);
        userMapper.updateEntity(foundUser, request);
        User updatedUser = userRepository.save(foundUser);
        return userMapper.toResponse(updatedUser);
    }

    public void delete(Long id) {
        User foundUser = findUserById(id);
        userRepository.delete(foundUser);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}
