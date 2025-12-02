package ChannelLocked;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.UserSnowflake;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Rules extends ListenerAdapter {

    final long CHANNELID = 772657764799217695L;

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent e) {
        if (e.getChannel().asTextChannel().getIdLong() == CHANNELID) {
            e.getGuild().addRoleToMember(UserSnowflake.fromId(e.getUserId()), e.getJDA().getRoleById(799491778998042624L)).queue();
            e.getGuild().removeRoleFromMember(UserSnowflake.fromId(e.getUserId()), e.getJDA().getRoleById(776310265892306955L)).queue();
        }

    }

}