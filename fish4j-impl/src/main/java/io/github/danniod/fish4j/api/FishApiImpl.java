package io.github.danniod.fish4j.api;

import io.github.danniod.fish4j.client.RetrofitClient;
import io.github.danniod.fish4j.entites.FishPiUser;
import io.github.danniod.fish4j.entites.Storage;
import io.github.danniod.fish4j.entites.chatroom.OpenedRedPocket;
import io.github.danniod.fish4j.exception.FishApiException;
import io.github.danniod.fish4j.param.MessageParam;
import io.github.danniod.fish4j.param.RedPacketOpenParam;
import io.github.danniod.fish4j.param.RedPacketSendParam;
import io.github.danniod.fish4j.param.auth.UserApiParam;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

import java.io.File;
import java.io.IOException;

public class FishApiImpl implements FishApi {

    private final ApiService apiService;

    public FishApiImpl(Retrofit retrofit) {
        apiService = retrofit.create(ApiService.class);
    }


    @Override
    public String getApiKey(UserApiParam param) throws FishApiException, IOException {
        return RetrofitClient.execute(apiService.getKey(param)).getKey();
    }

    @Override
    public FishPiUser getUser(String apiKey) throws FishApiException, IOException {
        return RetrofitClient.execute(apiService.getUser(apiKey)).getData();
    }

    @Override
    public Object getUserByName(String username) throws FishApiException, IOException {
        return null;
    }

    @Override
    public Double getLiveness(String apiKey) throws FishApiException, IOException {
        return RetrofitClient.execute(apiService.getLiveness(apiKey)).get("liveness");
    }

    @Override
    public Integer collectLivenessReward(String apiKey) throws FishApiException, IOException {
        return RetrofitClient.execute(apiService.collectLivenessReward(apiKey)).get("sum");
    }

    @Override
    public Boolean isCollectedLivenessReward(String apiKey) throws FishApiException, IOException {
        return RetrofitClient.execute(apiService.isCollectedLivenessReward(apiKey)).get("isCollectedYesterdayLivenessReward");
    }

    @Override
    public Boolean sendMessage(MessageParam message) throws FishApiException, IOException {
        RetrofitClient.execute(apiService.sendMessage(message));
        return true;
    }

    @Override
    public Boolean sendRedPocket(RedPacketSendParam redPacket) throws FishApiException, IOException {
        return sendMessage(MessageParam.builder()
                .apiKey(redPacket.getApiKey())
                .content(redPacket.toString())
                .build());
    }

    @Override
    public OpenedRedPocket openRedPocket(RedPacketOpenParam openRedPacket) throws FishApiException, IOException {
        return RetrofitClient.execute(apiService.openRedPocket(openRedPacket));
    }

    @Override
    public Storage upload(File file) throws FishApiException, IOException {
     return RetrofitClient.execute(apiService.upload(MultipartBody.Part.createFormData("file[]",
                file.getName(),
                RequestBody.create(MediaType.parse("multipart/form-data"), file)))).getData();
    }
}
