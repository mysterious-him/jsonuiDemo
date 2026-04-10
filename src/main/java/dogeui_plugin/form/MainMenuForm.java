package dogeui_plugin.form;

import cn.nukkit.Player;
import dogeui_plugin.form.easy_form.Modal;
import dogeui_plugin.form.easy_form.Simple;

/**
 * DogeUI Main Menu form.
 *
 * Uses "/D " title prefix to trigger DogeUI's image grid layout.
 * 8 button indices match DogeUI main.json grid (2-3-3 layout):
 *
 *   Row 1 [index 0-1]: 天界  领地
 *   Row 2 [index 2-4]: 商店  罗盘  合作社
 *   Row 3 [index 5-7]: 传送  图书室  设置
 *
 * Textures 01-09 map by index.
 */
public class MainMenuForm {

    public static void show(Player player) {
        // "/D " prefix triggers DogeUI's custom image grid rendering
        Simple form = new Simple("/D §e§l主菜单", "§7欢迎来到服务器！请选择功能", true);

        // === Row 1 (indices 0-1) ===
        form.add("天界",      () -> showInfoPanel(player, "天界", "§e天界系统\n§7探索天空之城的奥秘"));
        form.add("领地",      () -> showInfoPanel(player, "领地", "§e领地系统\n§7管理你的家园与领地"));

        // === Row 2 (indices 2-4) ===
        form.add("商店",      () -> showInfoPanel(player, "商店", "§e商店系统\n§7购买与出售物品"));
        form.add("罗盘",      () -> showInfoPanel(player, "罗盘", "§e罗盘导航\n§7快速定位与传送"));
        form.add("合作社",    () -> showInfoPanel(player, "合作社", "§e合作社\n§7与朋友一起协作共建"));

        // === Row 3 (indices 5-7) ===
        form.add("传送",      () -> showInfoPanel(player, "传送", "§e传送系统\n§7使用 /tpa <玩家> 发起传送请求"));
        form.add("图书室",    () -> showInfoPanel(player, "图书室", "§e服务器图书室\n§7查阅服务器规则与攻略"));
        form.add("设置",      () -> showInfoPanel(player, "设置", "§e个人设置\n§7功能开发中..."));

        form.show(player);
    }

    /**
     * Show an info panel using Modal for two-button dialogs.
     */
    private static void showInfoPanel(Player player, String title, String content) {
        Modal modal = new Modal("§e" + title, content, "返回菜单", "关闭");
        modal.setTruer(() -> show(player)); // 返回 -> reopen menu
        modal.setFalser(() -> {});          // 关闭 -> just close
        modal.asyncShow(player);
    }

    /**
     * Show a welcome dialog on player join.
     */
    public static void showWelcome(Player player) {
        Modal modal = new Modal(
                "§e§l欢迎来到服务器！",
                "§f你好, " + player.getName() + "!\n\n" +
                "§7请使用 §e/menu §7打开菜单\n" +
                "§7或输入 §e/菜单§7",
                "打开菜单",
                "我知道了"
        );
        modal.setTruer(() -> show(player));
        modal.asyncShow(player);
    }
}
