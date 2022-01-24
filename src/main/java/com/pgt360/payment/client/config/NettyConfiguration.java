package com.pgt360.payment.client.config;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(NettyProperties.class)
public class NettyConfiguration {
    private final NettyProperties nettyProperties;
    @Bean(name = "bootstrap")
    public Bootstrap bootstrap(NettyInitializer nettyInitializer) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group());
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(nettyInitializer);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, nettyProperties.isKeepAlive());
        /*ChannelFuture f = bootstrap.connect(nettyProperties.getHost(),nettyProperties.getTcpPort()).sync();
        f.channel().closeFuture().sync();*/
        return bootstrap;
    }
    @Bean(destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup group() {
        return new NioEventLoopGroup(nettyProperties.getBossCount());
    }

    @Bean
    public InetSocketAddress hostSocketAddress() throws UnknownHostException {
        return new InetSocketAddress(nettyProperties.getHost(), nettyProperties.getTcpPort());
    }
}
