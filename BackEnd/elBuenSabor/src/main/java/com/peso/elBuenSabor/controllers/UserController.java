package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.User;
import com.peso.elBuenSabor.services.UserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/users")
public class UserController extends BaseControllerImpl<User, UserServiceImpl>{
}
