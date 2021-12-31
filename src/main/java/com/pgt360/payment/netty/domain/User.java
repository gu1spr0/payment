package com.pgt360.payment.netty.domain;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import lombok.Getter;
import lombok.NonNull;

public class User {
    public static final AttributeKey<User> USER_ATTRIBUTE_KEY = AttributeKey.newInstance("USER");
    @Getter
    private final String username;
    private final Channel channel;

    private User(String username, Channel channel){
        this.username = username;
        this.channel = channel;
    }

    public static com.pgt360.payment.netty.domain.User of(@NonNull String loginCommand, @NonNull Channel channel){
        if(loginCommand.startsWith("login ")){
            return new com.pgt360.payment.netty.domain.User(loginCommand.trim().substring("login ".length()), channel);
        }
        throw  new IllegalArgumentException("loginCommand ["+loginCommand+"] can not be accepted");
    }
    public void login(com.pgt360.payment.netty.domain.ChannelRepository channelRepository, Channel channel){
        channel.attr(USER_ATTRIBUTE_KEY).set(this);
        channelRepository.put(this.username, channel);
    }
    public void logout(com.pgt360.payment.netty.domain.ChannelRepository channelRepository, Channel channel){
        channel.attr(USER_ATTRIBUTE_KEY).getAndSet(null);
        channelRepository.remove(this.username);
    }
    public static com.pgt360.payment.netty.domain.User current(Channel channel){
        com.pgt360.payment.netty.domain.User user = channel.attr(USER_ATTRIBUTE_KEY).get();
        if(user == null){
            throw new com.pgt360.payment.netty.domain.UserLoggedOutException();
        }
        return user;
    }
    public void tell(Channel targetChannel, @NonNull String username, @NonNull String message){
        if(targetChannel != null){
            targetChannel.write(this.username);
            targetChannel.write(">");
            targetChannel.writeAndFlush(message + "\n\r");
            this.channel.writeAndFlush("The message was sent to ["+username+"] succesfully.\r\n");
        }else{
            this.channel.writeAndFlush("No user named with ["+username+"].\r\n");
        }
    }
}
