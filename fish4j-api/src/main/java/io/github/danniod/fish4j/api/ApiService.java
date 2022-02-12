package io.github.danniod.fish4j.api;

import io.github.danniod.fish4j.entites.FishPiUser;
import io.github.danniod.fish4j.entites.Storage;
import io.github.danniod.fish4j.param.MessageParam;
import io.github.danniod.fish4j.param.RedPacketOpenParam;
import io.github.danniod.fish4j.param.auth.UserApiParam;
import io.github.danniod.fish4j.response.base.Result;
import okhttp3.MultipartBody;
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


    @POST("/chat-room/red-packet/open")
    Call<Result<Object>> openRedPocket(@Body RedPacketOpenParam openRedPacket);


    @Multipart
    @POST("/upload")
    Call<Result<Storage>> upload(@Part MultipartBody.Part file);

}
