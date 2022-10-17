/*
package com.Reto3.Reto3.Controller;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;
import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class UserController {
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println("principal.getAttribute(\"name\")" + principal.getAttribute("name"));
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
    
} */
