package BusManagement;

import java.util.ArrayList;

public class Destinations {

    private int id;
    private String where;
    private String to;
    private double price;
    private int duration;
    private ArrayList<Integer> seat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Integer> getSeat() {
        return seat;
    }

    public void setSeat(ArrayList<Integer> seat) {
        this.seat = seat;
    }

    //no-argument constructor
    public Destinations() {
    }
    //parametrized constructor
    public Destinations(int id, String where, String to, double price, int duration, ArrayList<Integer>seat){
        this.id = id;
        this.where = where;
        this.to = to;
        this.price = price;
        this.duration = duration;
        this.seat =seat;
    }

}
