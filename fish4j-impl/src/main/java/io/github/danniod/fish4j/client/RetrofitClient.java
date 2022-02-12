package io.github.danniod.fish4j.client;

import io.github.danniod.fish4j.exception.FishApiException;
import lombok.SneakyThrows;
import io.github.danniod.fish4j.response.base.Result;
import retrofit2.Call;
import retrofit2.Response;

public class RetrofitClient {


    @SneakyThrows
    public static <T> Result<T> execute(Call<Result<T>> instance) {
        Response<Result<T>> response = instance.execute();
        if (!response.isSuccessful() || response.body() == null) {
            throw new FishApiException(response.code(), response.message());
        }
        if (!response.body().isSuccess()) {
            throw new FishApiException(response.body().getCode(), response.body().getMsg());
        }
        return response.body();
    }

}
