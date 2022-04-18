package com.darkdemon.VRVoice.Users;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.darkdemon.VRVoice.Constants.ConstantController;
import com.google.common.collect.ImmutableMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {


    @Autowired
    DynamoDBMapper Mapper;

    public boolean SaveUser(User userObject){

        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedAttributes =
                ImmutableMap.<String, ExpectedAttributeValue>builder()
                        .put("EmailID", new ExpectedAttributeValue(false))
                        .put("Phone",new ExpectedAttributeValue(false))
                        .build();
        saveExpression.setExpected(expectedAttributes);
        saveExpression.setConditionalOperator(ConditionalOperator.AND);
        try {
            System.out.println("Saving User");
            Mapper.save(userObject, saveExpression);
            return true;
        } catch (ConditionalCheckFailedException e) {

            System.out.println("User already exists");
            return false;

        }


    }

    public String NodeWithKeys(JSONObject json, String keyName){

        String finalKeyName = '"'+keyName+'"';

        HashMap<String, Object> map = new HashMap<>();

        map.put(finalKeyName, json);

        return map.toString().replaceAll("=",":");



    }

    public String UpdateUserDataValue(String userdata, String newValue, String dataToChange){

        try{
            JSONObject json = new JSONObject(userdata);
            JSONObject userdatajson = json.getJSONObject(ConstantController.UserData);
            JSONObject value = userdatajson.getJSONObject("value");

            value.put(dataToChange, newValue);

            return json.toString();

        }catch (Exception e){

            return "-1";

        }

    }

    public String UpdateUserArray(String userdata, String valueToAdd, String dataToChange){

        try{
            JSONObject json = new JSONObject(userdata);
            JSONObject userdatajson = json.getJSONObject(ConstantController.UserData);
            JSONObject value = userdatajson.getJSONObject("value");

            JSONArray arrayToUpdate = value.getJSONArray(dataToChange);

            arrayToUpdate.put(valueToAdd);

            return json.toString();

        }catch (Exception e){

            return "-1";

        }

    }



    public User GetUser(String UserID){

        return Mapper.load(User.class, UserID);

    }

    public void UpdateUser(User user){

        Mapper.save(user);



    }

}
