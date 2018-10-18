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
            sortList();
        }
    }

    public List<Run> getRuns() {
        return runs;
    }

    public void sortList() {
        Run temp = null;
        for (int i = 0; i < runs.size(); i++) {
            for (int j = 1; j < runs.size() - i; i++) {
                if (runs.get(j - 1).getWeekday() > runs.get(j).getWeekday()) {
                    temp = runs.get(j);
                    runs.set(j, runs.get(j - 1));
                    runs.set(j - 1, temp);
                }
            }
        }
        for (int i = 0; i < runs.size(); i++) {
            for (int j = 1; j < runs.size() - i; i++) {
                if (runs.get(j - 1).getWeekday() == runs.get(j).getWeekday()) {
                    if (runs.get(j - 1).getRunId() > runs.get(j).getRunId()) {
                        temp = runs.get(j);
                        runs.set(j, runs.get(j - 1));
                        runs.set(j - 1, temp);
                    }
                }
            }
        }
    }

    public int firstTask() {

        return runs.get(0).getKm();
    }

    public int seccondTask() {

        return runs.get(runs.size() - 1).getKm();
    }

    public void thirdTask() {
        List<Integer> kmPerDay = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            kmPerDay.set(i, 0);
        }
        for (Run r : runs) {
            switch (r.getWeekday()) {
                case 1:
                    kmPerDay.set(0, kmPerDay.get(0) + r.getKm());
                    break;
                case 2:
                    kmPerDay.set(1, kmPerDay.get(1) + r.getKm());
                    break;
                case 3:
                    kmPerDay.set(2, kmPerDay.get(2) + r.getKm());
                    break;
                case 4:
                    kmPerDay.set(3, kmPerDay.get(3) + r.getKm());
                    break;
            }

        }

    }

}
