package com.zaki.domain.sys;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangh
 * @Date: 2018/6/13.
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConn {
    private String host;

    private int port;

    private int timeout;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "Redis [host=" + host + ", port=" + port + ", timeout=" + timeout + "]";
    }
}
