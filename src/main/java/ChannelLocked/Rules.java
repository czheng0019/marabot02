package ChannelLocked;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Rules extends ListenerAdapter {

    final long CHANNELID = 772657764799217695L;

//    public void onMessageReceived(MessageReceivedEvent e) {
//        CreateRules(e);
//        GetRules(e);
//    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        if (e.getChannel().asTextChannel().getIdLong() == CHANNELID) {
            e.getGuild().addRoleToMember(UserSnowflake.fromId(e.getUserId()), e.getJDA().getRoleById(799491778998042624L)).queue();
            e.getGuild().removeRoleFromMember(UserSnowflake.fromId(e.getUserId()), e.getJDA().getRoleById(776310265892306955L)).queue();
        }

    }
//    public void GetRules(MessageReceivedEvent e){
//        EmbedBuilder builder = new EmbedBuilder();
//        builder.setImage("https://https.rules/500");
//        if (e.getMessage().getContentRaw().equals(Constants.prefix + "rules")) {
//            builder.setDescription("1 - respect the purpose of each channel\n" +
//                    "2 - no nsfw/gore aka don't be too horny in general\n" +
//                    "3 - try to limit arguments. if one is to occur, bring it to dms or apologize and move on\n" +
//                    "4 - don't abuse your role powers (for admins and mods)\n" +
//                    "5 - use common sense: don't be mean, don't harass people, try not to be insensitive\n" +
//                    "6 - don't be rude or use offensive slurs or language unless each party are clearly aware its a joke\n" +
//                    "7 - when the server is playing games together, do not cheat or troll, for it ruins the game\n");
//            e.getChannel().sendMessage(builder.build()).queue();
//        }
//    }
//
//    public void CreateRules(MessageReceivedEvent e){
//        EmbedBuilder builder = new EmbedBuilder();
//        builder.setImage("https://https.rules/500");
//        if(e.getTextChannel().getIdLong() == CHANNELID) {
//            if (e.getMessage().getContentRaw().equals(Constants.prefix + "create Rules")) {
//                builder.setDescription("1 - respect the purpose of each channel\n" +
//                        "2 - no nsfw/gore aka don't be too horny in general\n" +
//                        "3 - try to limit arguments. if one is to occur, bring it to dms or apologize and move on\n" +
//                        "4 - don't abuse your role powers (for admins and mods)\n" +
//                        "5 - use common sense: don't be mean, don't harass people, try not to be insensitive\n" +
//                        "6 - don't be rude or use offensive slurs or language unless each party are clearly aware its a joke\n" +
//                        "7 - when the server is playing games together, do not cheat or troll, for it ruins the game\n" +
//                        "\n" +
//                        "repeated offenses will go in the order of:\n" +
//                        "1 - warning\n" +
//                        "2 - kick\n" +
//                        "\n" +
//                        "!! mods/admins reserve the right to modify punishments based on context and individual situations\n" +
//                        "\n" +
//                        "Please react below to indicate that you've read and agree with all the rules, and to gain access to the rest of the server.\n" +
//                        "After that, you can head to <#799745668246798348> to get some roles, and explore the server! Have fun!");
//                e.getChannel().sendMessage(builder.build()).queue();
//            }
//            Reaction(e);
//        }
//    }
//
//    public void Reaction(MessageReceivedEvent e){
//        if (e.getMessage().getAuthor().isBot()) {
//            e.getMessage().addReaction(":ShyYes:774521943247814657").queue();
//        }
//    }

}