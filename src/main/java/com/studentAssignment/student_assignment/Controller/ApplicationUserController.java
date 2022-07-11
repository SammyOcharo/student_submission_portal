package com.studentAssignment.student_assignment.Controller;

import com.studentAssignment.student_assignment.Entity.ApplicationUSerEntity;
import com.studentAssignment.student_assignment.Registration.Registration;
import com.studentAssignment.student_assignment.Service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @PostMapping("/")
    public ApplicationUSerEntity saveUser(@RequestBody Registration registration){

        return applicationUserService.saveUser(registration);
    }
}
