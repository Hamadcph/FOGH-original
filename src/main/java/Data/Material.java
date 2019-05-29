package Data;


public class Material {
    
    private int wood_qty;
    private int screw_qty;
    private String roof;
    private int bracket;
    private Carport carport;

    public Material(int wood_qty, int screw_qty, String roof, int bracket, Carport carport) {
        this.wood_qty = wood_qty;
        this.screw_qty = screw_qty;
        this.roof = roof;
        this.bracket = bracket;
        this.carport = carport;
    }

    public int getWood_qty() {
        return wood_qty;
    }

    public void setWood_qty(int wood_qty) {
        this.wood_qty = wood_qty;
    }

    public int getScrew_qty() {
        return screw_qty;
    }

    public void setScrew_qty(int screw_qty) {
        this.screw_qty = screw_qty;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public int getBracket() {
        return bracket;
    }

    public void setBracket(int bracket) {
        this.bracket = bracket;
    }

    public Carport getCarport() {
        return carport;
    }

    public void setCarport(Carport carport) {
        this.carport = carport;
    }

    @Override
    public String toString() {
        return "Material{" + "wood_qty=" + wood_qty + ", screw_qty=" + screw_qty + ", roof=" + roof + ", bracket=" + bracket + ", carport=" + carport + '}';
    }

}
