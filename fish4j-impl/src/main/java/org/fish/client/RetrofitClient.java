package org.fish.client;

import lombok.SneakyThrows;
import org.fish.response.base.Result;
import org.fish.exception.FishApiException;
import retrofit2.Call;
import retrofit2.Response;

public class RetrofitClient {


    @SneakyThrows
    public static <T> Result<T> execute(Call<Result<T>> instance) {
        Response<Result<T>> response = instance.execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new FishApiException("api execute fail");
        }
        if (!response.body().isSuccess()) {
            throw new FishApiException(response.body().getCode(), response.body().getMsg());
        }
        return response.body();
    }

}