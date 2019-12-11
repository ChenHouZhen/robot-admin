package com.chenhz.server.utils.oss.aliyun;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@PropertySource("classpath:custom.properties")
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunProperties {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucket;

    private String callback;

    public String getAccessUrl(){
        return "https://" + this.bucket + "." + this.endpoint;
    }

}
