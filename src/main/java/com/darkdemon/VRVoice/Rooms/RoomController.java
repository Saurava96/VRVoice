package com.darkdemon.VRVoice.Rooms;


import com.darkdemon.VRVoice.Constants.ConstantController;
import com.darkdemon.VRVoice.Users.User;
import com.darkdemon.VRVoice.Users.UserRepository;
import org.apache.catalina.LifecycleState;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Component
@RestController
public class RoomController {

    @Autowired
    Room UserRoom;

    @Autowired
    UserRepository UserRepo;


    @PostMapping(value = "/CreateRoom")
    public String CreateRoom(@RequestBody String Json) throws Exception{

        JSONObject jsonObject = new JSONObject(Json);

        JSONObject roomPublicInfo = jsonObject.getJSONObject(ConstantController.RoomPublicInfo);
        JSONObject roomInfo = jsonObject.getJSONObject(ConstantController.RoomInfo);

        JSONObject publicInfoValue = roomPublicInfo.getJSONObject("value");

        String RoomAccessibility = publicInfoValue.getString(ConstantController.RoomAccessibility);

        JSONArray roomTopics = publicInfoValue.getJSONArray(ConstantController.RoomTopics);

        ArrayList<String> topicsArray= new ArrayList<>();
        ArrayList<String> emptyArray= new ArrayList<>();

        for(int i = 0; i < roomTopics.length(); i++){

            String value = roomTopics.getString(i);
            topicsArray.add(value);

        }

        String roomCircle = publicInfoValue.getString(ConstantController.RoomCircle);

        String roomLang = publicInfoValue.getString(ConstantController.RoomLanguage);

        String roomCreateDate = publicInfoValue.getString(ConstantController.RoomCreateDate);



        UserRoom.setRoomID(UUID.randomUUID().toString());

        UserRoom.setRoomTopics(topicsArray);

        UserRoom.setRoomAccessibility(RoomAccessibility);



        UserRoom.setRoomLanguage(roomLang);

        UserRoom.setRoomCreateDate(roomCreateDate);

        UserRoom.setCircleIDs(roomCircle);

        UserRoom.setRoomPhases(emptyArray);

        UserRoom.setRoomObject(roomInfo.toString());

        UserRepo.SaveRoom(UserRoom);

        String roomID = UserRoom.getRoomID();

        return roomID;

    }
    @PostMapping(value = "/AddPhase/{RoomID}")
    public String AddRoomPhase(@PathVariable("RoomID") String RoomID, @RequestBody String Json) throws Exception{

        Room room = UserRepo.GetRoom(RoomID);

        JSONObject phase = new JSONObject(Json);

        ArrayList<String> roomPhases = room.getRoomPhases();

        roomPhases.add(phase.toString());

        UserRepo.SaveRoom(room);

        return "1";


    }

    @GetMapping(value = "/GetTopics/{RoomID}")
    public ArrayList<String> GetRoomTopics(@PathVariable("RoomID") String RoomID) {

        Room room = UserRepo.GetRoom(RoomID);

        return room.getRoomTopics();

    }

    @GetMapping(value = "/GetAccessibility/{RoomID}")
    public String GetRoomAccessibility(@PathVariable("RoomID") String RoomID) {

        Room room = UserRepo.GetRoom(RoomID);

        return room.getRoomAccessibility();

    }

    @GetMapping(value = "/GetLang/{RoomID}")
    public String GetRoomLang(@PathVariable("RoomID") String RoomID) {

        Room room = UserRepo.GetRoom(RoomID);

        return room.getRoomLanguage();

    }

    @GetMapping(value = "/GetCreateDate/{RoomID}")
    public String GetRoomCreateDate(@PathVariable("RoomID") String RoomID) {

        Room room = UserRepo.GetRoom(RoomID);

        return room.getRoomCreateDate();

    }

    @GetMapping(value = "/GetCircle/{RoomID}")
    public String GetRoomCircle(@PathVariable("RoomID") String RoomID) {

        Room room = UserRepo.GetRoom(RoomID);

        String circleID = room.getCircleIDs();

        //get the circle object and return everything about the circle...

        return room.getRoomLanguage();

    }

    @GetMapping(value = "/GetRoomPhase/{RoomID}")
    public ArrayList<String> GetRoomPhases(@PathVariable("RoomID") String RoomID) {

        Room room = UserRepo.GetRoom(RoomID);

        return room.getRoomPhases();

    }

    @GetMapping(value = "/GetRoomObject/{RoomID}")
    public String GetRoomObject(@PathVariable("RoomID") String RoomID) {

        Room room = UserRepo.GetRoom(RoomID);

        return room.getRoomObject();

    }

    //popular replays...
    //similar rooms
    //



}
