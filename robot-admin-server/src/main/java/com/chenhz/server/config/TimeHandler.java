package com.chenhz.server.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 解决后端接受前端传输的 Date 类型格式问题
 */
@Slf4j
@RestControllerAdvice
public class TimeHandler {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.debug(">>>>> Date 日期装换 <<<<<");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //是否严格解析时间 false则严格解析 true宽松解析
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
