package com.mine.alpha.controller;

import com.mine.alpha.dao.UserMapper;
import com.mine.alpha.model.Response;
import com.mine.alpha.model.User;
import com.mine.alpha.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private EntityService entityService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(){
        return "just a joke";
    }

    @PostMapping("/login")
    public Response login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("type") String type){
        String token = null;
        switch (type){
            case "user":
                token = entityService.userSign(username,password);
                break;
            case "enterprise":
                token = entityService.enterpriseSign(username,password);
                break;
            default:
                break;
        }
        if (token != null) return new Response(200,"Login successful",token);
            else return new Response(401,"Username or password wrong",null);
    }

    @PostMapping("/signup/user")
    public Response signup(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("enterprise") int enterpriseId){
        return null;
    }
}
