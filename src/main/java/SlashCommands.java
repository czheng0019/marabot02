import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
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
        commandData.add(Commands.slash("owo", "UwU owoify ywowuw mwesswawgwe! (^з^)-☆"));
        commandData.add(Commands.slash("spam", "@yuzu @yuzu @yuzu @yuzu @yuzu")
                .addOption(OptionType.STRING, "name", "person you're spamming" ));
        commandData.add(Commands.slash("stop_spam", "spam this to stop"));

        commandData.add(Commands.slash("league_match_history", "LoL match history")
                .addOption(OptionType.STRING, "league_username", "league summoner name")
                .addOption(OptionType.INTEGER, "count", "how many games"));
        commandData.add(Commands.slash("league_match_history_ranked", "LoL ranked match history")
                .addOption(OptionType.STRING, "league_username", "league summoner name")
                .addOption(OptionType.INTEGER, "count", "how many games"));
        commandData.add(Commands.slash("league_match_history_game", "LoL specifics of one game")
                .addOption(OptionType.STRING, "league_username", "league summoner name")
                .addOption(OptionType.INTEGER, "count", "how many games from most recent"));
        commandData.add(Commands.slash("league_rank", "LoL rank")
                .addOption(OptionType.STRING, "league_username", "league summoner name"));
        commandData.add(Commands.slash("league_champion_mastery", "LoL champion mastery")
                .addOption(OptionType.STRING, "league_username", "league summoner name")
                .addOption(OptionType.STRING, "champion", "any champion"));
        e.getGuild().updateCommands().addCommands(commandData).queue();
    }

}
