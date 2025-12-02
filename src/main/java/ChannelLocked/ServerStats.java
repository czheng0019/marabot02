package ChannelLocked;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.*;
import java.util.function.Consumer;

public class ServerStats extends ListenerAdapter {

    Timer timer = new Timer();


    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){

        Guild guild = e.getGuild();

        final List<String> bots = new ArrayList<>();
        final List<String> members = new ArrayList<>();
        long start;
        int elapsedTime;

        final int[] stats = new int[5];

        if(e.getName().equalsIgnoreCase("update_server_stats")) {
            stats[0] = 0;
            final boolean[] change = {false};
            e.getGuild().loadMembers(i -> {
                stats[0]++;
                if (i.getUser().isBot() && (!bots.contains(i.toString()))) {
                    bots.add(i.toString());
                }
            });
            e.getGuild().loadMembers().onSuccess(member -> {
                e.getGuild().getVoiceChannelById(834806762346381405L).getManager().setName("All Members: " + member.size()).queue();
                final int users = member.size() - bots.size();
                e.getGuild().getVoiceChannelById(834806763588288553L).getManager().setName("Members: " + users).queue();
                e.getGuild().getVoiceChannelById(834806764540002401L).getManager().setName("Bots: " + bots.size()).queue();
                e.getGuild().getVoiceChannelById(834806765312016405L).getManager().setName("Roles: " + e.getGuild().getRoles().size() + "/250").queue();
                e.getGuild().getVoiceChannelById(834806766863777832L).getManager().setName("Emojis: " + e.getGuild().getEmojis().size() + "/100").queue();
                stats[0] = member.size(); stats[1] = users; stats[2] = bots.size(); stats[3] = e.getGuild().getRoles().size(); stats[4] = e.getGuild().getEmojis().size();
            });
            e.reply(stats[0] + "").queue();
            timer.schedule( new TimerTask() {
                public void run() {
                    bots.clear();
                    members.clear();
                    change[0] = false;
                    e.getGuild().loadMembers(i -> {
                        if (i.getUser().isBot() && (!bots.contains(i.toString()))) {
                            bots.add(i.toString());
                        }
                        members.add(i.toString());
                    });
                    if(stats[0] != members.size()){
                        change[0] = true;
                        e.getGuild().getTextChannelById(793141509800460318L).sendMessage(members.size() + "").queue();
                        e.getGuild().getTextChannelById(793141509800460318L).sendMessage("member size has changed").queue();
                    }
                    e.getGuild().loadMembers().onSuccess(member -> {
                        if(change[0]){
                            e.getGuild().getVoiceChannelById(834806762346381405L).getManager().setName("All Members: " + members.size()).queue();
                            final int users = members.size() - bots.size();
                            e.getGuild().getVoiceChannelById(834806763588288553L).getManager().setName("Members: " + users).queue();
                            e.getGuild().getVoiceChannelById(834806764540002401L).getManager().setName("Bots: " + bots.size()).queue();
                            e.getGuild().getVoiceChannelById(834806765312016405L).getManager().setName("Roles: " + e.getGuild().getRoles().size() + "/250").queue();
                            e.getGuild().getVoiceChannelById(834806766863777832L).getManager().setName("Emojis: " + e.getGuild().getEmojis().size() + "/100").queue();
                            stats[0] = member.size(); stats[1] = users; stats[2] = bots.size(); stats[3] = e.getGuild().getRoles().size(); stats[4] = e.getGuild().getEmojis().size();
                        }
                    });
                }
            }, 0, 10 * 60 * 1000); //144000 = 24 hours????

        }

    }


}
