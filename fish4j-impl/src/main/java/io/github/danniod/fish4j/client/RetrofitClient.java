package io.github.danniod.fish4j.client;

import io.github.danniod.fish4j.exception.FishApiException;
import io.github.danniod.fish4j.response.base.Result;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitClient {


    public static <T> T execute(Call<T> instance) throws FishApiException, IOException {
        Response<T> response = instance.execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new FishApiException(response.code(), response.message());
        }
        if (instance instanceof Result) {
            final Result<?> body = (Result<?>) response.body();
            if (!body.isSuccess()) {
                throw new FishApiException(body.getCode(), body.getMsg());
            }
        }
        return response.body();
    }

}
