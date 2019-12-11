
package com.chenhz.server.utils.oss.aliyun;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({OSSClient.class})
public class AliyunAutoConfigutation {

    @Autowired
    private AliyunProperties aliyunProperties;

    @Bean
    public AliyunClientFactoryBean ossClientFactoryBean(){
        final AliyunClientFactoryBean factoryBean = new AliyunClientFactoryBean();
        factoryBean.setEndpoint(this.aliyunProperties.getEndpoint());
        factoryBean.setAccessKeyId(this.aliyunProperties.getAccessKeyId());
        factoryBean.setAccessKeySecret(this.aliyunProperties.getAccessKeySecret());
        return factoryBean;
    }

}

