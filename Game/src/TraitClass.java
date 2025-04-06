public class TraitClass {
    private boolean RapidGrowth;
    private String trait1Name = "RapidGrowth";
    private boolean SlowGrowth;
    private String trait2Name = "SlowGrowth";
    private boolean DryRoots;
    private String trait3Name = "DryRoots";
    private boolean WetRoots;
    private String trait4Name = "WetRoots";
    private boolean MegaYeld;
    private String trait5Name = "MegaYeld";
    private boolean LessYeld;
    private String trait6Name = "LessYeld";
    private boolean FrostFighter;
    private String trait7Name = "FrostFighter";
    private boolean HeatFighter;
    private String trait8Name = "HeatFighter";

    public boolean isDryRoots() {
        return DryRoots;
    }
    public void setDryRoots(boolean dryRoots) {
        DryRoots = dryRoots;
    }

    public boolean isFrostFighter() {
        return FrostFighter;
    }

    public boolean isHeatFighter() {
        return HeatFighter;
    }

    public boolean isLessYeld() {
        return LessYeld;
    }

    public boolean isMegaYeld() {
        return MegaYeld;
    }

    public boolean isRapidGrowth() {
        return RapidGrowth;
    }

    public boolean isSlowGrowth() {
        return SlowGrowth;
    }

    public boolean isWetRoots() {
        return WetRoots;
    }

    public String getTrait1Name() {
        return trait1Name;
    }

    public String getTrait3Name() {
        return trait3Name;
    }

    public String getTrait4Name() {
        return trait4Name;
    }

    public String getTrait5Name() {
        return trait5Name;
    }

    public String getTrait6Name() {
        return trait6Name;
    }

    public String getTrait7Name() {
        return trait7Name;
    }

    public String getTrait8Name() {
        return trait8Name;
    }

    public String getTrait2Name() {
        return trait2Name;
    }

    public void setFrostFighter(boolean frostFighter) {
        FrostFighter = frostFighter;
    }

    public void setHeatFighter(boolean heatFighter) {
        HeatFighter = heatFighter;
    }
    public void setLessYeld(boolean lessYeld) {
        LessYeld = lessYeld;
    }
    public void setMegaYeld(boolean megaYeld) {
        MegaYeld = megaYeld;
    }
    public void setRapidGrowth(boolean rapidGrowth) {
        RapidGrowth = rapidGrowth;
    }
    public void setSlowGrowth(boolean slowGrowth) {
        SlowGrowth = slowGrowth;
    }
    public void setWetRoots(boolean wetRoots) {
        WetRoots = wetRoots;
    }

}
