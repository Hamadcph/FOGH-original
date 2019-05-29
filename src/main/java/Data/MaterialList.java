package Data;

public class MaterialList {
    private int woodAmount;
    private int screwAmount;
    private int bracketAmount;

    public MaterialList(int woodAmount, int screwAmount, int bracketAmount) {
        this.woodAmount = woodAmount;
        this.screwAmount = screwAmount;
        this.bracketAmount = bracketAmount;
    }

    public int getWoodAmount() {
        return woodAmount;
    }

    public int getScrewAmount() {
        return screwAmount;
    }

    public int getBracketAmount() {
        return bracketAmount;
    }

    @Override
    public String toString() {
        return "MaterialList{" + "woodAmount=" + woodAmount + ", screwAmount=" + screwAmount + ", bracketAmount=" + bracketAmount + '}';
    }
    
    
}
