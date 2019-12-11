/**
 *
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.chenhz.server.utils.oss;

import com.chenhz.server.utils.UUIDGenerate;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 云存储,实现的云存储或自建存储建议继承这个类
 */
public abstract class CloudStorage {

    /**
     * 文件路径
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回上传路径
     */
    public String getPath(String prefix, String suffix) {
        //生成uuid
        String uuid = UUIDGenerate.create();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String tmpFolder = sdf.format(Calendar.getInstance().getTime());
        //文件路径
        String path = tmpFolder + "/" + uuid;

        if(StringUtils.isNotBlank(prefix)){
            if (prefix.endsWith("/")){
                path = prefix + path;
            }else {
                path = prefix + "/" + path;
            }
        }
        suffix = suffix.startsWith(".") ? suffix.replace(".","") : suffix;
        return path + "." + suffix;
    }

    /**
     * 文件上传
     * @param data    文件字节数组
     * @param path    文件路径，包含文件名
     * @return        返回http地址
     */
    public abstract String upload(byte[] data, String path);


    /**
     * 文件上传
     * @param inputStream   字节流
     * @param path          文件路径，包含文件名
     * @return              返回http地址
     */
    public abstract String upload(InputStream inputStream, String path);


    /**
     * 文件下载
     * @param url 文件地址
     * @return
     */
    public abstract byte[] downloadToByte(String url) throws Exception;
}
