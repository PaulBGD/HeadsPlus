package io.github.thatsmusic99.headsplus.config.challenges;

import org.bukkit.DyeColor;

public enum HeadsPlusChallengeDifficulty {
    
    EASY("easy", "&8[&a&lEasy&8]", DyeColor.GREEN, 20, 1, 1),
    EASY_MEDIUM("easy_medium", "&8[&a&lEasy&8-&6&lMedium&8]", DyeColor.LIME, 22, 1, 2),
    MEDIUM("medium","&8[&6&lMedium&8]", DyeColor.YELLOW, 24, 1, 3),
    MEDIUM_HARD("medium_hard", "&8[&6&lMedium&8-&c&lHard&8]", DyeColor.ORANGE, 30, 1, 4),
    HARD("hard", "&8[&c&lHard&8]", DyeColor.RED, 32, 1, 5),
    TEDIOUS("tedious", "&8[&c&lTedious&8]", DyeColor.BLUE, 20, 2, 6),
    TEDIOUS_PAINFUL("tedious_painful", "&8[&c&lTedious&8-&5&lPainful&8]", DyeColor.PURPLE, 22, 2, 7),
    PAINFUL("painful", "&8[&5&lPainful&8]", DyeColor.MAGENTA,  24, 2, 8),
    PAINFUL_DEADLY("painful_deadly", "&8[&5Painful&8-&4Deadly&8]", DyeColor.PINK, 30, 2, 9),
    DEADLY("deadly", "&8[&4Deadly&8]", DyeColor.RED, 32, 2, 10);

    public String key;
    String displayName;
    public DyeColor color;
    public int i;
    public int p;
    public int page;
    public int min;

    HeadsPlusChallengeDifficulty(String key, String dn, DyeColor color, int i, int page, int min) {
        this.key = key;
        this.displayName = dn;
        this.color = color;
        this.i = i;
        this.page = page;
        this.min = min;
    }
}
