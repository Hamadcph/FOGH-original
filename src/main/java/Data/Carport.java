package Data;


public class Carport {
      private int id;
      private int length;
      private int width;
      private int inclination;
      private String rooftype;

    public Carport(int id, int length, int width, int inclination, String rooftype) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.inclination = inclination;
        this.rooftype = rooftype;
    }

    public Carport(int length, int width, int inclination, String rooftype) {
        this.length = length;
        this.width = width;
        this.inclination = inclination;
        this.rooftype = rooftype;
    }
    

    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getInclination() {
        return inclination;
    }

    public String getRooftype() {
        return rooftype;
    } 

    @Override
    public String toString() {
        return "Carport{" + "id=" + id + ", length=" + length + ", width=" + width + ", inclination=" + inclination + ", rooftype=" + rooftype + '}';
    }
    
    
}
