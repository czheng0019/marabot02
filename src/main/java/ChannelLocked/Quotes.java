package ChannelLocked;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDAInfo;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Quotes extends ListenerAdapter {
    //⭐ 🌟 💫
//    static int count = 0;
    static long starMsgID;
    static boolean gotMember;
    static HashMap<Long, Long> ogToStar = new HashMap<>();
    ;
    static ArrayList<String> ogMsgList = new ArrayList<>();

    Color color = new Color(98, 78, 237);
    static BufferedWriter writer, writerStar;
    static BufferedReader reader, readerStar;

    static List<Message> fetch;
    static boolean stars = false;


    public void onMessageReactionAdd(MessageReactionAddEvent e) {

        EmbedBuilder builder = new EmbedBuilder();

        if (e.getEmoji().equals(Emoji.fromUnicode("\u2B50")) && e.retrieveMessage().complete().getReactions().get(0).getCount() >= 2) {
            System.out.println(e.retrieveMessage().complete().getReactions().get(0).getCount() + " stars");
            stars = false;
            String messageId = e.getMessageId();
            int index = 0;
            fetch = e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete();
            for (Message message : fetch) {
                if ((!message.getEmbeds().isEmpty()) && message.getAuthor().getName().equals("MaraBot")) {
                    if (message.getEmbeds().get(0).getFooter().getText().equals(messageId)) {
                        stars = true;
                        index = fetch.indexOf(message);
                        break;
                    }
                }
//                else {
//                    System.out.println("stars + " + stars);
//                }
            }
            if (stars) {
                int star = Integer.parseInt(fetch.get(index).getContentRaw().substring(fetch.get(index).getContentRaw().indexOf("**") + 2, fetch.get(index).getContentRaw().indexOf("**") + 3));
                String channel = fetch.get(index).getChannel().getAsMention();
                MessageEmbed embed = e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).getEmbeds().get(0);
                star++;
                if(star >= 10){
                    e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).editMessageFormat(":dizzy:️ **" + star + "** " + channel, embed).queue();
                } else if (star >= 5){
                    e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).editMessageFormat(":star2: **" + star + "** " + channel, embed).queue();
                } else {
                    e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).editMessageFormat(":star: **" + star + "** " + channel, embed).queue();
                }
            } else {
                createBuilder(e, builder);
            }
        }

    }

    public void createBuilder(MessageReactionAddEvent e, EmbedBuilder builder) {
        if (!e.retrieveMessage().complete().getAttachments().isEmpty()) {
            builder.setImage(e.retrieveMessage().complete().getAttachments().get(0).getUrl());
            if(!e.retrieveMessage().complete().getContentRaw().isEmpty()){
                builder.setDescription(e.retrieveMessage().complete().getContentRaw());
            }
        } else {
            builder.setDescription(e.retrieveMessage().complete().getContentRaw());
        }
        builder.setColor(color);
        builder.setAuthor(e.retrieveMessage().complete().getAuthor().getName(), null, e.retrieveMessage().complete().getAuthor().getAvatarUrl());
        builder.addField("Source", "[Jump!](" + e.retrieveMessage().complete().getJumpUrl() + ")", false);
        String msgID = e.retrieveMessage().complete().getId();
        builder.setFooter(msgID);
        builder.setTimestamp(e.retrieveMessage().complete().getTimeCreated());
        e.getGuild().getTextChannelById(771796072803729418L).sendMessage(":star:️ **2** <#" + e.retrieveMessage().complete().getChannel().getIdLong() + ">").addEmbeds(builder.build()).queue();
        //e.getChannel().sendMessage("⭐️  2 <#" + e.retrieveMessage().complete().getChannel().getIdLong() + ">").embed(builder.build()).queue();
    }

    public void onMessageReactionRemove(MessageReactionRemoveEvent e) {
        if (e.getEmoji().equals(Emoji.fromUnicode("\u2B50"))) {
            String messageId = e.getMessageId();
            int index = 0;
            fetch = e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete();
            for (Message message : fetch) {
                if ((!message.getEmbeds().isEmpty()) && message.getAuthor().getName().equals("MaraBot")) {
                    System.out.println(Integer.parseInt(fetch.get(index).getContentRaw().substring(fetch.get(index).getContentRaw().indexOf("**") + 2, fetch.get(index).getContentRaw().indexOf("**") + 3)) + "");
                    if (message.getEmbeds().get(0).getFooter().getText().equals(messageId)) {
                        stars = true;
                        index = fetch.indexOf(message);
                        break;
                    }
                }
            }
            if (stars) {
                int star = Integer.parseInt(fetch.get(index).getContentRaw().substring(fetch.get(index).getContentRaw().indexOf("**") + 2, fetch.get(index).getContentRaw().indexOf("**") + 3));
                String channel = fetch.get(index).getChannel().getAsMention();
                star--;
                if (star < 2) {
                    e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).delete().queue();
                } else {
                    MessageEmbed embed = e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(1).complete().get(index).getEmbeds().get(0);
                    if(star >= 10){
                        e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).editMessageFormat(":dizzy:️ **" + star + "** " + channel, embed).queue();
                    } else if (star >= 5){
                        e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).editMessageFormat(":star2: **" + star + "** " + channel, embed).queue();
                    } else {
                        e.getGuild().getTextChannelById(771796072803729418L).getHistory().retrievePast(10).complete().get(index).editMessageFormat(":star: **" + star + "** " + channel, embed).queue();
                    }
                }

            }
        }
    }

}

