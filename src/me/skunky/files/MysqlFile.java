package me.skunky.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.skunky.mysql.Mysql;

public class MysqlFile {

    Mysql sql = new Mysql();

    public void setStandard() {
        FileConfiguration cfg = getFileConf();

        cfg.options().copyDefaults(true);

        cfg.addDefault("MySQL.Host", "localhost");
        cfg.addDefault("MySQL.Port", "3306");
        cfg.addDefault("MySQL.Database", "database");
        cfg.addDefault("MySQL.Username", "username");
        cfg.addDefault("MySQL.Password", "password");

        try {
            cfg.save(getFile());
        } catch (IOException e) {
            System.out.println("Error while saving MySQL.yml");
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void readData() {
        FileConfiguration cfg = getFileConf();

        sql.host = cfg.getString("MySQL.Host");
        sql.port = cfg.getString("MySQL.Port");
        sql.database = cfg.getString("MySQL.Database");
        sql.username = cfg.getString("MySQL.Username");
        sql.password = cfg.getString("MySQL.Password");
    }

    public File getFile() {
        return new File("plugins/Home-Manager", "MySQL.yml");
    }

    public FileConfiguration getFileConf() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

}
