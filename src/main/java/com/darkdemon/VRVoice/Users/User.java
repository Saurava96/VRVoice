package com.darkdemon.VRVoice.Users;
import com.amazonaws.services.dynamodbv2.datamodeling.*;


@DynamoDBTable(tableName = "UsersInfo")
public class User {


    @DynamoDBAttribute(attributeName = "User Whole Object")
    public String getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(String userInfo) {
        UserInfo = userInfo;
    }

    private String Email;
    private String UserName;
    private String Password;
    private String PhoneNumber;
    private String BaseMemoryID;

    @DynamoDBAttribute(attributeName = "Base Memory ID")
    public String getBaseMemoryID() {
        return BaseMemoryID;
    }

    public void setBaseMemoryID(String baseMemoryID) {
        BaseMemoryID = baseMemoryID;
    }

    private String UserMemories;

    @DynamoDBAttribute(attributeName = "Memories List")
    public String getUserMemories() {
        return UserMemories;
    }

    public void setUserMemories(String userMemories) {
        UserMemories = userMemories;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }



    public void setPassword(String password) {
        Password = password;
    }

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "EmailID")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    private String UserInfo;


    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    private String UserID;

    private  String asas;

}
