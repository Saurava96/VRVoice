package com.darkdemon.VRVoice.Users;
import com.amazonaws.services.dynamodbv2.datamodeling.*;


@DynamoDBTable(tableName = "UsersInfo")
public class User {


    private String UserID;
    private String UserName;
    private String Followers; //list
    private String Following; //list
    private String UserBio;
    private String TwitterLink;
    private String InstagramLink;
    private String JoinDate;
    private String UserCreatedRoomGroups; //list
    private String UserJoinedRoomGroups; //list
    private String FavoriteTopics; //list
    private String Email;

    private String Password;
    private String PhoneNumber;

    private String UserObject;

    @DynamoDBAttribute(attributeName = "User Whole Object")
    public String getUserObject() {
        return UserObject;
    }

    public void setUserObject(String userObject) {
        UserObject = userObject;
    }

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "User ID")
    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getFollowers() {
        return Followers;
    }

    public void setFollowers(String followers) {
        Followers = followers;
    }

    public String getFollowing() {
        return Following;
    }

    public void setFollowing(String following) {
        Following = following;
    }

    public String getUserBio() {
        return UserBio;
    }

    public void setUserBio(String userBio) {
        UserBio = userBio;
    }

    public String getTwitterLink() {
        return TwitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        TwitterLink = twitterLink;
    }

    public String getInstagramLink() {
        return InstagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        InstagramLink = instagramLink;
    }

    public String getJoinDate() {
        return JoinDate;
    }

    public void setJoinDate(String joinDate) {
        JoinDate = joinDate;
    }

    public String getUserCreatedRoomGroups() {
        return UserCreatedRoomGroups;
    }

    public void setUserCreatedRoomGroups(String userCreatedRoomGroups) {
        UserCreatedRoomGroups = userCreatedRoomGroups;
    }

    public String getUserJoinedRoomGroups() {
        return UserJoinedRoomGroups;
    }

    public void setUserJoinedRoomGroups(String userJoinedRoomGroups) {
        UserJoinedRoomGroups = userJoinedRoomGroups;
    }

    public String getFavoriteTopics() {
        return FavoriteTopics;
    }

    public void setFavoriteTopics(String favoriteTopics) {
        FavoriteTopics = favoriteTopics;
    }

    @DynamoDBAttribute(attributeName = "EmailID")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @DynamoDBAttribute(attributeName = "Phone")
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
