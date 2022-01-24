package com.pgt360.payment.client;

import io.netty.bootstrap.Bootstrap;;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

@Slf4j
@RequiredArgsConstructor
@Component
public class TcpServer {
    private final Bootstrap bootstrap;
    private final InetSocketAddress hostSocketAddress;
    //private Channel channel;

    public void start(){
        try{
            ChannelFuture channelFuture = bootstrap.connect(hostSocketAddress).sync();
            log.info("*************************************************");
            log.info("**********Connect to Server : host {}**********", hostSocketAddress.getHostName());
            log.info("*************************************************");
            //channel = (Channel)channelFuture.channel().closeFuture().sync();
            channelFuture.channel().closeFuture().sync();

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    /*@PreDestroy
    public void stop(){
        if(channel != null){
            channel.close();
            channel.parent().close();
        }
    }*/
}
