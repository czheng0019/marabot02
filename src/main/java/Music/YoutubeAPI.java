package Music;

//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.googleapis.json.GoogleJsonResponseException;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.gson.GsonFactory;
//
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.youtube.YouTube;
//import com.google.api.services.youtube.model.SearchListResponse;
//import com.google.api.services.youtube.model.SearchResult;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.GeneralSecurityException;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.VideoListResponse;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;

import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class YoutubeAPI {
//    private static final String CLIENT_SECRETS= "client_secret.json";
//    private static final Collection<String> SCOPES =
//            Arrays.asList("https://www.googleapis.com/auth/youtube.force-ssl");

    static Dotenv config = Dotenv.configure().load();
    static String API_KEY = config.get("YOUTUBE_TOKEN");

    public static YouTube getService() throws GeneralSecurityException, IOException {
        return new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
                @Override
                public void initialize(HttpRequest httpRequest) throws IOException {
                }
        }).setApplicationName("MaraBot").build();
    }

    public static ArrayList<String> getYoutubeLink(ArrayList<String> shuffledTracks){
        String videoId, duration, title;
        VideoListResponse responseVideo;
        SearchListResponse responseSearch;
        ArrayList<String> videoIdList = new ArrayList<>();
//        shuffledTracks.add("Inochi no Namae (Spirited Away) - Cat Trumpet"); shuffledTracks.add("Merry Go Round of Life (Howl's Moving Castle) - Cat Trumpet");

        for(int x = 0; x < Math.min(shuffledTracks.size(), 100); x++){
            try {
                YouTube youtubeService = getService();
                // Define and execute the API request
                YouTube.Search.List requestSearch = youtubeService.search()
                        .list("snippet");
                responseSearch = requestSearch.setChannelType("any")
                        .setQ(shuffledTracks.get(x))
                        .setMaxResults((long)1)
                        .setKey(API_KEY)
                        .setType("video")
                        .execute();
                videoId = responseSearch.getItems().get(0).getId().getVideoId();
                title = responseSearch.getItems().get(0).getSnippet().getTitle();
                YouTube.Videos.List requestVideo = youtubeService.videos().list("contentDetails").setId(videoId);
                responseVideo = requestVideo.setKey(API_KEY).execute();
                duration = responseVideo.getItems().get(0).getContentDetails().getDuration();
//                System.out.println(title + " - " + videoId + " - " + duration);
                videoIdList.add(videoId);

            }
            catch (IOException | GeneralSecurityException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return videoIdList;
    }

    public static void main(String[] args) {

        String videoId, duration, title;
        VideoListResponse responseVideo;
        SearchListResponse responseSearch;
        ArrayList<String> shuffledTracks = new ArrayList<>();
        ArrayList<String> videoIdList = new ArrayList<>();
//        shuffledTracks.add("Inochi no Namae (Spirited Away) - Cat Trumpet"); shuffledTracks.add("Merry Go Round of Life (Howl's Moving Castle) - Cat Trumpet");

        for(int x = 0; x < 20; x++){
            try {
                YouTube youtubeService = getService();
                // Define and execute the API request
                YouTube.Search.List requestSearch = youtubeService.search()
                        .list("snippet");
                responseSearch = requestSearch.setChannelType("any")
                        .setQ(shuffledTracks.get(x))
                        .setMaxResults((long)1)
                        .setKey(API_KEY)
                        .setType("video")
                        .execute();
                videoId = responseSearch.getItems().get(0).getId().getVideoId();
                title = responseSearch.getItems().get(0).getSnippet().getTitle();
                YouTube.Videos.List requestVideo = youtubeService.videos().list("contentDetails").setId(videoId);
                responseVideo = requestVideo.setKey(API_KEY).execute();
                duration = responseVideo.getItems().get(0).getContentDetails().getDuration();
                System.out.println(title + " - " + videoId + " - " + duration);
                videoIdList.add(videoId);
            }
            catch (IOException | GeneralSecurityException e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }
}

//    private static final String CLIENT_SECRETS= "/client_secret.json";
//    private static final Collection<String> SCOPES =
//            Arrays.asList("https://www.googleapis.com/auth/youtube.force");
//
//    private static final String APPLICATION_NAME = "MaraBot";
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//
//    public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
//        // Load client secrets.
//        InputStream in = YoutubeAPI.class.getResourceAsStream(CLIENT_SECRETS);
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow =
//                new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
//                        .build();
//        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//    }
//
//    public static YouTube getService() throws GeneralSecurityException, IOException {
//        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        Credential credential = authorize(httpTransport);
//        return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }
//
//    public static void main(String[] args)
//            throws GeneralSecurityException, IOException {
//        YouTube youtubeService = getService();
//        // Define and execute the API request
//        YouTube.Search.List request = youtubeService.search()
//                .list("snippet");
//        SearchListResponse response = request.setMaxResults(25L)
//                .setQ("surfing")
//                .execute();
//        System.out.println(response);
//    }
//}
