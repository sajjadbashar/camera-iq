package com.sajjadbashar.cameraIQ.services;

import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sajjadbashar.cameraIQ.models.User;
import com.sajjadbashar.cameraIQ.repositories.UserRepository;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return stream(userRepository.findAll().spliterator(), false)
                .collect(toList());
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> createUser(User user) {
        return Optional.of(userRepository.save(user));
    }

    public void removeUser(Integer id) {
        userRepository.removeUserFromOrganizations(id);
        userRepository.deleteById(id);
    }

    public void removeUserFromOrganization(Integer userId, Integer organizationId) {
        userRepository.removeUserFromOrganization(userId, organizationId);
    }
}