//            if(e.getReactionEmote().getEmoji().equals(":skull_crossbones:")) {
//                try {
//                    reader = new BufferedReader(new FileReader("src/main/java/TextFiles/quotes.txt"));
//                    writer = new BufferedWriter(new FileWriter("src/main/java/TextFiles/quotes.txt", true));
//                    readerStar = new BufferedReader(new FileReader("src/main/java/TextFiles/quotesStar.txt"));
//                    writerStar = new BufferedWriter(new FileWriter("src/main/java/TextFiles/quotesStar.txt", true));
//                    msgID = e.retrieveMessage().complete().getId();
//                    while((line = reader.readLine()) != null){
//                        ogMsgList.add(line);
//                    }
//                    for (String s : ogMsgList) {
//                        if (s.contains(msgID)) {
//                            System.out.println("already exists");
//                        } else {
//                            System.out.println("written");
//                            writer.newLine();
//                            writer.write("jkn");
//                        }
//                    }
//                    System.out.println(ogMsgList);
////                    createBuilder(e, builder);
//                } catch (IOException fileNotFoundException) {
//                    fileNotFoundException.printStackTrace();
//                }
//            } else if (!e.getReactionEmote().getEmoji().equals(":skull_crossbones:") || e.getReactionEmote().isEmote()){
//            throw new IllegalStateException("Cannot get emoji code for custom emote reaction");
//            }
//
//
//
//


//                for(int i = 0; i < reader.lines().count(); i++){
//                    if(reader.readLine().equals(ogMsgID + "")){
//                        for (int x = 0; x < i; i++) {
//                            readerStar.readLine();
//                        }
//                        count = readerStar.readLine();
//                        if(count.equals("2")){
//                            e.getChannel().sendMessage("⭐️" + count + "<#" + e.retrieveMessage().complete().getChannel().getIdLong() + ">\n").queue();
//                            createBuilder(e, builder);
//                        }
//
//                    } else {
//                        writerStar.write("1"); writerStar.newLine(); writerStar.close();
//                        writer.write(ogMsgID + ""); writer.newLine(); writer.close();
//                    }
//                }


//    }

//    public



//    public void createBuilder(MessageReactionAddEvent e, EmbedBuilder builder){
//
//        e.getGuild().loadMembers(i -> {
//            if(i.equals(e.retrieveMessage().complete().getMember())){
//                gotMember = true;
//                if(!e.retrieveMessage().complete().getAttachments().isEmpty()) {
//                    builder.setImage(e.retrieveMessage().complete().getAttachments().get(0).getUrl());
//                } else {
//                    builder.setDescription(e.retrieveMessage().complete().getContentRaw());
//                }
//                builder.setColor(color);
//                builder.setAuthor(e.retrieveMessage().complete().getMember().getNickname(), null, e.retrieveMessage().complete().getAuthor().getAvatarUrl());
//                builder.addField("Source", "[Jump!](" + e.retrieveMessage().complete().getJumpUrl() + ")", false);
//                msgID = e.retrieveMessage().complete().getId();
//                builder.setFooter(msgID + " • " + e.retrieveMessage().complete().getTimeCreated().toLocalDate());
////                System.out.println("stuff build");
////
////                starMsgID = e.getChannel().getHistory().retrievePast(1).complete().get(0).getIdLong();
////                e.getChannel().editMessageById(starMsgID, builder.build()).queue();
//                e.getChannel().sendMessage(builder.build()).queue();
//
//            }
//        });

//        public void onMessageReactionAdd(MessageReactionAddEvent e){
//        EmbedBuilder builder = new EmbedBuilder();
//
//        if(e.getReactionEmote().isEmoji()){
//            if(e.getReactionEmote().getEmoji().equals("⭐")){
//
////            message = e.retrieveMessage().complete().getAttachments().get(0).getUrl();
//                count++;
//                if(count == 1){
//                    //                   e.getJDA().getGuildById(751686684969664575L).getTextChannelById(771796072803729418L).sendMessage("⭐" + count + "<#" + e.retrieveMessage().complete().getChannel().getIdLong() + ">\n").queue();
//                    e.getChannel().sendMessage("⭐" + count + "<#" + e.retrieveMessage().complete().getChannel().getIdLong() + ">\n").queue();
//                    createBuilder(e, builder);
//                    //e.getJDA().getGuildById(751686684969664575L).getTextChannelById(771796072803729418L).sendMessage(builder.build()).queue();
//                }
//                if(count >= 2){
//                    try {
//                        reader = new BufferedReader(new FileReader("src/main/java/TextFiles/quotes.txt"));
//                        editMsg(reader, e);
//                    } catch (IOException fileNotFoundException) {
//                        fileNotFoundException.printStackTrace();
//                    }
//
//                }
//
//            }
//        }
//
//    }
//
//    public void addStar(BufferedWriter writer) throws IOException {
//        writer = new BufferedWriter(new FileWriter("src/main/java/TextFiles/quotes.txt", true));
//        writer.write("☠️ - " + count + ", starMsgID: " + starMsgID + ", ogMsgID: " + ogMsgID);
//        writer.newLine();
//        writer.close();
//    }
//
//    public void editMsg(BufferedReader reader, MessageReactionAddEvent e) throws IOException {
//        reader = new BufferedReader(new FileReader("src/main/java/TextFiles/quotes.txt"));
//        for(int x = 0; x < reader.lines().count(); x++){
//            System.out.println(reader.readLine().substring(46).equals(e.retrieveMessage().complete().getId()));
//            if(reader.readLine().substring(46).equals(e.retrieveMessage().complete().getId())){
//                System.out.println(reader.readLine().substring(17, 35));
//            }
//        }
//    }
//
//    public void onMessageReactionRemove(MessageReactionRemoveEvent e){
//        if(e.getReactionEmote().getEmoji().equals("☠️")){
//            count--;
//        }
//    }

