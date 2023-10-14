import java.io.IOException;

public class Ausgeführt {
    public static void main(String[] args) {
    
        
 Goldpreis test = new Goldpreis("gold.txt"); // eventuell anderer Pfad
 System.out.println(test.getPreis("2009-10-20")); // 22870.0
 System.out.println(test.getPreis("2009-02-07")); // -1
 test.printMinMax();


       
}

}
