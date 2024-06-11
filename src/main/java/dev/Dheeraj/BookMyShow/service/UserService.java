package dev.Dheeraj.BookMyShow.service;

import dev.Dheeraj.BookMyShow.exception.DuplicateEmailException;
import dev.Dheeraj.BookMyShow.exception.InvalidPasswordException;
import dev.Dheeraj.BookMyShow.model.User;
import dev.Dheeraj.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name, String email , String password){
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null){
            throw new DuplicateEmailException("The Email address being used already exist in our database with another user.");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);
    }

    public User login(String email,String password){
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser == null){
            throw new UsernameNotFoundException("Username is not present in our database,try signup instead");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, savedUser.getPassword())){
            return savedUser;
        }
        throw new InvalidPasswordException("Invalid Password");
    }

    public User getById(int id){
        return userRepository.findById(id).get();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
