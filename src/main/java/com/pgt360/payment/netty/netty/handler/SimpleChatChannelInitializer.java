package com.pgt360.payment.netty.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleChatChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final SimpleChatServerHandler simpleChatServerHandler;
    private final LoginHandler loginHandler;
    private final StringEncoder stringEncoder = new StringEncoder();
    private final StringDecoder stringDecoder = new StringDecoder();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new DelimiterBasedFrameDecoder(1024 * 1024, Delimiters.lineDelimiter()));
        pipeline.addLast(stringDecoder);
        pipeline.addLast(stringEncoder);
        pipeline.addLast(simpleChatServerHandler);
        pipeline.addLast(loginHandler);
    }
}
