package org.fish.api;

import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.fish.param.auth.UserApiParam;
import org.fish.entites.FishPiUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@Slf4j
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
}