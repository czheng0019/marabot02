package Music;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsItemsRequest;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.net.URI;
import java.util.*;

public class SpotifyAPI {

    static Dotenv config = Dotenv.configure().load();
    static final String clientId = config.get("SPOTIFY_CLIENT_ID");
    static final String clientSecret = config.get("SPOTIFY_CLIENT_SECRET");
    private static final URI redirectUri = SpotifyHttpManager.makeUri("https://example.com/redirect");

    public static ArrayList<String> shuffledTracks = new ArrayList<>();

    private static String playlistId = "1CPaGPrxMUMUdmgaLsjU3f";
//    private static String playlistId = "58S0SsETosaNwF2af51xGN";



    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();

    public static ArrayList<String> getShuffledTracks(String playlistId){
        try{
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(playlistId).build();


            final Playlist playlist = getPlaylistRequest.execute();
            int totalRequests = playlist.getTracks().getTotal() / 100 + 1;
            PlaylistTrack[] trackItems;
            Paging<PlaylistTrack> playlistItems;
//            System.out.println(playlist.getName());
//            System.out.println(playlist.getTracks().getTotal());
//            System.out.println(totalRequests);

            GetPlaylistsItemsRequest[] getPlaylistsItemsRequest = new GetPlaylistsItemsRequest[totalRequests];

            for(int i = 0; i < totalRequests; i++) {
                getPlaylistsItemsRequest[i] = spotifyApi.getPlaylistsItems(playlistId).offset(100*i).build();
                playlistItems = getPlaylistsItemsRequest[i].execute();
                trackItems = playlistItems.getItems();
                for(PlaylistTrack t : trackItems){
                    shuffledTracks.add(t.getTrack().getName() + " - " + t.getTrack().toString().substring(t.getTrack().toString().indexOf("ArtistSimplified(name=") + 22, t.getTrack().toString().indexOf(", external")));
                }
            }
            Collections.shuffle(shuffledTracks);

        } catch (IOException | ParseException | SpotifyWebApiException e) {
            e.printStackTrace();
        }
        return shuffledTracks;
    }

    public static void main(String[] args){
        try{
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            GetPlaylistRequest getPlaylistRequest = spotifyApi.getPlaylist(playlistId).build();


            final Playlist playlist = getPlaylistRequest.execute();
            int totalRequests = playlist.getTracks().getTotal() / 100 + 1;
            PlaylistTrack[] trackItems;
            Paging<PlaylistTrack> playlistItems;
            System.out.println(playlist.getName());
            System.out.println(playlist.getTracks().getTotal());
            System.out.println(totalRequests);

            GetPlaylistsItemsRequest[] getPlaylistsItemsRequest = new GetPlaylistsItemsRequest[totalRequests];

            for(int i = 0; i < totalRequests; i++) {
                getPlaylistsItemsRequest[i] = spotifyApi.getPlaylistsItems(playlistId).offset(100*i).build();
                playlistItems = getPlaylistsItemsRequest[i].execute();
                trackItems = playlistItems.getItems();
                for(PlaylistTrack t : trackItems){
                    shuffledTracks.add(t.getTrack().getName() + " - " + t.getTrack().toString().substring(t.getTrack().toString().indexOf("ArtistSimplified(name=") + 22, t.getTrack().toString().indexOf(", external")));
                }
            }

            System.out.println(shuffledTracks);

//            for(int y = 0; y < requests.size(); y++){
//                GetPlaylistsItemsRequest getPlaylistsItemsRequest1 = spotifyApi.getPlaylistsItems(playlistId).build();
//                playlistItems = getPlaylistsItemsRequest1.execute();
//                trackItems = playlistItems.getItems();
//                for(PlaylistTrack t : trackItems){
//                    shuffledTracks.add(t.getTrack().getName() + " - " + t.getTrack().toString().substring(t.getTrack().toString().indexOf("ArtistSimplified(name=") + 22, t.getTrack().toString().indexOf(", external")));
//                }
//            }
//
//            GetPlaylistsItemsRequest getPlaylistsItemsRequest2 = spotifyApi.getPlaylistsItems(playlistId).offset(100).build();
//            playlistItems = getPlaylistsItemsRequest2.execute();
//            trackItems = playlistItems.getItems();
//            for(PlaylistTrack t : trackItems){
//                shuffledTracks.add(t.getTrack().getName() + " - " + t.getTrack().toString().substring(t.getTrack().toString().indexOf("ArtistSimplified(name=") + 22, t.getTrack().toString().indexOf(", external")));
//            }


//            for(PlaylistTrack t : tracks){
//                shuffledTracks.add(t.getTrack().getName() + " - " + t.getTrack().toString().substring(t.getTrack().toString().indexOf("ArtistSimplified(name=") + 22, t.getTrack().toString().indexOf(", external")));
//            }
//            Collections.shuffle(shuffledTracks);

        } catch (IOException | ParseException | SpotifyWebApiException e) {
            e.printStackTrace();
        }
        System.out.println(shuffledTracks);
    }
}
