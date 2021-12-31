package com.pgt360.payment.netty.netty.handler;

import com.pgt360.payment.netty.domain.ChannelRepository;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class LoginHandler extends ChannelInboundHandlerAdapter {
    private final ChannelRepository channelRepository;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //if(!(msg instanceof String) || !((String) msg).startsWith("login ")){
        //ctx.fireChannelRead(msg);
        //    return;
        //}

        //String stringMessage = (String) msg;
        //if(log.isDebugEnabled()){
        //    log.debug(stringMessage);
        //}

        //User user = User.of(stringMessage, ctx.channel());
        //user.login(channelRepository, ctx.channel());
        //log.info(ctx.channel().remoteAddress().toString());
        //ctx.writeAndFlush("02001736303030303030303030313030323030300321");
        //ctx.writeAndFlush("Succesfully logged in as "+user.getUsername()+". \r\n");
        
    }
}
