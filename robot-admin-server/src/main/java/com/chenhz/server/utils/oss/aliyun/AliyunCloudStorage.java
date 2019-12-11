package com.chenhz.server.utils.oss.aliyun;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.chenhz.server.exception.RRException;
import com.chenhz.server.utils.oss.CloudStorage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component(value = "aliyunCloudStorage")
@Slf4j
public class AliyunCloudStorage extends CloudStorage {

    @Autowired
    private AliyunProperties aliyunProperties;


    @Autowired
    private OSSClient ossClient;

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data),path);
    }


    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            ossClient.putObject(aliyunProperties.getBucket(), path, inputStream);
        } catch (Exception e){
            log.error("上传文件失败",e);
            throw new RRException("上传文件失败，请联系管理人员", e);
        }
        return aliyunProperties.getAccessUrl() + "/" + path;
    }

    // https://hqjy-coursetest.oss-cn-shenzhen.aliyuncs.com/knowledge_base/file/sys/index.md

    private InputStream download(String url) throws MalformedURLException {
        Map<String,String> header = new HashMap<>(2);
        OSSObject ossObject = ossClient.getObject(new URL(url),header);
        return ossObject.getObjectContent();
    }


    @Override
    public byte[] downloadToByte(String url) throws IOException {
        return IOUtils.toByteArray(download(url));
    }

}
