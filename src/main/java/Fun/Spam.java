package Fun;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.util.List;

public class Spam extends ListenerAdapter {
    static boolean spam = true;
    public void onSlashCommandInteraction (SlashCommandInteractionEvent e) {

        long memberID;

        if(e.getName().equalsIgnoreCase("spam")) {
            OptionMapping opt = e.getOption("name");
            memberID = opt.getMentions().getMembers().get(0).getIdLong();
            while (spam) {
                if(e.getName().equalsIgnoreCase("stop_spam")) {
                    spam = false;
                }
                if(memberID == 579708384555565078L || memberID == 1105710094114631700L){
                    e.getChannel().sendMessage(e.getInteraction().getMember().getAsMention()).queue();
                } else {
                    e.getChannel().sendMessage(opt.getMentions().getMembers().get(0).getAsMention()).queue();
                }

            }
            e.reply("hope you're happy :)").queue();
        }


    }

}
