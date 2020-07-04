/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class CustomerStatistic {
    private String time;
    private int count;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
