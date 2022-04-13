package com.darkdemon.VRVoice.Users;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public User UserClass(){

        return new User();

    }
}
