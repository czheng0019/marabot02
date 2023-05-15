package Music;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("music_queue")){
            final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());
            final BlockingQueue<AudioTrack> queue = musicManager.scheduler.queue;
            int trackCount = Math.min(queue.size(), 10);
            List<AudioTrack> trackList = new ArrayList<>(queue);

            OptionMapping count = e.getOption("count");

            if(count != null){
                int num = count.getAsInt();
                trackCount = num;
            }

            MessageCreateAction messageAction = e.getChannel().sendMessage("**Current Queue:**\n");

            for(int i = 0; i < trackCount; i++){
                AudioTrack track = trackList.get(i);
                AudioTrackInfo info = track.getInfo();

                messageAction.addContent("#")
                        .addContent(String.valueOf(i + 1))
                        .addContent("` ")
                        .addContent(info.title)
                        .addContent(" by ")
                        .addContent(info.author)
                        .addContent("` [`")
                        .addContent(String.format("%02d:%02d:%02d",
                                TimeUnit.MILLISECONDS.toHours(track.getDuration()),
                                TimeUnit.MILLISECONDS.toMinutes(track.getDuration()) -
                                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(track.getDuration())),
                                TimeUnit.MILLISECONDS.toSeconds(track.getDuration()) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(track.getDuration()))))
                        .addContent("`]\n");
            }

            messageAction.queue();
        }
    }

}
