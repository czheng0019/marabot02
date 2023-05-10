import Fun.PingPong;
import Fun.Sarcasm;
import Utility.InviteBot;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;
import java.util.EventListener;

public class Bot {

    ListenerAdapter[] listenerAdapters = new ListenerAdapter[] { new SlashCommands(), new PingPong(), new InviteBot(),
            new Sarcasm()
    };

    public void start() {
        Dotenv config = Dotenv.configure().load();
        String discordToken = config.get("DISCORD_TOKEN");
        JDABuilder jdaBuilder = JDABuilder.createDefault(discordToken);

        jdaBuilder.enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MESSAGES);
        jdaBuilder.addEventListeners(listenerAdapters);
        jdaBuilder.enableCache(CacheFlag.ACTIVITY);
        jdaBuilder.setChunkingFilter(ChunkingFilter.ALL);
        jdaBuilder.setMemberCachePolicy(MemberCachePolicy.ALL);

        jdaBuilder.setActivity(Activity.listening("gymnopedie 10 hours"));

        try {
            JDA jda = jdaBuilder.build();
            jda.awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}