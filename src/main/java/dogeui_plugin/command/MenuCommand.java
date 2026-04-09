package dogeui_plugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import dogeui_plugin.form.MainMenuForm;

public class MenuCommand extends Command {

    public MenuCommand() {
        super("menu", "打开DogeUI菜单", "/menu", new String[]{"菜单"});
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§c该命令只能由玩家执行！");
            return false;
        }
        MainMenuForm.show(player);
        return true;
    }
}
