package io.github.danniod.fish4j.api;

import io.github.danniod.fish4j.entites.FishPiUser;
import io.github.danniod.fish4j.entites.Storage;
import io.github.danniod.fish4j.param.MessageParam;
import io.github.danniod.fish4j.param.auth.UserApiParam;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApiServiceTest {


    private FishApi fishApi;

    private UserApiParam user;
    private String apiKey;

    @BeforeEach
    public void setup() {
        fishApi = new FishApiImpl(retrofit());
        user = UserApiParam.builder().nameOrEmail("dannio").userPassword("28ed8dc48145b6a36683945702b9d930").build();
        apiKey = "l9quk9pZlEGWorlePzeN5kI3ImgThjHJ";
    }

    private Retrofit retrofit() {
        return new Retrofit.Builder()
                .client(customUaClient())
                .baseUrl("https://fishpi.cn/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    private OkHttpClient customUaClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .removeHeader("User-Agent")
                            .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36")
                            .build();
                    return chain.proceed(request);
                }).build();
        return httpClient;
    }

    @Test
    @SneakyThrows
    public void getKeyTest() {
        String apiKey = fishApi.getApiKey(user);
        assertNotNull(apiKey);
        System.out.println(apiKey);
    }


    @Test
    @SneakyThrows
    public void getUserTest() {
        final FishPiUser user1 = fishApi.getUser(fishApi.getApiKey(user));
        assertNotNull(user1);

    }

    @Test
    @SneakyThrows
    public void sendMessageTest() {
        fishApi.sendMessage(MessageParam.builder().apiKey("FgKt3UMtyNiimukgWBqYyzJp4VrUPKVd").content("test").build());

    }

    @Test
    @SneakyThrows
    public void uploadTest() {
        final long begin = System.currentTimeMillis();
        File file = new File("/Users/danny/Desktop/animate.gif");
        final Storage upload = fishApi.upload(file);
        System.out.println(upload);
        System.out.println(System.currentTimeMillis() - begin);
    }
}
