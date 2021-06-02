package fr.anthonydu77.rankup.managers.lang;

/**
 * Created by Anthonydu77 14/12/2020 inside the package - fr.anthonydu77.modmoderation.managers.lang
 */

public enum LangValue {
    PLAYER("player"),
    BLOCK("block"),
    TEAMS("teams"),
    AMOUNT("amount"),
    PRICE("price");

    private final String name;

    LangValue(String name) {
        this.name = name;
    }

    public String toName() {
        return "{" + name + "}";
    }
}
