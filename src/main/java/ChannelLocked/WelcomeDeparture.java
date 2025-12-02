package ChannelLocked;

import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteCreateEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.HashMap;

public class WelcomeDeparture extends ListenerAdapter {

    boolean found = false, invite = false;
    HashMap<String, Integer> inviteMap = new HashMap<>();
    public static boolean noAccess = false;

    final long GUILDID = 751686684969664575L;

    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        e.getGuild().addRoleToMember(e.getMember(), e.getJDA().getRoleById(799491778998042624L)).queue();
        e.getGuild().getDefaultChannel().asTextChannel().sendMessage("Hey " + e.getMember().getAsMention() + ", welcome to the server! We hope you enjoy your stay!").queue();
    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent e){
        if(e.getGuild().getIdLong() == GUILDID) {
            String user = e.getUser().getAsTag();
            e.getGuild().getDefaultChannel().asTextChannel().sendMessage(user + " left the server... RIP").queue();
        }

    }


}
