package org.fish.api;

import org.fish.entites.FishPiUser;
import org.fish.param.MessageParam;
import org.fish.param.RedPacketOpenParam;
import org.fish.param.auth.UserApiParam;
import org.fish.response.base.Result;
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
