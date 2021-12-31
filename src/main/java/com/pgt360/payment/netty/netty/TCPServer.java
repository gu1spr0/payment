package com.pgt360.payment.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
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
public class TCPServer {
    private final ServerBootstrap serverBootstrap;
    private final InetSocketAddress tcpPort;
    private Channel serverChannel;

    public void start(){
        try{
            ChannelFuture serverChannelFuture = serverBootstrap.bind(tcpPort).sync();
            log.info("*************************************************");
            log.info("**********Server is started : port {}**********", tcpPort.getPort());
            log.info("*************************************************");
            serverChannel = (Channel) serverChannelFuture.channel().closeFuture().syncUninterruptibly().channel();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    @PreDestroy
    public void stop(){
        if(serverChannel != null){
            serverChannel.close();
            serverChannel.parent().close();
        }
    }
}
