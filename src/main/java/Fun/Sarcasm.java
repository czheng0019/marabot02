package Fun;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Sarcasm extends ListenerAdapter {

    String name, sentence, newSentence;
    char tempLetter;
    char[] lowerCase = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.', '?', '!'};
    char[] upperCase = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.', '?', '!'};

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("sarcasm")){
            sentence = e.getChannel().getHistory().retrievePast(2).complete().get(0).getContentDisplay().toLowerCase();
            name = e.getChannel().getHistory().retrievePast(2).complete().get(0).getAuthor().getName();
            newSentence = "**" + name + "**: ";
            for(int x = 0; x < sentence.length(); x++){
                tempLetter = sentence.charAt(x);
                if(x % 2 != 0){
                    for(int y = 0; y < lowerCase.length; y++){
                        if(tempLetter == lowerCase[y]){
                            newSentence = newSentence + upperCase[y];
                            break;
                        }
                    }
                } else {
                    newSentence = newSentence + tempLetter;
                }


            }
            e.reply(newSentence).queue();

        }
    }
}

