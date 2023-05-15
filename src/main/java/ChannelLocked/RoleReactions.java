package ChannelLocked;

import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;


public class RoleReactions extends ListenerAdapter {

    final long CHAOSID = 799745668246798348L;
    final long GOID = 1018254951320920124L;
    final long OLIVERID = 1018270642606444604L;

    HashMap<Emoji, Long> chaosMap = new HashMap<>();
    HashMap<Emoji, Long> goMap = new HashMap<>();
    HashMap<Emoji, Long> oliverMap = new HashMap<>();

    long other, they, he, she;

    //long he;

    public RoleReactions(){

        chaosMap.put(Emoji.fromUnicode("\uD83C\uDF32"), 766904986411597844L); //tree standing to other role
        chaosMap.put(Emoji.fromUnicode("\uD83C\uDF8D"), 751857332979236975L); //bamboo dancing standing to they/them role
        chaosMap.put(Emoji.fromUnicode("\uD83C\uDF44"), 751857289492693002L); //mushroom standing to he/him role
        chaosMap.put(Emoji.fromUnicode("\uD83C\uDF38"), 751857238670311574L); //flower standing to she/her role
        chaosMap.put(Emoji.fromUnicode("❤"), 751811001133039677L); //heart to red role
        chaosMap.put(Emoji.fromUnicode("\uD83E\uDDE1"), 751810345026453524L); //orange heart to orange role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC9B"), 751811083999772712L); //yellow heart to yellow role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC9A"), 751811968863830079L); //green heart to lime role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDFE2"), 751810916546248824L); //green circle to green role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC99"), 751811859778109440L); //blue heart to cyan role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDD35"), 751810119125303417L); //blue circle to blue role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC9C"), 751808306254839850L); //purple heart to purple role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC9F"), 751811173967462453L); //heart decoration to pink role
        chaosMap.put(Emoji.fromUnicode("\uD83E\uDD0D"), 751811581406609489L); //white heart to white role
        chaosMap.put(Emoji.fromUnicode("\uD83E\uDD0E"), 751811702009495582L); //brown heart to brown role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDDA4"), 751811467711348857L); //black heart to black role

        chaosMap.put(Emoji.fromUnicode("\uD83D\uDFE8"), 774320688987111475L); //yellow square to league of legends role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDFE9"), 766090725086855188L); //green square to minecraft role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDFE6"), 754153886222254150L); //blue square to mobile legends role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDFEA"), 764173587241369620L); //purple square to among us role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDFE5"), 758352086961356821L); //red square to valorant role
        chaosMap.put(Emoji.fromUnicode("⬜"), 834272197245534258L); //white square to game night role

        chaosMap.put(Emoji.fromUnicode("\uD83E\uDDD0"), 766904964806082570L); // face with monocle to not sure role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC69\u200D❤️\u200D\uD83D\uDC68"), 766904919830560778L); //couple with heart woman man to straight role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC4D"), 766904846837874719L); //thumbs up to queer role
        chaosMap.put(Emoji.fromUnicode("\uD83E\uDDD1\u200D\uD83C\uDF73"), 766904736997572620L); //cook to pan role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDE45"), 766904703429771274L); //person gesturing no to ace role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC69\u200D❤️\u200D\uD83D\uDC69"), 766904677102518283L); //couple ww to lesbian role
        chaosMap.put(Emoji.fromUnicode("✌"), 766904644168581120L); //v to bi role
        chaosMap.put(Emoji.fromUnicode("\uD83C\uDFF3️)\u200D\uD83C\uDF08"), 766904609066713108L); //rainbow flag to gay role

        chaosMap.put(Emoji.fromUnicode("\uD83E\uDD54"), 806920210165661707L); //potato to weeb role
        chaosMap.put(Emoji.fromUnicode("\uD83D\uDC8D"), 805542235856306237L); //ring to mudae role


//        reactionToRoleID.put(Emoji.fromUnicode("", ); //yello)w square to among us role
//
//    }
//
//
//    public void onSlashCommandInteraction (SlashCommandInteractionEvent e) {
//        if(e.getMessage().getContentRaw().startsWith(Constants.prefix + "setupRoles")){ //get server roles
//            for(int i = 0; i < e.getGuild().getRoles().size(); i++){
//                if(e.getGuild().getRoles().get(i).getName().equals("other")) {
//                    other = e.getGuild().getRoles().get(i).getIdLong();
//                } else if(e.getGuild().getRoles().get(i).getName().equals("they/them")) {
//                    they = e.getGuild().getRoles().get(i).getIdLong();
//                } else if(e.getGuild().getRoles().get(i).getName().equals("he/him")){
//                    he = e.getGuild().getRoles().get(i).getIdLong();
//                } else if(e.getGuild().getRoles().get(i).getName().equals("she/her")){
//                    she = e.getGuild().getRoles().get(i).getIdLong();
//                }
//            }
//            switch (e.getGuild().getName()){
//                case "GO Club":
//                    goMap.put(Emoji.fromUnicode("\uD83C\uDF32"), other);
//                    goMap.put(Emoji.fromUnicode("\uD83C\uDF8D"), they);
//                    goMap.put(Emoji.fromUnicode("\uD83C\uDF44"), he);
//                    goMap.put(Emoji.fromUnicode("\uD83C\uDF38"), she);
//                    break;
//                case "bot test server":
//                    oliverMap.put(Emoji.fromUnicode("\uD83C\uDF32"), other);
//                    oliverMap.put(Emoji.fromUnicode("\uD83C\uDF8D"), they);
//                    oliverMap.put(Emoji.fromUnicode("\uD83C\uDF44"), he);
//                    oliverMap.put(Emoji.fromUnicode("\uD83C\uDF38"), she);
//                    break;
//
//            }
//
//        }
//
//
//        Pronouns(e);
//        Colors(e);
//        Games(e);
//        Sexuality(e);
//        ChannelFun(e);
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {

        if(e.getChannel().asTextChannel().getIdLong() == CHAOSID || e.getChannel().getIdLong() == GOID || e.getChannel().getIdLong() == OLIVERID) {
            System.out.println(e.getEmoji());
            Long roleID;
            if(e.getChannel().getIdLong() == CHAOSID){
                roleID = chaosMap.get(e.getEmoji());
            } else if(e.getChannel().getIdLong() == GOID){
                roleID = goMap.get(e.getEmoji());
            } else {
                roleID = oliverMap.get(e.getEmoji());
            }

            if(roleID == null){
                return;
            }

            e.getGuild().addRoleToMember(UserSnowflake.fromId(e.getUserId()), e.getJDA().getRoleById(roleID)).queue();
        }

    }


    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent e){
        if(e.getChannel().getIdLong() == CHAOSID || e.getChannel().getIdLong() == GOID || e.getChannel().getIdLong() == OLIVERID){
            Long roleID;
            if(e.getChannel().getIdLong() == CHAOSID){
                roleID = chaosMap.get(e.getEmoji());
            } else if(e.getChannel().getIdLong() == GOID){
                roleID = goMap.get(e.getEmoji());
            } else {
                roleID = oliverMap.get(e.getEmoji());
            }

            if(roleID == null){
                return;
            }
            e.getGuild().removeRoleFromMember(UserSnowflake.fromId(e.getUserId()), e.getJDA().getRoleById(roleID)).queue();
        }
    }














