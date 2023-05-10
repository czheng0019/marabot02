package Utility;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class InviteBot extends ListenerAdapter {
    String url = "https://discord.com/oauth2/authorize?client_id=1105710094114631700&scope=bot";

    public void onSlashCommandInteraction (SlashCommandInteractionEvent e) {
        if (e.getName().equals("invite_bot")) {
            e.reply(url).queue();
        }
    }
}
