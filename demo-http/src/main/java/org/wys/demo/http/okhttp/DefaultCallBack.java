package org.wys.demo.http.okhttp;

import com.google.common.base.Throwables;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author wys
 * @date 2021/11/6
 */
public interface DefaultCallBack extends Callback {
    @Override
    default void onFailure(@NotNull Call call, @NotNull IOException e) {
        throw new RuntimeException("请求错误: " + Throwables.getStackTraceAsString(e));
    }
}
