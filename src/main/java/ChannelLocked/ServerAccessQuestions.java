package ChannelLocked;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class ServerAccessQuestions extends ListenerAdapter {

    final long CHANNELID = 799888902646136872L;

    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        if(WelcomeDeparture.noAccess == true){
            e.getGuild().getTextChannelById(799888902646136872L).sendMessage("Answer these questions, " + e.getMember().getAsMention() + " and a mod/admin will review them\n" +
                    "1- who invited you to this server?\n" +
                    "2- what is the current time for you? (optional! so we know when ppl are active to play games)\n" +
                    "3- when is your birthday? (this is optional! u dont have to tell year either!! if u tell us the day, we'll say happy birthday on your birthday :D)").queue();
            WelcomeDeparture.noAccess = false;
        }
    }

    public void onMessageReceived(MessageReceivedEvent e) {
        List<Member> mentionedMembers = e.getMessage().getMentions().getMembers();

        //            if(e.getMessage().getContentRaw().toLowerCase().equals("nyoom")){

        if (e.getChannel().asTextChannel().getIdLong() == CHANNELID) {
            Long memberID = mentionedMembers.get(0).getUser().getIdLong();
            for (Role role : e.getMember().getRoles()) {
                if (role.getName().startsWith("no access")) {
                    if (memberID == 579708384555565078L || memberID == 645485768843984906L) {
                        e.getChannel().sendMessage("Answer these questions, " + e.getMember().getAsMention() + " and a mod/admin will review them\n" +
                                "1- who invited you to this server?\n" +
                                "2- what is the current time for you? (optional! so we know when ppl are active to play games)\n" +
                                "3- when is your birthday? (this is optional! u dont have to tell year either!! if u tell us the day, we'll say happy birthday on your birthday :D)").queue();
                    }
                }
            }

        }
    }

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if (e.getName().equalsIgnoreCase("allow_in")) {
            OptionMapping given = e.getOption("user");
            Long memberID = given.getMentions().getMembers().get(0).getIdLong();
            e.getGuild().removeRoleFromMember(UserSnowflake.fromId(memberID), e.getJDA().getRoleById(799890881763082270L)).queue();
            e.getGuild().addRoleToMember(UserSnowflake.fromId(memberID), e.getJDA().getRoleById(776310265892306955L)).queue();
            e.reply("<@" + memberID + ">, read and accept <#772657764799217695> to gain access to the rest of the server. also, go check out " +
                    "<#799745668246798348> to get some roles").queue();
        }
        if(e.getName().equalsIgnoreCase("deny_access")) {
            OptionMapping given = e.getOption("user");
            Long memberID = given.getMentions().getMembers().get(0).getIdLong();

            if(memberID == 579708384555565078L){
                e.getChannel().sendMessage("u tryna kick mara?").queue();
                return;
            }

            if(memberID == 645485768843984906L){
                e.getChannel().sendMessage("why u tryna harm yuz? u wanna fight?").queue();
                return;
            }

            e.getGuild().kick(given.getMentions().getMembers().get(0)).queue();
            e.getGuild().getDefaultChannel().asTextChannel().sendMessage("member has been reviewed by mods and admins and denied access from server").queue();
        }
    }
}
