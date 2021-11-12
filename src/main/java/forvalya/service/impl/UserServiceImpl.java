package forvalya.service.impl;

import forvalya.entity.User;
import forvalya.repo.UserRepository;
import forvalya.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserByName(String name) {
        userRepository.deleteByName(name).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
