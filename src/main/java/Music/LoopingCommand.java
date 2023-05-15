package Music;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LoopingCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("music_loop")){
            final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(e.getGuild());
            final boolean nowRepeating = !musicManager.scheduler.repeat;
            musicManager.scheduler.repeat = nowRepeating;
            e.reply(nowRepeating ? "now looping" : "now not looping").queue();
        }
    }
}
