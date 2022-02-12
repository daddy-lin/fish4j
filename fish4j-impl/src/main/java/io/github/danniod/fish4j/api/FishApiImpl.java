package io.github.danniod.fish4j.api;

import io.github.danniod.fish4j.client.RetrofitClient;
import io.github.danniod.fish4j.entites.FishPiUser;
import io.github.danniod.fish4j.entites.Storage;
import io.github.danniod.fish4j.param.MessageParam;
import io.github.danniod.fish4j.param.RedPacketOpenParam;
import io.github.danniod.fish4j.param.RedPacketSendParam;
import io.github.danniod.fish4j.param.auth.UserApiParam;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

import java.io.File;

public class FishApiImpl implements FishApi {

    private final ApiService apiService;

    public FishApiImpl(Retrofit retrofit) {
        apiService = retrofit.create(ApiService.class);
    }


    @Override
    public String getApiKey(UserApiParam param) {
        return RetrofitClient.execute(apiService.getKey(param)).getKey();
    }

    @Override
    public FishPiUser getUser(String apiKey) {
        return RetrofitClient.execute(apiService.getUser(apiKey)).getData();
    }

    @Override
    public Object getUserByName(String username) {
        return null;
    }

    @Override
    public Boolean sendMessage(MessageParam message) {
        RetrofitClient.execute(apiService.sendMessage(message));
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
        return RetrofitClient.execute(apiService.openRedPocket(openRedPacket));
    }

    @Override
    public Storage upload(File file) {
     return RetrofitClient.execute(apiService.upload(MultipartBody.Part.createFormData("file[]",
                file.getName(),
                RequestBody.create(MediaType.parse("multipart/form-data"), file)))).getData();
    }
}
