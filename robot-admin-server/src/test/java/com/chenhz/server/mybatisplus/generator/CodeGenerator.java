package com.chenhz.server.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public abstract class CodeGenerator {


    public abstract Application getApp();

    private static final String dbUrl ="jdbc:mysql://localhost:3306/robot?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=true";

    private static final String userName ="root";

    private static final String password ="123456";

    private static final String driverName ="com.mysql.jdbc.Driver";

    private Application app;
    // 模块路径前缀
    protected String projectPath;

    public CodeGenerator(Application app){
        this.app = app;
        projectPath = System.getProperty("user.dir")+"\\"+ app.getPath()[1];
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void generateByTables(Application app, String ... tableNames) {

        // 数据源配置
        DataSourceConfig dsc = getDataSourceConfig();


        // 策略配置
        StrategyConfig strategy = getStrategyConfig(tableNames);

        // 全局配置
        GlobalConfig gc = getGlobalConfig();

        // 包配置
        PackageConfig pc = getPackageConfig(app);

        // 自定义配置
        InjectionConfig cfg = getInjectionConfig();

        // 代码生成器
        new AutoGenerator()
                .setDataSource(dsc)
                .setStrategy(strategy)
                .setGlobalConfig(gc)
                .setPackageInfo(pc)
                .setCfg(cfg)
                .setTemplate(new TemplateConfig().setXml(null))
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    public DataSourceConfig getDataSourceConfig(){
        DataSourceConfig dsc = new DataSourceConfig();
        // mysql 字段映射 java 对象
        MySqlTypeConvert typeConvert = new MySqlTypeConvert(){

            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //将数据库中datetime转换成date
                if (fieldType.toLowerCase().contains("datetime")) {
                    return DbColumnType.DATE;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }
        };

        dsc.setUrl(dbUrl)
                .setTypeConvert(typeConvert)
                .setDriverName(driverName)
                .setUsername(userName)
                .setPassword(password);

        return dsc;
    }

    public StrategyConfig getStrategyConfig(String... tableNames){
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setInclude(tableNames)
                .setTablePrefix("tb_")
                .setControllerMappingHyphenStyle(true);

        return strategy;
    }

    public GlobalConfig getGlobalConfig(){
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java")
                .setAuthor("chenhz")
                .setOpen(false)
                // .setFileOverride(true)
                .setEnableCache(false)
                .setControllerName("%sController")
                .setEntityName("%sEntity")
                .setMapperName("%sMapper")
                .setServiceName("%sService");

        return gc;
    }

    public PackageConfig getPackageConfig(Application app){
        PackageConfig pc = new PackageConfig();
        pc.setParent(app.getPath()[0])
                .setEntity("entity")
                .setController("controller")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper");

        return pc;
    }

    public InjectionConfig getInjectionConfig(){
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mappers/"
                        +tableInfo.getEntityName().replace("Entity","")+ "Mapper.xml";
            }
        });

        cfg.setFileOutConfigList(focList);

        return cfg;
    }


    public void generateByTables(String... tableNames){
        generateByTables(app, tableNames);
    }

}
