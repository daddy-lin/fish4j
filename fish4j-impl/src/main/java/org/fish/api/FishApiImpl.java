package org.fish.api;

import org.fish.param.MessageParam;
import org.fish.param.RedPacketOpenParam;
import org.fish.param.RedPacketSendParam;
import org.fish.param.auth.UserApiParam;
import org.fish.entites.FishPiUser;
import retrofit2.Retrofit;

import static org.fish.client.RetrofitClient.execute;

public class FishApiImpl implements FishApi {

    private final ApiService apiService;

    public FishApiImpl(Retrofit retrofit) {
        apiService = retrofit.create(ApiService.class);
    }


    @Override
    public String getApiKey(UserApiParam param) {
        return execute(apiService.getKey(param)).getKey();
    }

    @Override
    public FishPiUser getUser(String apiKey) {
        return execute(apiService.getUser(apiKey)).getData();
    }

    @Override
    public Object getUserByName(String username) {
        return null;
    }

    @Override
    public Boolean sendMessage(MessageParam message) {
        execute(apiService.sendMessage(message));
        return true;
    }

    @Override
    public Boolean sendRedPocket(RedPacketSendParam redPacket) {
        return sendMessage(MessageParam.builder()
                .apiKey(redPacket.getApiKey())
                .content(redPacket.toString())
                .build());
    }

    @Override
    public Object openRedPocket(RedPacketOpenParam openRedPacket) {
        return execute(apiService.openRedPocket(openRedPacket));
    }

}
