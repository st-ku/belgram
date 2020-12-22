package com.example.belgram.service;

import com.example.belgram.entity.security.Role;
import com.example.belgram.entity.security.User;
import com.example.belgram.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Data
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Pattern BCRYPT_PATTERN = Pattern
            .compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.orElse(new User());
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public boolean saveNewUser(User user) {
        Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());
        encodePassword(user);
        Role role = new Role();
        role.setId(3L);
        role.setName("ROLE_USER");
        user.setRole(role);
        if (userFromDB.isPresent()) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Transactional
    public void updateUser(User user) {
        encodePassword(user);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        }
    }

    private void encodePassword(User user) {
        if (!BCRYPT_PATTERN.matcher(user.getPassword()).matches()) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
    }
}


