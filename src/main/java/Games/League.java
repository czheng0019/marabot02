package Games;

import humanize.Humanize;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import no.stelar7.api.r4j.basic.APICredentials;
import no.stelar7.api.r4j.basic.constants.api.regions.LeagueShard;
import no.stelar7.api.r4j.basic.constants.api.regions.RegionShard;
import no.stelar7.api.r4j.basic.constants.types.lol.MatchlistMatchType;
import no.stelar7.api.r4j.basic.utils.LazyList;
import no.stelar7.api.r4j.impl.R4J;
import no.stelar7.api.r4j.impl.lol.builders.matchv5.match.MatchBuilder;
import no.stelar7.api.r4j.pojo.lol.league.LeagueEntry;
import no.stelar7.api.r4j.pojo.lol.match.v5.LOLMatch;
import no.stelar7.api.r4j.pojo.lol.match.v5.MatchParticipant;
import no.stelar7.api.r4j.pojo.lol.staticdata.champion.StaticChampion;
import no.stelar7.api.r4j.pojo.lol.summoner.Summoner;

import java.awt.*;
import java.text.NumberFormat;
import java.time.*;
import java.util.*;
import java.util.List;

public class League extends ListenerAdapter {

    Color color = new Color(98, 78, 237);

    enum Role {
        TOP, JUNGLE, MID, BOT, UTILITY
    }
    Role role;

