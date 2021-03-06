package com.darkdemon.VRVoice.Constants;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ConstantController {


public final static String UserBaseInfo = "UserBaseInfo";

public final static String UserData = "UserData";

public final static String Email = "Email";

public final static String JoinDate = "JoinDate";

public final static String BaseRoomID = "BaseRoomID";

public  final static String RoomPublicInfo = "RoomPublicInfo";

public final static String RoomAccessibility = "RoomAccessibility";

public final static String RoomTopics = "RoomTopics";

public final static String RoomCircle = "RoomCircle";

public final static String RoomLanguage = "RoomLanguage";

public final static String RoomCreateDate = "RoomCreateDate";

public final static String RoomCreatedBy = "RoomCreatedBy";

public final static String RoomInfo = "RoomInfo";

}
