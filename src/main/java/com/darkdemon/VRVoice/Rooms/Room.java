package com.darkdemon.VRVoice.Rooms;

//room can be made live again by the person who created it. Then other users can join the room
//

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;

@DynamoDBTable(tableName = "Room")
public class Room implements IRoom{

    private String RoomID;

   private String RoomAccessibility;

   private ArrayList<String> RoomTopics;

   private String CircleID;

   private ArrayList<String> RoomPhases;

   private String RoomLanguage;

   private String RoomCreateDate;





    private String RoomObject;


    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "RoomID")
    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String roomID) {
        RoomID = roomID;
    }

    @DynamoDBAttribute(attributeName = "Info")
    public String getRoomObject() {
        return RoomObject;
    }

    public void setRoomObject(String roomObject) {
        RoomObject = roomObject;
    }

    @DynamoDBAttribute(attributeName = "Access")
    public String getRoomAccessibility() {
        return RoomAccessibility;
    }

    public void setRoomAccessibility(String roomAccessibility) {
        RoomAccessibility = roomAccessibility;
    }

    @DynamoDBAttribute(attributeName = "Topics")
    public ArrayList<String> getRoomTopics() {
        return RoomTopics;
    }

    public void setRoomTopics(ArrayList<String> roomTopics) {
        RoomTopics = roomTopics;
    }

    @DynamoDBAttribute(attributeName = "Circle ID")
    public String getCircleIDs() {
        return CircleID;
    }

    public void setCircleIDs(String circleIDs) {
        CircleID = circleIDs;
    }

    @DynamoDBAttribute(attributeName = "Phase")
    public ArrayList<String> getRoomPhases() {
        return RoomPhases;
    }

    public void setRoomPhases(ArrayList<String> roomPhases) {
        RoomPhases = roomPhases;
    }

    @DynamoDBAttribute(attributeName = "Lang")
    public String getRoomLanguage() {
        return RoomLanguage;
    }

    public void setRoomLanguage(String roomLanguage) {
        RoomLanguage = roomLanguage;
    }

    @DynamoDBAttribute(attributeName = "Date")
    public String getRoomCreateDate() {
        return RoomCreateDate;
    }

    public void setRoomCreateDate(String roomCreateDate) {
        RoomCreateDate = roomCreateDate;
    }
}
