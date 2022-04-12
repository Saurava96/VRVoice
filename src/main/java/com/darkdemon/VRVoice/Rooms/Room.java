package com.darkdemon.VRVoice.Rooms;

//room can be made live again by the person who created it. Then other users can join the room
//

import java.util.List;

public class Room implements IRoom{

    private String RoomID;

    private String RoomName;
    private String RoomGroupOfThisRoom;
    private String RoomCreateDate;
    private String RoomCreatedBy;

    private List<InactiveRoom> InactiveRooms;

    private ActiveRoom ActiveRoom;


    private String UsersWhoVisitedRoom; //list



}
