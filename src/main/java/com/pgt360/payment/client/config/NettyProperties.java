package com.pgt360.payment.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ConfigurationProperties(prefix = "netty")
public class NettyProperties {
    @NotNull
    @Size(min = 9, max = 15)
    private String host;

    @NotNull
    @Size(min = 1000, max = 65535)
    private int tcpPort;

    @NotNull
    @Min(1)
    private int bossCount;

    @NotNull
    private boolean keepAlive;
}
