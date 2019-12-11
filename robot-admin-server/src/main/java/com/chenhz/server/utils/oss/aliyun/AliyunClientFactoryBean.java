package com.chenhz.server.utils.oss.aliyun;

import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

@Slf4j
public class AliyunClientFactoryBean implements FactoryBean<OSSClient>,InitializingBean,DisposableBean {

    private OSSClient ossClient;

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;


    @Override
    public void destroy() throws Exception {
        if (this.ossClient != null){
            this.ossClient.shutdown();
        }
    }

    @Override
    public OSSClient getObject() throws Exception {
        return this.ossClient;
    }

    @Override
    public Class<?> getObjectType() {
        return OSSClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(">>>>> 初始化 aliyun OSS <<<<<");
        log.info(">>>>> endpoint: [{}]",this.endpoint);
        log.info(">>>>> accessKeyId: [{}]",this.accessKeyId);
        log.info(">>>>> accessKeySecret: [{}]",this.accessKeySecret);

        Assert.notNull(this.endpoint, "'endpoint' must be not null");
        Assert.notNull(this.accessKeyId, "'accessKeyId' must be not null");
        Assert.notNull(this.accessKeySecret, "'accessKeySecret' must be not null");
        this.ossClient = new OSSClient(this.endpoint, this.accessKeyId, this.accessKeySecret);
    }

    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(final String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(final String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }
}