    //   " : ````\n\n" +
    //            e.getMessage().addReaction("").queue();

    public void Sexuality(MessageReceivedEvent e) {
//        if (e.getMessage().getContentRaw().equals(Constants.prefix + "create RoleList Sexuality")) {
//            e.getChannel().sendMessage("**Sexuality** \nReact to get a role\n\n" +
//                    "\uD83E\uDDD0 : ``not sure``\n\n" +
//                    "\uD83D\uDC69\u200D❤️\u200D\uD83D\uDC68 : ``straight``\n\n" +
//                    "\uD83D\uDC4D : ``queer``\n\n" +
//                    "\uD83E\uDDD1\u200D\uD83C\uDF73 : ``pan``\n\n" +
//                    "\uD83D\uDE45 : ``ace``\n\n" +
//                    "\uD83D\uDC69\u200D❤️\u200D\uD83D\uDC69 : ``lesbian``\n\n" +
//                    "✌ : ``bi``\n\n" +
//                    "\uD83C\uDFF3️\u200D\uD83C\uDF08 : ``gay``").queue();
//        }
//        if (e.getMessage().getContentRaw().startsWith("**Sexuality** ")) {
//            e.getMessage().addReaction("\uD83E\uDDD0").queue();
//            e.getMessage().addReaction("\uD83D\uDC69\u200D❤️\u200D\uD83D\uDC68").queue();
//            e.getMessage().addReaction("\uD83D\uDC4D").queue();
//            e.getMessage().addReaction("\uD83E\uDDD1\u200D\uD83C\uDF73").queue();
//            e.getMessage().addReaction("\uD83D\uDE45").queue();
//            e.getMessage().addReaction("\uD83D\uDC69\u200D❤️\u200D\uD83D\uDC69").queue();
//            e.getMessage().addReaction("✌").queue();
//            e.getMessage().addReaction("\uD83C\uDFF3️\u200D\uD83C\uDF08").queue();
//        }
    }
    public void Games(MessageReceivedEvent e) {
//        if (e.getMessage().getContentRaw().equals(Constants.prefix + "create RoleList Games")) {
//            e.getChannel().sendMessage("**Games** \nReact to get a role\n\n" +
//                    "\uD83D\uDFEA : ``among us``\n\n" +
//                    "⬜ : ``game night``\n\n" +
//                    "\uD83D\uDFE8 : ``league of legends``\n\n" +
//                    "\uD83D\uDFE9 : ``minecraft``\n\n" +
//                    "\uD83D\uDFE6 : ``mobile legends``\n\n" +
//                    "\uD83D\uDFE5 : ``valorant``").queue();
//        }
//        if (e.getMessage().getContentRaw().startsWith("**Games** ")) {
//            e.getMessage().addReaction("\uD83D\uDFEA").queue();
//            e.getMessage().addReaction("⬜").queue();
//            e.getMessage().addReaction("\uD83D\uDFE8").queue();
//            e.getMessage().addReaction("\uD83D\uDFE9").queue();
//            e.getMessage().addReaction("\uD83D\uDFE6").queue();
//            e.getMessage().addReaction("\uD83D\uDFE5").queue();

//        }
//
//        if (e.getMessage().getContentRaw().equals(Constants.prefix + "update RoleList Games")) {
//            e.getChannel().editMessageById(799745894815236137L, "**Games** \nReact to get a role\n\n" +
//                    "\uD83D\uDFE8 : ``league of legends``\n\n" +
//                    "\uD83D\uDFE9 : ``minecraft``\n\n" +
//                    "\uD83D\uDFE6 : ``mobile legends``\n\n" +
//                    "\uD83D\uDFEA : ``among us``\n\n" +
//                    "\uD83D\uDFE5 : ``valorant``\n\n" +
//                    "⬜ : ``skribbl.io``");
//            e.getChannel().addReactionById(799745894815236137L, "⬜");
//            e.getChannel().sendMessage("nya").queue();
//        }
    }
    public void Pronouns(MessageReceivedEvent e) {
//        if (e.getMessage().getContentRaw().equals(Constants.prefix + "create RoleList Pronouns")) {
//            e.getChannel().sendMessage("**Pronouns** \nReact to get a role\n\n" +
//                    "\uD83C\uDF32 : ``other``\n\n" +
//                    "\uD83C\uDF8D : ``they/them``\n\n" +
//                    "\uD83C\uDF44 : ``he/him``\n\n" +
//                    "\uD83C\uDF38 : ``she/her``").queue();
//        }
//        if (e.getMessage().getContentRaw().startsWith("**Pronouns** ")) {
//            e.getMessage().addReaction("\uD83C\uDF32").queue();
//            e.getMessage().addReaction("\uD83C\uDF8D").queue();
//            e.getMessage().addReaction("\uD83C\uDF44").queue();
//            e.getMessage().addReaction("\uD83C\uDF38").queue();
//        }
    }
    public void Colors(MessageReceivedEvent e) {
//        if (e.getMessage().getContentRaw().equals(Constants.prefix + "create RoleList Colors")) {
//            e.getChannel().sendMessage("**Colors** \nReact to get a role\n\n" +
//                    "❤ : ``red``\n\n" +
//                    "\uD83E\uDDE1 : ``orange``\n\n" +
//                    "\uD83D\uDC9B : ``yellow``\n\n" +
//                    "\uD83D\uDC9A : ``lime green``\n\n" +
//                    "\uD83D\uDFE2 : ``dark green``\n\n" +
//                    "\uD83D\uDC99 : ``cyan``\n\n" +
//                    "\uD83D\uDD35 : ``blue``\n\n" +
//                    "\uD83D\uDC9C : ``purple``\n\n" +
//                    "\uD83D\uDC9F : ``pink``\n\n" +
//                    "\uD83E\uDD0D : ``white``\n\n" +
//                    "\uD83E\uDD0E : ``brown``\n\n" +
//                    "\uD83D\uDDA4 : ``black``").queue();
//
//        }
//        if (e.getMessage().getContentRaw().startsWith("**Colors** ")) {
//            e.getMessage().addReaction("❤").queue();
//            e.getMessage().addReaction("\uD83E\uDDE1").queue();
//            e.getMessage().addReaction("\uD83D\uDC9B").queue();
//            e.getMessage().addReaction("\uD83D\uDC9A").queue();
//            e.getMessage().addReaction("\uD83D\uDFE2").queue();
//            e.getMessage().addReaction("\uD83D\uDC99").queue();
//            e.getMessage().addReaction("\uD83D\uDD35").queue();
//            e.getMessage().addReaction("\uD83D\uDC9C").queue();
//            e.getMessage().addReaction("\uD83D\uDC9F").queue();
//            e.getMessage().addReaction("\uD83E\uDD0D").queue();
//            e.getMessage().addReaction("\uD83E\uDD0E").queue();
//            e.getMessage().addReaction("\uD83D\uDDA4").queue();
//
//        }
    }
    public void ChannelFun(MessageReceivedEvent e) {
//        if (e.getMessage().getContentRaw().equals(Constants.prefix + "create RoleList ChannelFun")) {
//            e.getChannel().sendMessage("**Channel-Fun** \nReact to get a role\n\n" +
//                    "\uD83E\uDD54  : ``weeb``\n\n" +
//                    "\uD83D\uDC8D : ``mudae``").queue();
//        }
//        if (e.getMessage().getContentRaw().startsWith("**Channel-Fun** ")) {
//            e.getMessage().addReaction("\uD83E\uDD54").queue();
//            e.getMessage().addReaction("\uD83D\uDC8D").queue();
//        }
    }
}
