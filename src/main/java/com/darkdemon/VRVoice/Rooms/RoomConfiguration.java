package com.darkdemon.VRVoice.Rooms;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoomConfiguration {

    @Bean
    public Room GetRoom(){

        return new Room();

    }

}
