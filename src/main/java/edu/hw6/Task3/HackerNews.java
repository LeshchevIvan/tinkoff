package edu.hw6.Task3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.net.http.HttpClient.newHttpClient;

public class HackerNews {

    public static long[] hackerNewsTopStories() throws URISyntaxException, InterruptedException, IOException {
        try {
            var request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                .GET()
                .build();

            var response = newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            String[] data = response.body().split(",");
            long[] storiesID = new long[data.length];
            for (Integer i = 0; i < data.length; i++) {
                if (i.equals(0)) {
                    storiesID[i] = Long.parseLong(data[i].substring(1, data[i].length()));
                } else if (i.equals(data.length - 1)) {
                    storiesID[i] = Long.parseLong(data[i].substring(0, data[i].length() - 1));
                } else {
                    storiesID[i] = Long.parseLong(data[i]);
                }
            }
            return storiesID;
        } catch (InterruptedException | IOException e) {
            return new long[] {};
        }
    }

    public static String news(long storiesID) throws URISyntaxException, IOException, InterruptedException {
        try {

            var request = HttpRequest.newBuilder()
                .uri(new URI(String.format("https://hacker-news.firebaseio.com/v0/item/%d.json", storiesID)))
                .GET()
                .build();

            var response = newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            Pattern pattern = Pattern.compile("\"title\":\"(.*)\",\"type\"");
            Matcher matcher = pattern.matcher(response.body());
            // Я обнаружил какую то магию. без 53 строчки matcher отказывается находить что-либо. Почему...?
            matcher.find();
            return matcher.group(1);
        } catch (InterruptedException | IOException | URISyntaxException e) {
            return e.toString();
        }
    }

}
