package Logic.Calculator;

import Data.Carport;
import Data.Material;


public class MaterialCalc {
    
    public Material calculator(int length, int width, int inclination, String roof) {
        Carport carport = new Carport(length, width, inclination, roof);
        // 1 metet = 10 stykker bræt
        int Lwood = length * 10;
        int Wwood = width * 10;
        int poles = 4;
        
        int total = Lwood*2 + Wwood + poles;
        
        //1.antal bræt, 2.antal skruer, 3.taget, 4.antal beslag, 5.carport
        Material m = new Material(total, total*5,roof,total*3, carport);
        
        return m;
    }
    
    
    
}
