package Fun;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class PingPong extends ListenerAdapter {
    public void onSlashCommandInteraction (SlashCommandInteractionEvent e) {
        if (e.getName().equals("ping")) {
            e.reply("pong").queue();
        }
    }
}
