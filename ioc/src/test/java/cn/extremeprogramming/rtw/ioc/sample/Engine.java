package cn.extremeprogramming.rtw.ioc.sample;

import java.util.Date;

public class Engine {
    private final String id;

    public Engine(String id) {
        this.id = id;
    }

    public Engine() {
        id = "XP-xxx-xxx-xxxx";
    }

    @Override
    public String toString() {
        return "Engine: " + id;
    }
}