    public void onSlashCommandInteraction (SlashCommandInteractionEvent e) {

        Dotenv config = Dotenv.configure().load();
        String riotToken = config.get("RIOT_TOKEN");
        APICredentials riotCreds = new APICredentials(riotToken);

        if(e.getName().equalsIgnoreCase("league_match_history") || e.getName().equalsIgnoreCase("league_match_history_ranked")){
            R4J league = new R4J(riotCreds);
            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(color);
            int amount = 5;
            OptionMapping username = e.getOption("league_username");
            String user = username.getAsString();
            OptionMapping count = e.getOption("count");
            amount = count.getAsInt();

            Summoner summoner = Summoner.byName(LeagueShard.NA1, user);
            MatchBuilder mb  = new MatchBuilder(summoner.getPlatform());
            LazyList<String> all = summoner.getLeagueGames().getLazy();
            int profIcon = summoner.getProfileIconId();
            builder.setAuthor(summoner.getName(), "https://na.op.gg/summoner/userName=" + user, "http://ddragon.leagueoflegends.com/cdn/"+ league.getDDragonAPI().getVersions().get(0) + "/img/profileicon/" + profIcon + ".png");
            if(e.getName().equalsIgnoreCase("league_match_history_ranked")){
                all = summoner.getLeagueGames().withType(MatchlistMatchType.RANKED).getLazy();
            }
            int i = 0, wr = 0;
            for (String matchid : all) {
                if (i++ == amount) break;
                mb = mb.withId(matchid);
                LOLMatch match = mb.getMatch();
                for(int j = 0; j < 10; j ++){
                    if(match.getParticipants().get(j).getSummonerId().equals(summoner.getSummonerId())){
                        MatchParticipant mh = match.getParticipants().get(j);
                        String title = "", desp = "";
                        if(mh.didWin()){
                            title += "✅ Win";
                            wr++;
                        } else {
                            title += "❌ Loss";
                        }
                        title += " | " + getTime(match.getGameEndAsDate()) + " | " + gameType(match.getQueue().commonName());
                        desp += positionEmote(mh.getGameDeterminedPosition().getValue()) + " " + mh.getChampionName() + " | " + mh.getKills() + "/" + mh.getDeaths() + "/" + mh.getAssists();
                        builder.addField(title, desp, false);
                        double percent = (wr * 1.0/amount) * 100;

                        builder.setFooter((Math.floor(percent * 100) / 100) + "% win rate");
                    }
                }
            }
            e.getChannel().sendMessageEmbeds(builder.build()).queue();
        }

        if(e.getName().equalsIgnoreCase("league_match_history_game")){
            //|| e.getMessage().getContentRaw().startsWith(Constants.prefix + "mhr ") || e.getMessage().getContentRaw().startsWith(Constants.prefix + "matchHistoryRanked ")) {
            R4J league = new R4J(riotCreds);
            EmbedBuilder builder = new EmbedBuilder();
            builder.setColor(color);
            OptionMapping username = e.getOption("league_username");
            String user = username.getAsString();
            OptionMapping count = e.getOption("count");
            int game = count.getAsInt(), done = 0, roleI = 0, length = 0;
            boolean blue = true;
            Summoner summoner = Summoner.byName(LeagueShard.NA1, user.toString());
            MatchBuilder mb  = new MatchBuilder(summoner.getPlatform());
            LazyList<String> all = summoner.getLeagueGames().getLazy();
            List<String> roles = new ArrayList<>(Arrays.asList("TOP", "JUNGLE", "MID", "BOT", "UITILITY"));
            int profIcon = summoner.getProfileIconId();
            builder.setAuthor(summoner.getName(), "https://na.op.gg/summoner/userName=" + user, "http://ddragon.leagueoflegends.com/cdn/"+ league.getDDragonAPI().getVersions().get(0) + "/img/profileicon/" + profIcon + ".png");
            mb = mb.withId(all.get(game - 1));
            LOLMatch match = mb.getMatch();
            String title = "", desp = "", temp = "", r = "", b = "", tog = "";
            role = Role.TOP;
            for(int j = 0; j < 10; j++) {
                MatchParticipant mh = match.getParticipants().get(j);
                if (match.getParticipants().get(j).getSummonerId().equals(summoner.getSummonerId())) {
                    if (mh.didWin()) {
                        title += "✅ Win";
                    } else {
                        title += "❌ Loss";
                    }
                    title += " | " + getTime(match.getGameEndAsDate()) + " | " + gameType(match.getQueue().commonName());
                    builder.setFooter(summoner.getName() + ": " + mh.getChampionName());
                    break;
                }
            }
            while(done < 10){
                for(int j = 0; j < 10; j++) {
                    MatchParticipant mh = match.getParticipants().get(j);
                    if(mh.getGameDeterminedPosition().getValue().equals("INVALID")){
                        if(blue && mh.getTeam().prettyName().equals("Blue")){
                            if(!desp.contains(mh.getChampionName())){
                                r = mh.getChampionName() + " | " + mh.getKills() + "/" + mh.getDeaths() + "/" + mh.getAssists();
                                blue = false;
                                done++;
                            }
                        } else if (!blue && mh.getTeam().prettyName().equals("Red")){
                            if(!desp.contains(mh.getChampionName())){
                                b = mh.getChampionName() + " | " + mh.getKills() + "/" + mh.getDeaths() + "/" + mh.getAssists() + "\n";
                                length = 50 - r.length() - b.length();
                                String s = r + "      " + b;
                                //e.getChannel().sendMessage(s).queue();
                                desp += s;
                                blue = true;
                                done++;
                            }
                        };
                    } else {
                        if(blue && mh.getTeam().prettyName().equals("Blue")) {
                            if(mh.getGameDeterminedPosition().getValue().equals(roles.get(roleI))) {
                                desp += positionEmote(mh.getGameDeterminedPosition().getValue()) + " " + mh.getChampionName() + " | " + mh.getKills() + "/" + mh.getDeaths() + "/" + mh.getAssists() + "\t";
                                blue = false;
                                done++;
                            }
                        } else if(!blue && mh.getTeam().prettyName().equals("Red")) {
                            if(mh.getGameDeterminedPosition().getValue().equals(roles.get(roleI))){
                                desp += positionEmote(mh.getGameDeterminedPosition().getValue()) + " " + mh.getChampionName() + " | " + mh.getKills() + "/" + mh.getDeaths() + "/" + mh.getAssists() + "\n";
                                blue = true;
                                done++;
                            }
                        }
                    }
                }
                if(done > 0 && done % 2 == 0 && roleI < 5){
                    roleI++;
                }
            }
//            if(done == 10){
            builder.addField(title, desp, false);
            e.getChannel().sendMessageEmbeds(builder.build()).queue();
//            }

        }

        if(e.getName().equalsIgnoreCase("league_rank")) {
            R4J league = new R4J(riotCreds);
            EmbedBuilder builder = new EmbedBuilder();
            OptionMapping username = e.getOption("league_username");
            String user = username.getAsString();
            Summoner summoner = Summoner.byName(LeagueShard.NA1, user.toString());
            int profIcon = summoner.getProfileIconId();
            builder.setColor(color);
            builder.setAuthor(summoner.getName(), "https://na.op.gg/summoner/userName=" + user, "http://ddragon.leagueoflegends.com/cdn/"+ league.getDDragonAPI().getVersions().get(0) + "/img/profileicon/" + profIcon + ".png");
            List<LeagueEntry>  all = summoner.getLeagueEntry();
            String tier = "Unranked", rank = "Unranked";
            int lp = 0, win = 0, loss = 0;
            for (LeagueEntry leagueEntry : all) {
                tier = leagueEntry.getRank();
                lp = leagueEntry.getLeaguePoints();
                win = leagueEntry.getWins();
                loss = leagueEntry.getLosses();
                rank = leagueEntry.getTierDivisionType().getTier();
                if(gameType(leagueEntry.getQueueType().commonName()).equals("Ranked Solo/Duo")){
                    builder.addField("Ranked Solo/Duo | " + rankEmote(rank) + " " + rank(rank) + " " + tier,
                            win + " Wins - " + loss + " Losses | " + lp + " LP", false);
                }
                if(gameType(leagueEntry.getQueueType().commonName()).equals("Ranked Flex")){
                    builder.addField("Ranked Flex | " + rankEmote(rank) + " " + rank(rank) + " " + tier,
                            win + " Wins - " + loss + " Losses | " + lp + " LP", false);
                }
                if(leagueEntry.isInPromos()){
                    builder.addField(rankEmote(rank) + " " + rank(rank) + "Promos",
                            leagueEntry.getMiniSeries().getWins() + " Wins - " + leagueEntry.getMiniSeries().getLosses() + " Losses | " + lp + "LP", false);
                }
            }
            if(builder.getFields().size() == 0){
                builder.addField("Unranked", win + " Wins - " + loss + " Losses | " + lp + " LP", false);
            }
            e.getChannel().sendMessageEmbeds(builder.build()).queue();
        }

        if(e.getName().equalsIgnoreCase("league_champion_mastery")) {
            R4J league = new R4J(riotCreds);
            EmbedBuilder builder = new EmbedBuilder();
            OptionMapping username = e.getOption("league_username");
            String user = username.getAsString();
            OptionMapping champ = e.getOption("champion");
            ArrayList<String> champions = new ArrayList<>();
            champions.add(champ.getAsString());
            int level, points;
            Summoner summoner = Summoner.byName(LeagueShard.NA1, user);
            NumberFormat numberFormat = NumberFormat.getInstance();
            int profIcon = summoner.getProfileIconId();
            builder.setColor(color);
            builder.setAuthor(summoner.getName(), "https://na.op.gg/summoner/userName=" + user, "http://ddragon.leagueoflegends.com/cdn/"+ league.getDDragonAPI().getVersions().get(0) + "/img/profileicon/" + profIcon + ".png");
            for(String champion : champions){
                for(StaticChampion staticChampion :  league.getDDragonAPI().getChampions().values()){
                    if(staticChampion.getName().equalsIgnoreCase(champion)){
                        level = summoner.getChampionMastery(staticChampion.getId()).getChampionLevel();
                        points = summoner.getChampionMastery(staticChampion.getId()).getChampionPoints();
                        builder.addField(staticChampion.getName(), masteryEmote(level) + " Mastery " + level + " | Points " + numberFormat.format(points), false);
                    }
                }
            }
            e.getChannel().sendMessageEmbeds(builder.build()).queue();
        }
    }

