package Music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SkipCommand extends ListenerAdapter {
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("music_skip")){
            final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());
            final AudioPlayer audioPlayer = musicManager.audioPlayer;
            final AudioTrack track = audioPlayer.getPlayingTrack();
            AudioTrackInfo info = track.getInfo();
            e.getChannel().sendMessageFormat("skipping: `%s` by `%s`", info.title, info.author).queue();
            musicManager.scheduler.nextTrack();
        }
    }
}
