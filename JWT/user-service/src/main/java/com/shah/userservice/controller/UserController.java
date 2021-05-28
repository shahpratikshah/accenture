package com.shah.userservice.controller;

import com.shah.userservice.VO.Department;
import com.shah.userservice.VO.ResponseTemplateVO;
import com.shah.userservice.entity.User;
import com.shah.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO findByUserId(@PathVariable(value = "id") Long userId){
        User user = userService.findByUserId(userId);
        Department department= restTemplate.getForObject("http://localhost:9002:/departments/"+user.getDepartmentId(),Department.class);

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
