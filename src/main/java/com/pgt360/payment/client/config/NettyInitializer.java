package com.pgt360.payment.client.config;

import com.pgt360.payment.client.handler.NettyHandlerIn;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
@RequiredArgsConstructor
public class NettyInitializer extends ChannelInitializer<SocketChannel> {
    private final NettyHandlerIn nettyHandlerIn = new NettyHandlerIn();
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        //pipeline.addLast("decoder", new NettyDecode());
        //pipeline.addLast("encoder", new NettyEncode());
        pipeline.addLast(nettyHandlerIn);
    }



}
