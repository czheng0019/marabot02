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

        //admin
        commandData.add(Commands.slash("admin_kick", "kick member from the server")
                .addOption(OptionType.STRING, "user", "mention the name"));

        //channel locked
        commandData.add(Commands.slash("bypass_for_league", "bypasses rules and gives decatf")
                .addOption(OptionType.STRING, "user", "mention the name"));
        commandData.add(Commands.slash("allow_in", "removes no access and gives potential member decatf")
                .addOption(OptionType.STRING, "user", "mention the name"));
        commandData.add(Commands.slash("deny_access", "deny member access from server")
                .addOption(OptionType.STRING, "user", "mention the name"));
        commandData.add(Commands.slash("update_server_stats", "update server stats"));

        //fun
        commandData.add(Commands.slash("ping", "pong"));
        commandData.add(Commands.slash("sarcasm", "hEhE HaHaS yOuR pReViOuS mEsSaGe"));
        commandData.add(Commands.slash("owo", "UwU owoify ywowuw pwevwiwowus mwesswawgwe! (^з^)-☆"));
        commandData.add(Commands.slash("stop_spam", "spam this to stop"));

        commandData.add(Commands.slash("gif_pat", "you pat someone")
                .addOption(OptionType.STRING, "name", "mention someone to pat")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_nom", "you nom someone")
                .addOption(OptionType.STRING, "name", "mention someone to nom")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_stare", "you stare at someone")
                .addOption(OptionType.STRING, "name", "mention someone to stare at")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_punch", "you punch someone")
                .addOption(OptionType.STRING, "name", "mention someone to punch")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_bonk", "you bonk someone")
                .addOption(OptionType.STRING, "name", "mention someone to bonk")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_run", "you run from someone")
                .addOption(OptionType.STRING, "name", "mention someone to run from")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_kill", "you kill someone")
                .addOption(OptionType.STRING, "name", "mention someone to kill")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_glare", "you glare at someone")
                .addOption(OptionType.STRING, "name", "mention someone to glare at")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_mok", "you mock someone")
                .addOption(OptionType.STRING, "name", "mention someone to mock")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_hug", "you hug someone")
                .addOption(OptionType.STRING, "name", "mention someone to hug")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_boop", "you boop someone")
                .addOption(OptionType.STRING, "name", "mention someone to boop")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_wave", "you wave at someone")
                .addOption(OptionType.STRING, "name", "mention someone to wave at")
                .addOption(OptionType.STRING, "note", "reason or anything else"));

        commandData.add(Commands.slash("gif_sad", "you are sad")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_blush", "you are blushing")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_confused", "you are confused")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_nico", "you are nico nico nii-ing")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_sleep", "you are sleeping")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_angy", "you are angy")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_smile", "you are smiling")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_smirk", "you are smirking")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_winks", "you are winking")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_shock", "you are shocked")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_laugh", "you are laughing")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_disgust", "you are disgusted")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_pout", "you are pouting")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_braindead", "you are brainded")
                .addOption(OptionType.STRING, "note", "reason or anything else"));
        commandData.add(Commands.slash("gif_decompose", "you are decomposing")
                .addOption(OptionType.STRING, "note", "reason or anything else"));



        //league
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

        //music
        commandData.add(Commands.slash("music_stop", "clear the queue"));
        commandData.add(Commands.slash("music_skip", "skip current song"));
        commandData.add(Commands.slash("music_loop", "loop the queue"));
        commandData.add(Commands.slash("music_now_playing", "description of current song"));
        commandData.add(Commands.slash("music_play", "play a song")
                .addOption(OptionType.STRING, "link", "youtube or spotify playlist"));
        commandData.add(Commands.slash("music_queue", "tracks in the queue")
                .addOption(OptionType.STRING, "count", "how many tracks to output, if leave blank is 10"));
        commandData.add(Commands.slash("music_join", "ask marabot02 to join your channel"));
        commandData.add(Commands.slash("music_leave", "marabot02 leaves your channel"));

        //utility
        commandData.add(Commands.slash("invite_bot", "provides url to invite bot"));

        e.getGuild().updateCommands().addCommands(commandData).queue();
    }

}
