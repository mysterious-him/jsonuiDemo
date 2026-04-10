package dogeui_plugin.form;

import cn.nukkit.Player;
import dogeui_plugin.form.easy_form.Simple;

/**
 * DogeUI 主菜单表单。
 *
 * 使用 "/D " 标题前缀触发DogeUI的自定义图片网格布局。
 * 8个按钮对应DogeUI的main.json网格（2+3+3排列）：
 *
 *   第1行 [0-1]: 天界  领地
 *   第2行 [2-4]: 商店  罗盘  合作社
 *   第3行 [5-7]: 传送  图书室  设置
 *
 * 贴图01-08按索引一一对应。
 */
public class MainMenuForm {

    public static void show(Player player) {
        // "/D " 前缀触发DogeUI的自定义图片网格渲染
        Simple form = new Simple("/D §e§l主菜单", "§7欢迎来到服务器！请选择功能", true);

        // === 第1行 [0-1] ===
        form.add("天界",      () -> player.sendMessage("§a你点击了天界按钮"));
        form.add("领地",      () -> player.sendMessage("§a你点击了领地按钮"));

        // === 第2行 [2-4] ===
        form.add("商店",      () -> player.sendMessage("§a你点击了商店按钮"));
        form.add("罗盘",      () -> player.sendMessage("§a你点击了罗盘按钮"));
        form.add("合作社",    () -> player.sendMessage("§a你点击了合作社按钮"));

        // === 第3行 [5-7] ===
        form.add("传送",      () -> player.sendMessage("§a你点击了传送按钮"));
        form.add("图书室",    () -> player.sendMessage("§a你点击了图书室按钮"));
        form.add("设置",      () -> player.sendMessage("§a你点击了设置按钮"));

        form.show(player);
    }
}
