package test;

import core.BaseTest;

public class Setenviroment {
    private BaseTest baseTest;

    private String url;

    public String setEnviromentGet(String path){
        this.baseTest = new BaseTest();

        this.url = new StringBuilder()
                .append(this.baseTest.getSetupProperty("base-url"))
                .append(this.baseTest.getSetupProperty(path))
                .toString();
        return this.url;
    }

    public String setEnviromentGetId(String path, int id){
        this.baseTest = new BaseTest();

        this.url = new StringBuilder()
                .append(this.baseTest.getSetupProperty("base-url"))
                .append(this.baseTest.getSetupProperty(path))
                .append(id)
                .toString();
        return this.url;
    }

    public String setEnviromentPost(String endpoint){
        this.baseTest = new BaseTest();

        this.url = new StringBuilder()
                .append(this.baseTest.getSetupProperty("base-url"))
                .append(this.baseTest.getSetupProperty(endpoint))
                .toString();
        return this.url;
    }
    public String setEnviromenGetListUsers(String parametro){
        this.baseTest = new BaseTest();

        this.url = new StringBuilder()
                .append(this.baseTest.getSetupProperty("base-url"))
                .toString();
        return this.url;
    }


}
