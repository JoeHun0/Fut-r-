/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diak
 */
public class Tasks {

    private List<Run> runs = new ArrayList<>();

    public void readFromFile(String fileName) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(" ");
                Run r = new Run(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                runs.add(r);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nem találom a filet!" + e.getMessage());
        } catch (IOException io) {
            System.out.println("Olvasási hiba" + io.getMessage());
        } finally {
            br.close();
        }
    }

    public List<Run> getRuns() {
        return runs;
    }
    public void sortList(){
        Run temp = null;
        for(int i = 0; i<runs.size();i++){
            for(int j = 1; j<runs.size()-i;i++){
                if (runs.get(j-1).getWeekday()>runs.get(j).getWeekday()){
                    temp=runs.get(j);
                    runs.set(j,runs.get(j-1));
                    runs.set(j-1, temp);
                }
            }
        }
    }
}
