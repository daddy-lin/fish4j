package io.github.danniod.fish4j.api;

import io.github.danniod.fish4j.entites.FishPiUser;
import io.github.danniod.fish4j.entites.Storage;
import io.github.danniod.fish4j.exception.FishApiException;
import io.github.danniod.fish4j.param.MessageParam;
import io.github.danniod.fish4j.param.RedPacketOpenParam;
import io.github.danniod.fish4j.param.RedPacketSendParam;
import io.github.danniod.fish4j.param.auth.UserApiParam;

import java.io.File;
import java.io.IOException;

public interface FishApi {


    String getApiKey(UserApiParam param) throws FishApiException, IOException;

    FishPiUser getUser(String apiKey) throws FishApiException, IOException;

    Object getUserByName(String username) throws FishApiException, IOException;

    Double getLiveness(String apiKey) throws FishApiException, IOException;

    Integer collectLivenessReward(String apiKey) throws FishApiException, IOException;

    Boolean isCollectedLivenessReward(String apiKey) throws FishApiException, IOException;

    Boolean sendMessage(MessageParam message) throws FishApiException, IOException;

    Boolean sendRedPocket(RedPacketSendParam redPocket) throws FishApiException, IOException;

    Object openRedPocket(RedPacketOpenParam openRedPacket) throws FishApiException, IOException;


    Storage upload(File file) throws FishApiException, IOException;

}
