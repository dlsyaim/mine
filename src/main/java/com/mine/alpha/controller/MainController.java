package com.mine.alpha.controller;

import com.mine.alpha.dao.UserMapper;
import com.mine.alpha.model.Response;
import com.mine.alpha.model.User;
import com.mine.alpha.security.JWTUtil;
import com.mine.alpha.service.AuthService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public String index(){
        return "just a joke";
    }

//08cf019ad722652759cad5fa77828b06
    @PostMapping("/login")
    public Response login(
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        String token = authService.sign(username,password);
        if (token != null) return new Response(200,"Login successful",token);
            else return new Response(401,"Username or password wrong",null);
    }
}
