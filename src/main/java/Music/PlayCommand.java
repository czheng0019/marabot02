package Music;

//import Music.SpotifyAPI;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.managers.AudioManager;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Timer;

public class PlayCommand extends ListenerAdapter {

    String link, trackUrl, ytId, spotifyId;
    String[] parse;
    Timer timer = new Timer();
    static ArrayList<String> shuffledTracks = new ArrayList<>();
    static ArrayList<String> videoIdList = new ArrayList<>();
//    SpotifyAPI spotifyAPI;

    static boolean repeat = false;

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){

//        org.apache.hc.core5.http.ParseException ex = new org.apache.hc.core5.http.ParseException();
//        System.out.println(ex);
//        try{
//            spotifyAPI = new SpotifyAPI(shuffledTracks);
//        } catch (ParseException ex){
//            ex.printStackTrace();
//        }


        Member member = e.getMember();
//        GuildVoiceState voiceState = member.getVoiceState();
        AudioManager manager = e.getGuild().getAudioManager();
        GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());

        if(e.getName().equalsIgnoreCase("music_play")){
            if(!manager.isConnected()){
                manager.openAudioConnection(e.getMember().getVoiceState().getChannel());
            }

//            e.getChannel().sendMessage(link).queue();

//            if(!e.getMessage().getContentRaw().contains("youtube") && !e.getMessage().getContentRaw().contains("spotify")){
//                e.getChannel().sendMessage("this is not a youtube link").queue();
//            } else if(e.getMessage().getContentRaw().contains("&") && e.getMessage().getContentRaw().contains("youtube")){
//                link = e.getMessage().getContentRaw().substring(9, e.getMessage().getContentRaw().indexOf("&"));
//            } else if (e.getMessage().getContentRaw().contains("youtube")){
//                link = e.getMessage().getContentRaw().substring(9);
//            } else if (e.getMessage().getContentRaw().contains("spotify")){
//                link = e.getMessage().getContentRaw();
//                spotifyId = getSpotifyId(link);
////                System.out.println(spotifyId);
//                shuffledTracks = SpotifyAPI.getShuffledTracks(spotifyId);
////                System.out.println(shuffledTracks);
//                videoIdList = YoutubeAPI.getYoutubeLink(shuffledTracks);
//                System.out.println(videoIdList);
//                link = "https://www.youtube.com/watch?v=" + videoIdList.get(0);
//            } else {
//                link = "https://www.youtube.com/watch?v=hmjAoI6qRM0";
//            }
            OptionMapping given = e.getOption("link");
            String link;
            if(given == null){
                String part = given.getAsString();
                if(part.contains("spotify")){
                    spotifyId = getSpotifyId(part);
                    System.out.println(spotifyId);
                    shuffledTracks = SpotifyAPI.getShuffledTracks(spotifyId);
                    System.out.println(shuffledTracks);
                    videoIdList = YoutubeAPI.getYoutubeLink(shuffledTracks);
                    System.out.println(videoIdList);
                    link = "https://www.youtube.com/watch?v=" + videoIdList.get(0);
                } else {
                    link = part;
                }
            } else {
                link = "https://www.youtube.com/watch?v=hmjAoI6qRM0";
            }

            
            PlayerManager.getInstance()
                  .loadAndPlay(e.getChannel().asTextChannel(), link);
            musicManager.scheduler.repeat = false;

//            String link = String.join(" ", e.getMessage().getContentRaw().substring(8));
//
//            if(!isUrl(link)){
//                link = "ytsearch:" + link;
//            }



//                      .loadAndPlay(e.getChannel(), "https://www.youtube.com/watch?v=y1ofrzyv1Io"); //gymnoedie 10 hours

//            if(!selfVoiceState.inVoiceChannel()){
//                e.getChannel().sendMessage("im not in vc dummy").queue();
//                return;
//   }

//            if(!memberVoiceState.getChannel().equals(selfVoiceState.getChannel())){
//                e.getChannel().sendMessage("cant play music for u if we aint in same vc").queue();
//            }



//            .loadAndPlay(e.getChannel(), "https://www.youtube.com/watch?v=y1ofrzyv1Io"); //gymnoedie 10 hours

        }

    }

    private boolean isUrl(String url){
        try{
            new URI(url);
            return true;
        } catch (URISyntaxException e){
            return false;
        }
    }

    public String getSpotifyId(String link){
        if(link.contains("/playlist/")){
            return link.substring(link.indexOf("/playlist/") + 10, link.indexOf("?"));
        } else {
            return null;
        }
    }

//    public void onGuildVoiceJoin(GuildVoiceJoinEvent e){
//        AudioManager manager = e.getGuild().getAudioManager();
//        if(e.getChannelJoined().equals(manager.getConnectedChannel())){
//        }
//    }
//    public void onGuildVoiceLeave(GuildVoiceLeaveEvent e){
//        AudioManager manager = e.getGuild().getAudioManager();
//        if(e.getChannelLeft().equals(manager.getConnectedChannel())){
//        }
//    }


    //            String[] parts = e.getMessage().getContentRaw().split(" ");
//            System.out.println(parts);
//            String link = getName().join(" ", musicTest.getArgs());
//            System.out.println(musicTest.getArgs());
//            if(musicTest.getArgs() == null){
//                e.getChannel().sendMessage("args is null again, u stupid mara");
//                return;
//            }
//            if(!isUrl(link)){
//                link = "ytsearch:" + link;
//            }

//    public String getName(){
//        return Constants.prefix + "play";
//    }
//    public List<String> getArgs(){
//        return this.args;
//    }
}
