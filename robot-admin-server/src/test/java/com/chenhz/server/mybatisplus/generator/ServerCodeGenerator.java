package com.chenhz.server.mybatisplus.generator;

public class ServerCodeGenerator extends CodeGenerator{

    public ServerCodeGenerator(Application app) {
        super(app);
    }

    @Override
    public Application getApp() {
        return Application.ADMIN;
    }

    public static void main(String[] args) {
        ServerCodeGenerator serverCodeGenerator = new ServerCodeGenerator(Application.ADMIN);
        serverCodeGenerator.generateByTables("sys_file");
    }
}
