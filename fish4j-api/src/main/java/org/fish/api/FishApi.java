package org.fish.api;

import org.fish.param.MessageParam;
import org.fish.param.RedPacketOpenParam;
import org.fish.param.RedPacketSendParam;
import org.fish.param.auth.UserApiParam;
import org.fish.entites.FishPiUser;

public interface FishApi {


    String getApiKey(UserApiParam param);

    FishPiUser getUser(String apiKey);

    Object getUserByName(String username);



    Boolean sendMessage(MessageParam message);

    Boolean sendRedPocket(RedPacketSendParam redPocket);

    Object openRedPocket(RedPacketOpenParam openRedPacket);
}
