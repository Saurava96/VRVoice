package com.darkdemon.VRVoice.Constants;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ConstantController {


public static String UserBaseInfo = "UserBaseInfo";

public static String UserData = "UserData";

public static String Email = "Email";

public static String PhoneNumber = "PhoneNumber";

public static String BaseRoomID = "BaseRoomID";

}
