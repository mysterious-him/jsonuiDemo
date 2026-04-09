package dogeui_plugin.form;

import cn.nukkit.Player;
import dogeui_plugin.form.easy_form.Modal;
import dogeui_plugin.form.easy_form.Simple;

/**
 * DogeUI Main Menu form.
 *
 * Uses "/D " title prefix to trigger DogeUI's image grid layout.
 * The 12 button indices match DogeUI main.json grid positions:
 *
 *   Left column (items_1):
 *     Row 1 [33%]: 0-地图  1-守护者  2-北方冻原
 *     Row 2 [42%/58%]: 3-传送  4-图书室
 *     Row 3 [33%]: 5-设置  6-留言板  7-排行榜
 *
 *   Right column (items_2):
 *     Ad banner [67%]: 8-万能工具
 *     Bottom row: 9-留言板 + camera + info
 *     10-拍照
 *     11-信息
 */
public class MainMenuForm {

    public static void show(Player player) {
        // "/D " prefix triggers DogeUI's custom image grid rendering
        Simple form = new Simple("/D §e§l主菜单", "§7欢迎来到服务器！请选择功能", true);

        // === Left grid: 3+2+3 layout matching DogeUI's textures ===

        // Row 1 (indices 0-2): each ~33% width
        form.add("地图",      () -> showInfoPanel(player, "地图", "§e查看服务器地图与坐标"));
        form.add("守护者",    () -> showInfoPanel(player, "守护者", "§e守护者系统说明\n§7保护你的家园不受侵害"));
        form.add("北方冻原",  () -> showInfoPanel(player, "北方冻原", "§e北方冻原传送点\n§7坐标: 1000, 64, -500"));

        // Row 2 (indices 3-4): 42% + 58% width
        form.add("传送",      () -> showInfoPanel(player, "传送", "§e传送系统\n§7使用 /tpa <玩家> 发起传送请求"));
        form.add("图书室",    () -> showInfoPanel(player, "图书室", "§e服务器图书室\n§7查阅服务器规则与攻略"));

        // Row 3 (indices 5-7): each ~33% width
        form.add("设置",      () -> showInfoPanel(player, "设置", "§e个人设置\n§7功能开发中..."));
        form.add("留言板",    () -> showInfoPanel(player, "留言板", "§e留言板\n§7功能开发中..."));
        form.add("排行榜",    () -> showInfoPanel(player, "排行榜", "§e排行榜\n§7功能开发中..."));

        // === Right column ===

        // Index 8: Ad banner area (large ~67% height)
        form.add("万能工具",  () -> showInfoPanel(player, "万能工具", "§e万能工具箱\n§7集合了多种实用工具"));

        // Index 9: Message board (bottom ~33% of right column)
        form.add("公告板",    () -> showInfoPanel(player, "公告板", "§e最新公告\n§7暂无新公告"));

        // Index 10: Camera button (small sidebar)
        form.add("拍照",      () -> player.sendMessage("§e§l提示: §r§7请使用游戏内截图功能拍照！"));

        // Index 11: Info button (small sidebar)
        form.add("信息",      () -> showInfoPanel(player, "服务器信息",
                "§e§l服务器信息\n" +
                "§r§7━━━━━━━━━━━━━━━\n" +
                "§f核心: §aNukkit-MOT\n" +
                "§fUI: §aDogeUI\n" +
                "§f插件: §aDogeUIPlugin v1.0.0\n" +
                "§7━━━━━━━━━━━━━━━"));

        form.show(player);
    }

    /**
     * Show an info panel using "/TEXT " prefix for DogeUI text layout.
     * Uses Modal for two-button dialogs (DogeUI's message_form overlay).
     */
    private static void showInfoPanel(Player player, String title, String content) {
        Modal modal = new Modal("§e" + title, content, "返回菜单", "关闭");
        modal.setTruer(() -> show(player)); // 返回 -> reopen menu
        modal.setFalser(() -> {});          // 关闭 -> just close
        modal.asyncShow(player);
    }

    /**
     * Show a welcome dialog on player join.
     * DogeUI auto-overlays the popup_dialog with custom textures.
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
