package Music;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinLeave extends ListenerAdapter{

//    public void onMessageReceived(MessageReceivedEvent e){
//        if(e.getMessage().getContentRaw().equals(Constants.prefix + "join"){
//
//        }
//    }


    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getUser().isBot()){
            return;
        }
        if(e.getName().equalsIgnoreCase("music_join")){
            Guild guild = e.getGuild();

            Member member = e.getMember();
            GuildVoiceState voiceState = member.getVoiceState();
            VoiceChannel channel = voiceState.getChannel().asVoiceChannel();
            AudioManager manager = guild.getAudioManager();
            e.getChannel().sendMessage("connected to voice channel").queue();
            manager.openAudioConnection(channel);

        }
        if(e.getName().equalsIgnoreCase("music_leave")){
            Guild guild = e.getGuild();
            AudioManager manager = guild.getAudioManager();
            e.getChannel().sendMessage("leaving voice channel").queue();
            manager.closeAudioConnection();


        }
    }

}
