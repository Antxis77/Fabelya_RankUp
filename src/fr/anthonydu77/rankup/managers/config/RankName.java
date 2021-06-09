package fr.anthonydu77.rankup.managers.config;

/**
 * Created by Anthonydu77 03/06/2021 inside the package - fr.anthonydu77.rankup.managers.config
 */

public enum RankName {

    GUEUX("Gueux"),
    CAMPAGNARD("Campagnard"),
    VILLAGEOIS("Villageois"),
    OUVRIER("Ouvrier"),
    ECUYER("Ecuyer"),
    CAVALIER("Cavalier"),
    CAPORAL("Caporal"),
    COLONELS("Colonels"),
    MARECHAL("Marechal"),
    COMMANDANT("Commandant"),
    COMPTE("Compte"),
    SOUVERAIN("Souverain"),
    ROI("Roi"),
    EMPEREUR("Empereur");

    private final String rankName;

    RankName(String rankName){
        this.rankName = rankName;
    }

    public String getRankName(){
        return rankName;
    }

}
