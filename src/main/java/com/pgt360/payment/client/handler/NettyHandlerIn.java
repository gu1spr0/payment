package com.pgt360.payment.client.handler;

import com.pgt360.payment.service.dto.flow.FlowQueryDto;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.nio.charset.Charset;

@Component
@Slf4j
@RequiredArgsConstructor
@ChannelHandler.Sharable
public class NettyHandlerIn extends ChannelInboundHandlerAdapter {
    public static ChannelHandlerContext ctx;
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = ctx;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        this.ctx = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf =(ByteBuf)msg;    // (2)
        String text = buf.toString(Charset.defaultCharset());   // (3)
        System.out.println("El mensaje recibido del servidor es:"+text);
        buf.release(); // (4)
        //this.sendMessage("06");
    }

    public static void sendMessage(FlowQueryDto pFlowQueryDto) {  // (4)
        if (ctx == null)
            return;
        try{
            /*StringBuffer sb = new StringBuffer();
            char ch[] = msg.toCharArray();
            for(int i=0;i<ch.length;i++){
                String hexString = Integer.toHexString(ch[i]);
                sb.append(hexString);
            }*/
            //String result = sb.toString();

            /**********************ENVIO SENCILLO*******************
            ByteBuf buf = ctx.alloc().buffer();  // (5)
            buf.writeCharSequence(pFlowQueryDto, Charset.defaultCharset());
            ctx.writeAndFlush(buf).sync();
             *******************************************/
            byte[] data = SerializationUtils.serialize(pFlowQueryDto);
            ByteBuf buf = ctx.alloc().buffer();
            buf.writeBytes(data);
            ctx.writeAndFlush(buf).sync();
        }catch (InterruptedException ie){
            ie.getStackTrace().toString();
        }

    }
}
