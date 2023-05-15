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
    long mara = 579708384555565078L, yuzu = 645485768843984906L, tae = 626819458874343435L, shao = 524349948431564801L, kiwi = 386695418471514116L, caden = 742751974650282026L, solecat = 658693453076758538L, swall = 819707246777991209L, larry = 373945615505424384L, lion = 822916512628998175L;

//    public void onMessageReceived(MessageReceivedEvent e){
//        if(e.getMessage().getContentRaw().equals(Constants.prefix + "getInv")){
//            for(Invite invite : e.getGuild().retrieveInvites().complete()) {
//                inviteMap.put(invite.getInviter().getName(), invite.getUses());
//            }
//            System.out.println(inviteMap.toString());
//            e.getChannel().sendMessage("you can invite now").queue();
//        }
//    }

//    public void onGuildInviteCreate(GuildInviteCreateEvent e){
//        for(Invite invite : e.getGuild().retrieveInvites().complete()) {
//            inviteMap.put(invite.getInviter().getName(), invite.getUses());
//        }
//        System.out.println(inviteMap.toString());
//        //e.getGuild().getTextChannelById(793141509800460318L).sendMessage("you can invite now").queue();
//    }

    public void onGuildMemberJoin(GuildMemberJoinEvent e){
        e.getGuild().addRoleToMember(e.getMember(), e.getJDA().getRoleById(799890881763082270L)).queue();
        e.getGuild().getDefaultChannel().asTextChannel().sendMessage("Hey " + e.getMember().getAsMention() + ", welcome to the server!" +
                "\n \nFIRST: go to " + "<#799888902646136872>" + " and ping @ GreenTae#7504 or @ marailith#4519 to get some "  +
                "questions. You'll answer those questions and once a mod/admin reviews your answers, you'll gain access to " +
                "the role channel" + "\n \nOur verification process is a little complicated, so please be patient. \n \nWe hope you enjoy your stay!").queue();

//        invite = false;
//        if(e.getGuild().getIdLong() == GUILDID) {
//            e.getGuild().loadMembers(i -> {
//                for(Invite invite : e.getGuild().retrieveInvites().complete()) {
//                    //if ((i.getIdLong() == mara || i.getIdLong() == yuzu || i.getIdLong() == tae || i.getIdLong() == shao || i.getIdLong() == kiwi || i.getIdLong() == caden || i.getIdLong() == solecat || i.getIdLong() == swall || i.getIdLong() == larry || i.getIdLong() == lion) && i.getIdLong() == invite.getInviter().getIdLong()) {
//                    if((i.getRoles().toString().contains("924443145561837591") || i.isOwner()) && i.getIdLong() == invite.getInviter().getIdLong()){
//                        System.out.println(invite + " " + invite.getUses() + " " + invite.getInviter());
//                        int postInvUses = invite.getUses();
//                        System.out.println(postInvUses + " " + inviteMap.get(invite.getInviter().getName()));
//                        if (postInvUses - inviteMap.get(invite.getInviter().getName()) > 0) {
//                            System.out.println("inviteable");
//                            this.invite = true;
//                            break;
//                        }
//
//                    }
//                }
//            }).onSuccess(member -> {
//                if(invite) {
//                    System.out.println(e.getMember());
//                    e.getGuild().removeRoleFromMember(e.getMember(), e.getJDA().getRoleById(799890881763082270L)).queue();
//                    e.getGuild().removeRoleFromMember(e.getMember(), e.getJDA().getRoleById(776310265892306955L)).queue();
////                    e.getGuild().addRoleToMember(e.getMember(), e.getJDA().getRoleById(799491778998042624L)).queue();
//                    e.getGuild().addRoleToMember(e.getMember(), e.getJDA().getRoleById(799491778998042624L)).queue();
//
//
//                    //e.getGuild().getDefaultChannel().deleteMessageById(e.getGuild().getDefaultChannel().getHistory().retrievePast(1).complete().get(0).getIdLong()).queue();
//                    e.getGuild().getDefaultChannel().asTextChannel().sendMessage("Hey " + e.getMember().getAsMention() + ", welcome to the server!" +
//                            "\n \nPlease read the rules in the <#772657764799217695> and react to the message when done. " +
//                            "Self-giving roles are in <#799745668246798348>. \n \nWe hope you enjoy your stay!").queue();
//                } else {
//                    e.getGuild().addRoleToMember(e.getMember(), e.getJDA().getRoleById(799890881763082270L)).queue();
//                    e.getGuild().getDefaultChannel().asTextChannel().sendMessage("Hey " + e.getMember().getAsMention() + ", welcome to the server!" +
//                            "\n \nFIRST: go to " + "<#799888902646136872>" + " and ping @ GreenTae#7504 or @ marailith#4519 to get some "  +
//                            "questions. You'll answer those questions and once a mod/admin reviews your answers, you'll gain access to " +
//                            "<#772657764799217695>" + "\n \nOur verification process is a little complicated, so please be patient. \n \nWe hope you enjoy your stay!").queue();
//                    noAccess = true;
//                }
//                for(Invite invite : e.getGuild().retrieveInvites().complete()) {
//                    inviteMap.put(invite.getInviter().getName(), invite.getUses());
//                }
//                System.out.println(inviteMap.toString());
//            });
//        }
    }

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        if(e.getName().equalsIgnoreCase("bypass_for_league")) {
            OptionMapping given = e.getOption("user");
            Long memberID = given.getMentions().getMembers().get(0).getIdLong();
            e.getGuild().removeRoleFromMember(UserSnowflake.fromId(memberID), e.getJDA().getRoleById(799890881763082270L)).queue();
            e.getGuild().addRoleToMember(UserSnowflake.fromId(memberID), e.getJDA().getRoleById(799485386870882354L)).queue();
            e.getGuild().addRoleToMember(UserSnowflake.fromId(memberID), e.getJDA().getRoleById(774320688987111475L)).queue();
            e.reply("catte and league roles given").queue();
        }
    }

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent e){
        if(e.getGuild().getIdLong() == GUILDID) {
            String user = e.getUser().getAsTag();
            e.getGuild().getDefaultChannel().asTextChannel().sendMessage(user + " left the server... RIP").queue();
        }

    }


}
