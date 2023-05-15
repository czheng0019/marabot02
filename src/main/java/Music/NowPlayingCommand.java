package Music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NowPlayingCommand extends ListenerAdapter {
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("music_now_playing")){
            final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());
            final AudioPlayer audioPlayer = musicManager.audioPlayer;
            final AudioTrack track = audioPlayer.getPlayingTrack();

            if(track == null){
                e.getChannel().sendMessage("no track playing currently").queue();
                return;
            }

            AudioTrackInfo info = track.getInfo();
            e.getChannel().sendMessageFormat("now playing: `%s` by `%s`", info.title, info.author).queue();
        }
    }
}
