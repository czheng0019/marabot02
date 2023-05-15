package Music;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class StopCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("music_stop")){
            final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());
            musicManager.scheduler.player.stopTrack();
            musicManager.scheduler.queue.clear();
            musicManager.scheduler.repeat = false;
            e.getChannel().sendMessage("queue has been cleared").queue();
        }
    }
}
