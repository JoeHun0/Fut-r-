/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

/**
 *
 * @author Diak
 */
public class Run {

    private int weekday;
    private int runId;
    private int km;

    public Run(int weekday, int runId, int km) {
        this.weekday = weekday;
        this.runId = runId;
        this.km = km;
    }

    public int getWeekday() {
        return weekday;
    }

    public int getRunId() {
        return runId;
    }

    public int getKm() {
        return km;
    }
}
