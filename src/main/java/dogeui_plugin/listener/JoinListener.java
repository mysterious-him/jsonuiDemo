package dogeui_plugin.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.scheduler.NukkitRunnable;
import dogeui_plugin.Main;
import dogeui_plugin.form.MainMenuForm;

public class JoinListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Delay 3 seconds for player to fully load
        new NukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) return;
                MainMenuForm.showWelcome(player);
            }
        }.runTaskLater(Main.plugin, 60); // 60 ticks = 3 seconds
    }
}
