package dogeui_plugin.form;

import cn.nukkit.Player;
import dogeui_plugin.form.easy_form.Simple;

/**
 * DogeUI 主菜单表单。
 *
 * 使用 "/D " 标题前缀触发DogeUI的自定义图片网格布局。
 * 8个按钮对应DogeUI的main.json网格（2+3+3排列）：
 *
 *
 * 贴图01-08按索引一一对应。
 */
public class MainMenuForm {

    public static void show(Player player) {
        // "/D " 前缀触发DogeUI的自定义图片网格渲染
        Simple form = new Simple("/D §e§l主菜单", "§7欢迎来到服务器！请选择功能", true);

        // === 第1行 [0-1] ===
        form.add("传送",      () -> player.sendMessage("§a你点击了传送按钮"));
        form.add("公会",      () -> player.sendMessage("§a你点击了公会按钮"));

        // === 第2行 [2-4] ===
        form.add("商店",      () -> player.sendMessage("§a你点击了商店按钮"));
        form.add("领地",      () -> player.sendMessage("§a你点击了领地按钮"));
        form.add("地下城",    () -> player.sendMessage("§a你点击了地下城按钮"));

        // === 第3行 [5-7] ===
        form.add("音乐",      () -> player.sendMessage("§a你点击了音乐按钮"));
        form.add("设置",    () -> player.sendMessage("§a你点击了设置按钮"));
        form.add("其他",      () -> player.sendMessage("§a你点击了其他按钮"));

        form.show(player);
    }
}
