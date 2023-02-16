package com.example.vizsgaremek_javafx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHandler {

    private RequestHandler(){}

    public static Response get(String url) throws IOException{
        HttpURLConnection connection=setupConnection(url);
        connection.setRequestMethod("GET");
        return getResponse(connection);
    }


    private static HttpURLConnection setupConnection(String url) throws IOException {
        URL urlObj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }

    private static Response getResponse(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        InputStream is = null;
        if (responseCode < 400){
            is = connection.getInputStream();
        } else {
            is = connection.getErrorStream();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            builder.append(line).append(System.lineSeparator());
            line = br.readLine();
        }
        br.close();
        is.close();
        String content = builder.toString().trim();
        return new Response(responseCode, content);
    }
}
