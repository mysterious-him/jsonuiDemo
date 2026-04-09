package dogeui_plugin;

import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginLogger;
import dogeui_plugin.command.MenuCommand;
import dogeui_plugin.listener.JoinListener;

/**
 * DogeUIPlugin - Nukkit-MOT plugin for DogeUI resource pack.
 *
 * Leverages DogeUI's title-prefix routing:
 *   /D  -> Main menu (custom image grid)
 *   /A  -> Ad panel
 *   /TEXT -> Text panel
 *   /C  -> Camera panel
 *
 * The resource pack handles ALL visual rendering.
 * This plugin only sends standard ModalFormRequest forms with correct prefixes.
 */
public class Main extends PluginBase {

    public static Plugin plugin;
    public static Server nkServer;
    public static PluginLogger logger;
    public static CommandSender consoleObjects;

    @Override
    public void onLoad() {
        nkServer = this.getServer();
        plugin = this;
        logger = this.getLogger();
        consoleObjects = getServer().getConsoleSender();
        logger.info("§b[DogeUI] 插件读取...");
    }

    @Override
    public void onEnable() {
        // Register listeners
        nkServer.getPluginManager().registerEvents(new JoinListener(), this);

        // Register commands
        nkServer.getCommandMap().register(this.getName(), new MenuCommand());

        logger.info("§a[DogeUI] 插件已启用！DogeUI 资源包集成就绪。");
        logger.info("§e[DogeUI] 使用 /menu 或 /菜单 打开主菜单");
    }

    @Override
    public void onDisable() {
        logger.info("§c[DogeUI] 插件已关闭。");
    }
}
