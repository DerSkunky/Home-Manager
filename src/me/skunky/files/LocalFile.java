package me.skunky.files;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocalFile {

    File file = new File("plugins/Home-Manager", "PlayerWarpPoints.yml");
    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    private void save() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {
        try {
            cfg.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    //Clear everything of an specific Player(Admin Command)
    public void clearData(UUID uuid) {
        String id = uuid.toString();
        load();
        cfg.set(id, null);
        save();
    }

    //Player Command delete one specific WarpPoint
    public void delData(UUID uuid, String WarpName) {
        String id = uuid.toString();
        load();
        cfg.set(id + "." + WarpName, null);
        save();
    }

    public Location getData(UUID uuid, String WarpName) {
        String id = uuid.toString();

        load();
        World w = Bukkit.getWorld(cfg.getString(id + "." + WarpName +  ".World"));
        int x = cfg.getInt(id + "." + WarpName + ".X");
        int y = cfg.getInt(id + "." + WarpName + ".Y");
        int z = cfg.getInt(id + "." + WarpName + ".Z");

        return new Location(w, x, y, z);
    }

    //Also used for changeData
    public void addData(UUID uuid, String WarpName, World world, int x, int y, int z) {
        String id = uuid.toString();

        load();
        cfg.set(id + "." + WarpName + ".World", world.getName().toString());
        cfg.set(id + "." + WarpName + ".X", x);
        cfg.set(id + "." + WarpName + ".Y", z);
        cfg.set(id + "." + WarpName + ".Z", z);

        save();
    }

    public int listData(UUID uuid) {
        return 0;
    }
}
