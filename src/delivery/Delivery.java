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
        t.sortList();
        
    }
    
}
