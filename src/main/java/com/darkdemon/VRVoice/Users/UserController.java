package com.darkdemon.VRVoice.Users;

import com.darkdemon.VRVoice.Constants.ConstantController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
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

        String joinDate = UserBaseValue.getString(ConstantController.JoinDate);

        User.setEmail(email);

        User.setJoinDate(joinDate);

        String UserData = UserRepo.NodeWithKeys(UserDataObject, ConstantController.UserData);

        User.setUserObject(UserData);

        ArrayList<String> emptyList = new ArrayList<>();

        User.setFavoriteTopics(emptyList);
        User.setFollowers(emptyList);
        User.setFollowing(emptyList);
        User.setUserCreatedRoomGroups(emptyList);
        User.setUserJoinedRoomGroups(emptyList);

        boolean savedUser = UserRepo.SaveUser(User);


         if(savedUser){return "1";}

        else{return "-1";}


    }

    @PostMapping(value = "/UpdateUserData/{UserID}")
    public String UpdateUserData(@PathVariable("UserID") String UserID,@RequestBody String json) throws Exception{

        User user = UserRepo.GetUser(UserID);

        if(user == null){
            return "-1";
        }

        JSONObject jsonObject = new JSONObject(json);
        JSONObject UserDataObject = jsonObject.getJSONObject(ConstantController.UserData);
        String UserData = UserRepo.NodeWithKeys(UserDataObject, ConstantController.UserData);
        User.setUserObject(UserData);
        UserRepo.UpdateUser(user);

        return "1";

    }



    @PostMapping(value = "/AddItem/{UserEmail}/{ItemVal}/{Index}")
    public String AddItemToArray(@PathVariable("UserEmail") String UserID,
                              @PathVariable("ItemVal") String item,@PathVariable("Index") String Index){

        User user = UserRepo.GetUser(UserID);

        switch (Index){
            case "0":
                ArrayList<String> followers = user.getFollowers();
                if(!followers.contains(item)){
                    followers.add(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

            case "1":
                ArrayList<String> following = user.getFollowing();
                if(!following.contains(item)){
                    following.add(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                break;

            case "2":
                ArrayList<String> created = user.getUserCreatedRoomGroups();
                if(!created.contains(item)){
                    created.add(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

            case "3":
                ArrayList<String> joined = user.getUserJoinedRoomGroups();
                if(!joined.contains(item)){
                    joined.add(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

            case "4":
                ArrayList<String> subtopics = user.getFavoriteTopics();
                if(!subtopics.contains(item)){
                    subtopics.add(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

        }



        return "-1";

    }

    @PostMapping(value = "/RemoveItem/{UserEmail}/{ItemVal}/{Index}")
    public String RemoveItemFromArray(@PathVariable("UserEmail") String UserID,
                                 @PathVariable("ItemVal") String item,@PathVariable("Index") String Index){

        User user = UserRepo.GetUser(UserID);

        switch (Index){
            case "0":
                ArrayList<String> followers = user.getFollowers();
                if(followers.contains(item)){
                    followers.remove(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

            case "1":
                ArrayList<String> following = user.getFollowing();
                if(following.contains(item)){
                    following.remove(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

            case "2":
                ArrayList<String> created = user.getUserCreatedRoomGroups();
                if(created.contains(item)){
                    created.remove(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

            case "3":
                ArrayList<String> joined = user.getUserJoinedRoomGroups();
                if(joined.contains(item)){
                    joined.remove(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                 break;

            case "4":
                ArrayList<String> subtopics = user.getFavoriteTopics();
                if(subtopics.contains(item)){
                    subtopics.remove(item);
                    UserRepo.UpdateUser(user);
                    return "1";
                }
                break;

        }





        return "-1";

    }

    @GetMapping(value = "/InternetCheck")
    public String InternetCheck(){

        return "1";


    }
    //____________________________NOT BEING USED_____________________________________________________________________________________________

    //This updates the array which is placed in userdata.
    @PostMapping(value = "/UpdateUserArray/{UserID}/{newValue}/{dataToChange}")
    public String UpdateUserArray(@PathVariable("UserID") String UserID, @PathVariable("newValue") String newValue, @PathVariable("dataToChange") String dataToChange){

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






}
