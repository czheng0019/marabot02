package Admin;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class Kick extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("admin_kick")) {
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
            e.getGuild().getDefaultChannel().asTextChannel().sendMessage("member has been oofed").queue();
        }
    }
}
