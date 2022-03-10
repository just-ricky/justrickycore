package com.github.just_ricky.justrickycore.sync.network;

import com.github.just_ricky.justrickycore.sync.SyncHandler;
import com.github.just_ricky.justrickycore.sync.SyncResponse;
import com.github.just_ricky.justrickycore.sync.network.query.QueryParamMutator;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class SyncRestHandler implements SyncHandler {

    private static final String SYNC_START_URL = "http://localhost:3000/api/profile/sync/complete";

    @Override
    public CompletableFuture<SyncResponse> sync(UUID uuid, String code) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(new QueryParamMutator(SYNC_START_URL)
                        .addParam("code", code)
                        .addParam("uuid", uuid.toString())
                        .build())
                .build();

        return CompletableFuture.supplyAsync(() -> {
            try (Response response = client.newCall(request).execute()) {
                String responseBody = Objects.requireNonNull(response.body()).string();

                // convert to json
                JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

                // create response from object
                return new SyncResponse(jsonObject.get("error").getAsBoolean(), jsonObject.get("message").getAsString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
