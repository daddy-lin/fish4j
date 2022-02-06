package io.github.danniod.fish4j.api;

import io.github.danniod.fish4j.entites.FishPiUser;
import io.github.danniod.fish4j.param.RedPacketOpenParam;
import io.github.danniod.fish4j.param.auth.UserApiParam;
import io.github.danniod.fish4j.param.MessageParam;
import io.github.danniod.fish4j.param.RedPacketSendParam;

public interface FishApi {


    String getApiKey(UserApiParam param);

    FishPiUser getUser(String apiKey);

    Object getUserByName(String username);



    Boolean sendMessage(MessageParam message);

    Boolean sendRedPocket(RedPacketSendParam redPocket);

    Object openRedPocket(RedPacketOpenParam openRedPacket);
}
