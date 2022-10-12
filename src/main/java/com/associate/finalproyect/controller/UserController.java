package com.associate.finalproyect.controller;

import com.associate.finalproyect.dto.UserRequest;
import com.associate.finalproyect.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest request){
        try {
            return ResponseEntity.ok().body(userService.createUser(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok().body(userService.updateUser(request));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{identification}")
    public ResponseEntity<?> getUserByIdentification(@PathVariable String identification){
        return ResponseEntity.ok().body(userService.getUserByIdentification(identification));
    }

    @DeleteMapping("/delete/{identification}")
    public ResponseEntity<?> deleteUser(@PathVariable String identification){
        return ResponseEntity.ok().body(userService.deleteUser(identification));
    }
}
