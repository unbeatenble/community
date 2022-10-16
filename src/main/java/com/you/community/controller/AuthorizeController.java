package com.you.community.controller;

import com.you.community.dto.AccessTokenDTO;
import com.you.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setClient_id("35ba2c7a38a011ad3398");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_secret("36842d69dfcd706d1a7e085ac4f4ff26b7656c76");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }

}

























