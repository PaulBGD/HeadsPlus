package io.github.thatsmusic99.headsplus.commands.maincommand;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.commands.CommandInfo;
import io.github.thatsmusic99.headsplus.commands.IHeadsPlusCommand;
import io.github.thatsmusic99.headsplus.config.customheads.HeadsPlusConfigCustomHeads;
import io.github.thatsmusic99.headsplus.config.customheads.HeadsXEnums;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@CommandInfo(
        commandname = "restore",
        permission = "headsplus.maincommand.restore",
        subcommand = "restore",
        maincommand = true,
        usage = "/hp restore <Head Name>"
)
public class RestoreCommand implements IHeadsPlusCommand {
    @Override
    public String getCmdDescription(CommandSender sender) {
        return HeadsPlus.getInstance().getMessagesConfig().getString("descriptions.hp.restore", sender);
    }

    @Override
    public boolean fire(String[] args, CommandSender sender) {
        if (args.length > 1) {
            try {
                HeadsXEnums headToBeAdded = HeadsXEnums.valueOf(args[1].toUpperCase());
                HeadsPlusConfigCustomHeads customHeadsConfig = HeadsPlus.getInstance().getHeadsXConfig();
                customHeadsConfig.getConfig().set("heads." + headToBeAdded.name, null);
                customHeadsConfig.addHead(headToBeAdded.tex,
                        true,
                        headToBeAdded.dn,
                        headToBeAdded.sec,
                        "default",
                        true);
                HeadsPlus.getInstance().getMessagesConfig().sendMessage("commands.restore.restored-head", sender, "{head}", args[1]);
                return true;
            } catch (IllegalArgumentException ex) {
                HeadsPlus.getInstance().getMessagesConfig().sendMessage("commands.restore.invalid-head", sender, "{head}", args[1]);
                return true;
            }
        } else {
            HeadsPlus.getInstance().getMessagesConfig().sendMessage("commands.errors.invalid-args", sender);
            return false;
        }
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        List<String> results = new ArrayList<>();
        if (args.length == 2) {
            List<String> headNames = new ArrayList<>();
            for (HeadsXEnums head : HeadsXEnums.values()) {
                headNames.add(head.name().toLowerCase());
            }
            StringUtil.copyPartialMatches(args[1], headNames, results);
        }
        return results;
    }
}
