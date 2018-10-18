package delivery;

import java.io.IOException;

/**
 *
 * @author Diak
 */
public class Delivery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tasks t = new Tasks();
        try {
        t.readFromFile("tavok.txt");
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }
        System.out.println("2. Feladat:");
        System.out.println("A megtett km az első szállításnál " + t.firstTask());
        
        System.out.println("3. Feladat:");
        System.out.println("A megtett km az utolsó szállításnál " + t.seccondTask());
        
        System.out.println("6. feladat:");
         for (int i = 0; i < t.sixthTask().size(); i++) {
             System.out.println(i+1 + ". nap "+ t.sixthTask().get(i));
         }
        
        
    }
    
}
