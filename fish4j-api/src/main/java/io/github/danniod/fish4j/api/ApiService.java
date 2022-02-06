package io.github.danniod.fish4j.api;

import io.github.danniod.fish4j.entites.FishPiUser;
import io.github.danniod.fish4j.param.MessageParam;
import io.github.danniod.fish4j.param.RedPacketOpenParam;
import io.github.danniod.fish4j.param.auth.UserApiParam;
import io.github.danniod.fish4j.response.base.Result;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    @POST("/api/getKey")
    Call<Result<String>> getKey(@Body UserApiParam param);

    @GET("/api/user")
    Call<Result<FishPiUser>> getUser(@Query("apiKey") String apiKey);

    @GET("user/{username}")
    Call<Object> getUserByName(@Path("username")String username);


    @POST("/chat-room/send")
    Call<Result<Void>> sendMessage(@Body MessageParam message);


    Call<Result<Object>> openRedPocket(@Body RedPacketOpenParam openRedPacket);
}
