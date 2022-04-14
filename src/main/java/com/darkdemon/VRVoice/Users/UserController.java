package com.darkdemon.VRVoice.Users;

import com.darkdemon.VRVoice.Constants.ConstantController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserRepository UserRepo;

    @Autowired
    User User;

    @PostMapping(value = "/UserCreation")
    public String CreateUser(@RequestBody String Json) throws Exception{

        JSONObject jsonObject = new JSONObject(Json);

        JSONObject UserBaseInfo = jsonObject.getJSONObject(ConstantController.UserBaseInfo);
        JSONObject UserDataObject = jsonObject.getJSONObject(ConstantController.UserData);

        JSONObject UserBaseValue = UserBaseInfo.getJSONObject("value");

        String email = UserBaseValue.getString(ConstantController.Email);

        String phone = UserBaseValue.getString(ConstantController.PhoneNumber);

        User.setUserID(UUID.randomUUID().toString());

        User.setEmail(email);

        User.setPhoneNumber(phone);

        String UserData = UserRepo.NodeWithKeys(UserDataObject, ConstantController.UserData);

        User.setUserObject(UserData);

        boolean savedUser = UserRepo.SaveUser(User);

        if(savedUser){return "1";}

        else{return "-1";}

    }

    //This is only to update single data and not arrays which are placed in the userdata.
    @PostMapping(value = "/UpdateUserData/{UserID}/{newValue}/{dataToChange}")
    public String UpdateUserDataValue(@PathVariable("UserID") String UserID,@PathVariable("newValue") String newValue,@PathVariable("dataToChange") String dataToChange) {

        User user = UserRepo.GetUser(UserID);

        String userdata = user.getUserObject();

        String updatedData = UserRepo.UpdateUserDataValue(userdata,newValue,dataToChange);

        if(updatedData.equals("-1"))
        {
            return "-1";
        }
        else
        {
            User.setUserObject(updatedData);

            UserRepo.UpdateUser(user);

            return "1";

        }

    }
    //This updates the array which is placed in userdata.
    @PostMapping(value = "/UpdateUserArray/{UserID}/{newValue}/{dataToChange}")
    public String UpdateUserArray(@PathVariable("UserID") String UserID, @PathVariable("RoomID") String newValue, @PathVariable("dataToChange") String dataToChange){

        User user = UserRepo.GetUser(UserID);
        String userdata = user.getUserObject();

        String updatedData = UserRepo.UpdateUserArray(userdata, newValue, dataToChange);

        if(updatedData.equals("-1")){
            return "-1";
        }else{
            User.setUserObject(updatedData);

            UserRepo.UpdateUser(user);

            return "1";

        }


    }






    @GetMapping(value = "/InternetCheck")
    public String InternetCheck(){

        return "1";


    }

}
