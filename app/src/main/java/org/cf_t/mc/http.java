package org.cf_t.mc;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class http {

    public static String get(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(Redirect.NORMAL)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(
                request, BodyHandlers.ofString()
        );
        // System.out.println(response.statusCode());
        // System.out.println(response.body());
        return response.body();
    }
}
