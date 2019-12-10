package com.chenhz.server.mybatisplus.generator;

public enum Application {
    ADMIN(new String[]{"com.chenhz.server","robot-admin-server"});

    private String[] path;

    private Application(String[] path){
        this.path = path;
    }

    public String[] getPath() {
        return path;
    }

    public void setPath(String[] path) {
        this.path = path;
    }

}
