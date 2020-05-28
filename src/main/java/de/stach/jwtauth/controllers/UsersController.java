package de.stach.jwtauth.controllers;


import de.stach.jwtauth.models.User;
import de.stach.jwtauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/users")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getalluser")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<List> getAllUser(@RequestParam(required = false) String userName) {
        try {
            List<User> userList = new ArrayList<>();

            if (userName == null)
               userRepository.findAll().forEach(userList::add);
            else
                userRepository.findByUsernameContaining(userName).forEach(userList::add);

            if (userList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
