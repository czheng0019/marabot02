package Fun;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class Owo extends ListenerAdapter {

    Random rand = new Random();
    String newSentence, sentence, name;
    String[] addEnd = {"٩(˃̶͈̀௰˂̶͈́)و", "<{^v^}>", "ᶘ ᵒᴥᵒᶅ", "(*≧ω≦)", "(｡･ω･｡)", "∠( ᐛ 」∠)", "♪(´ε｀ )", "(^◇^;)",
            "(人◕ω◕)", "^._.^", "Φ ω Φ", "(≈ㅇᆽㅇ≈)♡", "(=✖ ᆺ ✖=)", " *:･ﾟ✧(=✪ ᆺ ✪=)*:･ﾟ✧", "(. ❛ ᴗ ❛.)", "(^з^)-☆",
            "(ㆁωㆁ)", "(◠‿◕)", "(｡•̀ᴗ-)✧", "(◡ ω ◡)", "(ﾉ◕ヮ◕)ﾉ*.✧", "(◕ᴗ◕✿)", "♡˖꒰ᵕ༚ᵕ⑅꒱", "(♡ω♡ ) ~♪", "♡(ӦｖӦ｡)",
            "(づ｡◕‿‿◕｡)づ", "╰(⸝⸝⸝´꒳`⸝⸝⸝)╯", "(´⊙ω⊙`)！", "♪ (^ω^// )", "〜(꒪꒳꒪)〜", "(ʘᴗʘ✿)", "(⁎⁍̴̛ᴗ⁍̴̛⁎)", "(☆_☆)", "∧( 'Θ' )∧",
            "٩(˃̶͈̀௰˂̶͈́)و", "(/ω＼)", "(≧∇≦)", "( ･᷄ὢ･᷅ )"};
    String[] addFront = {"OwO", "OWO", "UWU", "nya", "mya", ";3", ":3", "<3", "XD", ":P", ";P", ":D"};
    int r, r2;

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if(e.getName().equalsIgnoreCase("owo")){
            r = rand.nextInt(addFront.length);
            r2 = rand.nextInt(addEnd.length);
            sentence = e.getChannel().getHistory().retrievePast(2).complete().get(0).getContentDisplay();
            name = e.getChannel().getHistory().retrievePast(2).complete().get(0).getAuthor().getName();
            newSentence = sentence.toLowerCase().replaceAll("l", "w").replaceAll("the", "da").
                    replaceAll("r", "w").replaceAll("ma", "mya").
                    replaceAll("na", "nya").replaceAll("u", "wu").
                    replaceAll("a", "wa").replaceAll("i", "wi").
                    replaceAll("e", "we").replaceAll("o", "wo").
                    replaceAll("ag", "awg").replaceAll(" wa", " a").
                    replaceAll(" wu", " u").replaceAll(" we", " e").
                    replaceAll(" wi", " i").replaceAll(" wo", " o").
                    replaceAll("ww", "w");
            e.reply("**" + name + "**: " + addFront[r] + " " + newSentence + " " + addEnd[r2]).queue();
        }
    }

}
