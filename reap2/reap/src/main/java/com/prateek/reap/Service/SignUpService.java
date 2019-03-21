package com.prateek.reap.Service;


import com.prateek.reap.Entity.User;
import com.prateek.reap.Repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class SignUpService {

    @Autowired
    SignUpRepository signUpRepository;
/*

    @Autowired
    private PasswordEncoder passwordEncoder;
*/

    public void saveUser(User responseData) {
        // responseData.setUserPassword(new BCryptPasswordEncoder().encode(responseData.getUserPassword()));
        signUpRepository.save(responseData);
    }

   /* public List<User> checkUser(User responseData) {

        return signUpRepository.findByEmail(responseData.getEmail());

    }*/

    public List<User> checkEmailAndActive(String email, boolean active) {
        return signUpRepository.findByEmailAndActive(email, active);
    }

    public User checkByEmail(String email) {
        return signUpRepository.findByEmail(email);
    }

    public User findUserByResetToken(String resetToken) {
        return signUpRepository.findByToken(resetToken);
    }

    public String saveTokenAndGenerateResetUrl(User user, String resetTokenUrl) {
        String token = generateAndSaveResetToken(user);
        return resetTokenUrl + token;
    }

    private String generateAndSaveResetToken(User user) {
        String token = UUID.randomUUID().toString();
        user.setActive(false);
        user.setToken(token);
        signUpRepository.save(user);
        return token;
    }

    public String saveImagePath(String file) throws IOException {


        /*String filePath = "/home/prateek/Downloads/reap/src/main/resources/static/profileimages";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(filePath + file);
        Files.write(path, bytes);
        return String.valueOf(path);
*/
        return file;
    }

   /* public String saveImagePath(MultipartFile profilePicture) throws IOException {
        String filePath="/home/prateek/Downloads/reap/src/main/resources/profileimages/";
        byte[] bytes =profilePicture.getBytes();
        Path path = Paths.get(filePath+profilePicture.getOriginalFilename());
        Files.write(path,bytes);
        return String.valueOf(path);
    }

*/
}
