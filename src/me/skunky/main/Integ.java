package me.skunky.main;

import me.skunky.commands.Home;
import me.skunky.files.MysqlFile;

public class Integ {

    Main m = new Main();
    MysqlFile s = new MysqlFile();

    public void integData() {
        s.setStandard();
        s.readData();
    }

    public void integEvents() {
        
    }

    public void integCommands() {
        m.getCommand("home").setExecutor(new Home());
    }

    public boolean saveType() {
        return m.getConfig().getBoolean("SaveTypeOnline");
    }

}