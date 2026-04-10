package dogeui_plugin;

import cn.nukkit.Server;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginLogger;
import dogeui_plugin.command.MenuCommand;

/**
 * DogeUI插件 - 基于Nukkit-MOT的DogeUI资源包集成插件。
 *
 * 利用DogeUI的标题前缀路由机制：
 *   标题以 "/D " 开头 -> 触发自定义图片网格菜单渲染
 *
 * 资源包负责所有视觉渲染，插件只负责发送带正确前缀的表单。
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
        logger.info("§b[DogeUI] 插件读取中...");
    }

    @Override
    public void onEnable() {
        // 注册命令
        nkServer.getCommandMap().register(this.getName(), new MenuCommand());

        logger.info("§a[DogeUI] 插件已启用！");
        logger.info("§e[DogeUI] 使用 /jsonui 打开主菜单");
    }

    @Override
    public void onDisable() {
        logger.info("§c[DogeUI] 插件已关闭。");
    }
}