    public String masteryEmote(int mastery){
        switch (mastery){
            case 1: return "<:mastery1:924207392110018601>";
            case 2: return "<:mastery2:924207403023597629>";
            case 3: return "<:mastery3:924207414943809546>";
            case 4: return "<:mastery4:924207426054524929>";
            case 5: return "<:mastery5:924207437580488734>";
            case 6: return "<:mastery6:924207449379069952>";
            case 7: return "<:mastery7:924206962957246484>";
            default: return "None";
        }
    }

    public String rankEmote(String rank){
        switch (rank){
            case "IRON": return "<:iron:832615913957490719>";
            case "BRONZE": return "<:bronze:832615913882124318>";
            case "SILVER": return "<:silver:832615913840574494>";
            case "GOLD": return "<:gold:832615913446440980>";
            case "PLATINUM": return "<:platinum:832615913567813662>";
            case "DIAMOND": return "<:diamond:832615913504243724>";
            case "MASTER": return "<:master:832615913525870603>";
            case "GRANDMASTER": return "<:grandmaster:832615913995108362>";
            case "CHALLENGER": return "<:challenger:832615913835987004>";
            default: return "Unranked";
        }
    }

    public String rank(String rank){
        switch (rank){
            case "IRON": return "Iron";
            case "BRONZE": return "Bronze";
            case "SILVER": return "Silver";
            case "GOLD": return "Gold";
            case "PLATINUM": return "Platinum";
            case "DIAMOND": return "Diamond";
            case "MASTER": return "Master";
            case "GRANDMASTER": return "Grandmaster";
            case "CHALLENGER": return "Challenger";
            default: return "Unranked";
        }
    }

    public String getTime(ZonedDateTime time){
        LocalDateTime localDate = time.toLocalDateTime();
        Date date = Date.from(localDate.atZone(ZoneId.of("UTC")).toInstant());
        System.out.println(date + " " + Humanize.naturalTime(date));
        return Humanize.naturalTime(date);
    }

    public String positionEmote(String type){
        switch (type){
            case "BOT": return "<:bot:832668362932092958>";
            case "TOP": return "<:top:832668362810720318>";
            case "JUNGLE": return "<:jungle:832668362915577856>";
            case "MID": return "<:mid:832668362605199381>";
            case "UITILITY": return "<:supp:832668362920165428>";
            default: return "?";
        }
    }

    public String gameType(String type){
        switch (type){
            case "5v5 Ranked Solo": return "Ranked Solo/Duo";
            case "5v5 Draft Pick": return "Normal (Draft Pick)";
            case "5v5 Ranked Flex Queue": return "Ranked Flex";
            case "ARAM": return "ARAM";
            case "Clash": return "Clash";
            case "Custom": return "Custom";
            default: return "?";
        }
    }

    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }
}
