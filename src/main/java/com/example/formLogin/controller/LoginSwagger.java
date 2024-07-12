package com.example.formLogin.controller;

import com.example.formLogin.request.UserRequest;
import com.example.formLogin.service.JwtUserDetailsService;
import com.example.formLogin.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginSwagger {

    private Logger logger = LoggerFactory.getLogger(LoginSwagger.class);

    @Autowired
    private JwtUserDetailsService userService;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @ModelAttribute("loginRequest")
    public UserRequest userRequest() {
        return new UserRequest();
    }

    @GetMapping(value = "/login-swagger")
    public String login() {
        return "loginSwagger.html";
    }

    @PostMapping(value = "/login-swagger")
    public RedirectView loginSwagger(@ModelAttribute("loginRequest") UserRequest userRequest, HttpServletRequest request) {
        try {
            UserDetails userDetails = userService.loadUserByUsername(userRequest.getUsername());
            String token = jwtUtil.generateToken(userDetails.getUsername());

            if (token  != null) {
                request.getSession().setAttribute("Authorization", token);

                return new RedirectView("/custom/swagger-ui/index.html");
            }
        } catch(UsernameNotFoundException err) {
            logger.error(err.getMessage());
        }
        return new RedirectView("/login-swagger?error");
    }
}
