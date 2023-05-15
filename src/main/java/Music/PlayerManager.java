package Music;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PlayerManager {
    private static PlayerManager INSTANCE;
    private final Map<Long, GuildMusicManager> musicManager;
    private final AudioPlayerManager audioPlayerManager;
    private EmbedBuilder embedBuilder =  new EmbedBuilder();

    public PlayerManager(){
        this.musicManager = new HashMap<>();
        this.audioPlayerManager = new DefaultAudioPlayerManager();

        AudioSourceManagers.registerRemoteSources(this.audioPlayerManager);
        AudioSourceManagers.registerLocalSource(this.audioPlayerManager);
    }

    public GuildMusicManager getMusicManager(Guild guild){
        return this.musicManager.computeIfAbsent(guild.getIdLong(), (guildId) -> {
            final GuildMusicManager guildMusicManager = new GuildMusicManager(this.audioPlayerManager);

            guild.getAudioManager().setSendingHandler(guildMusicManager.getSendHandler());

            return guildMusicManager;
        });
    }

    public void loadAndPlay(TextChannel channel, String trackUrl){
        final GuildMusicManager musicManager = this.getMusicManager(channel.getGuild());

        this.audioPlayerManager.loadItemOrdered(musicManager, trackUrl, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                musicManager.scheduler.queue(track);
                embedBuilder.clear();
                embedBuilder.setTitle("Adding to the queue:")
                        .setDescription("`" + track.getInfo().title + "`")
                        .addField("Author", track.getInfo().author, false)
                        .addField("Duration", String.format("%02d:%02d:%02d",
                                TimeUnit.MILLISECONDS.toHours(track.getDuration()),
                                TimeUnit.MILLISECONDS.toMinutes(track.getDuration()) -
                                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(track.getDuration())),
                                TimeUnit.MILLISECONDS.toSeconds(track.getDuration()) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(track.getDuration()))), true);
                channel.sendMessageEmbeds(embedBuilder.build()).queue();
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                long time = 0;
                final List<AudioTrack> tracks = playlist.getTracks();
                embedBuilder.clear();
                embedBuilder.setTitle("Adding to the queue:")
                        .appendDescription(playlist.getName());
                for(final AudioTrack track : tracks){
                    musicManager.scheduler.queue(track);
                    time += track.getDuration();
                }
                embedBuilder.addField("Tracks", String.valueOf(tracks.size()), false)
                        .addField("Duration", String.format("%02d:%02d:%02d",
                                TimeUnit.MILLISECONDS.toHours(time),
                                TimeUnit.MILLISECONDS.toMinutes(time) -
                                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(time)),
                                TimeUnit.MILLISECONDS.toSeconds(time) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(time))), true);
                channel.sendMessageEmbeds(embedBuilder.build()).queue();
            }

            @Override
            public void noMatches() {

            }

            @Override
            public void loadFailed(FriendlyException e) {

            }
        });
    }

    public static PlayerManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new PlayerManager();
        }
        return INSTANCE;
    }
}
