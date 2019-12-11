package com.chenhz.server.utils;

import java.util.UUID;

public class UUIDGenerate {

    public static String create(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
