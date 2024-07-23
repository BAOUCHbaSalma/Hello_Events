package com.example.demo.service;

import com.example.demo.dto.SignupRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }




    /**
     * Recherche un utilisateur par son identifiant.
     *
     * @param id L'identifiant de l'utilisateur à rechercher.
     * @return L'utilisateur trouvé.
     * @throws java.util.NoSuchElementException Si aucun utilisateur avec cet identifiant n'est trouvé.
     */
    public User findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Transactional
    public void signUp(SignupRequest signupRequest) {
        String hashedPassword = passwordEncoder.encode(signupRequest.password());
        User user = User.builder()
                .username(signupRequest.username())
                .password(hashedPassword)
                .email(signupRequest.email())
                .build();
        userRepository.save(user);
    }

    public List<User> findAllRegistre(){
       return userRepository.findAll();
    }
    public void deleteUser(Integer idUser){
        userRepository.deleteById(idUser);
    }
}
