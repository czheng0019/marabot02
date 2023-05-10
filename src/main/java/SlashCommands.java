import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class SlashCommands extends ListenerAdapter {

    public void onGuildReady(GuildReadyEvent e) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("ping", "pong"));
        commandData.add(Commands.slash("invite_bot", "provides url"));
        commandData.add(Commands.slash("sarcasm", "hEhE HaHa"));
        e.getGuild().updateCommands().addCommands(commandData).queue();
    }

}
