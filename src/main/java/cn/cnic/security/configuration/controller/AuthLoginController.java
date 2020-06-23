package cn.cnic.security.configuration.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthLoginController {

    @GetMapping("/inst/callback")
    public String callback(){
        return "/callbackPage";
    }

}
