package com.darkdemon.VRVoice.Users;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.darkdemon.VRVoice.Constants.ConstantController;

import java.util.ArrayList;


@DynamoDBTable(tableName = "UsersInfo")
public class User {



    private String UserName;
    private ArrayList<String> Followers; //list
    private ArrayList<String> Following; //list
    private String UserBio;
    private String TwitterLink;
    private String InstagramLink;
    private String JoinDate;
    private ArrayList<String> UserCreatedRoomGroups; //list
    private ArrayList<String> UserJoinedRoomGroups; //list
    private ArrayList<String> FavoriteTopics; //list
    private String Email;

    private String Password;


    private String UserObject;

    @DynamoDBAttribute(attributeName = "User Whole Object")
    public String getUserObject() {
        return UserObject;
    }

    public void setUserObject(String userObject) {
        UserObject = userObject;
    }


    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = ConstantController.Email)
    public String getEmail() {
        return Email;
    }

    @DynamoDBAttribute(attributeName = "JoinDate")
    public String getJoinDate() {
        return JoinDate;
    }

    @DynamoDBAttribute(attributeName = "Fav")
    public ArrayList<String> getFavTopics(){return FavoriteTopics;}



    @DynamoDBAttribute(attributeName = "Followers")
    public ArrayList<String> getFollowers() {
        return Followers;
    }


    @DynamoDBAttribute(attributeName = "Following")
    public ArrayList<String> getFollowing() {
        return Following;
    }

    @DynamoDBAttribute(attributeName = "CreatedGroup")
    public ArrayList<String> getUserCreatedRoomGroups() {
        return UserCreatedRoomGroups;
    }

    @DynamoDBAttribute(attributeName = "JoinedGroup")
    public ArrayList<String> getUserJoinedRoomGroups() {
        return UserJoinedRoomGroups;
    }


    public void setFollowers(ArrayList<String> followers) {
        Followers = followers;
    }

    public void setFavTopics(ArrayList<String> topics){FavoriteTopics = topics;}


    public void setFollowing(ArrayList<String> following) {
        Following = following;
    }















    public void setUserCreatedRoomGroups(ArrayList<String> userCreatedRoomGroups) {
        UserCreatedRoomGroups = userCreatedRoomGroups;
    }



    public void setUserJoinedRoomGroups(ArrayList<String> userJoinedRoomGroups) {
        UserJoinedRoomGroups = userJoinedRoomGroups;
    }

    public ArrayList<String> getFavoriteTopics() {
        return FavoriteTopics;
    }

    public void setFavoriteTopics(ArrayList<String> favoriteTopics) {
        FavoriteTopics = favoriteTopics;
    }



    public void setEmail(String email) {
        Email = email;
    }





    public void setJoinDate(String date) {
        JoinDate= date;
    }
}
