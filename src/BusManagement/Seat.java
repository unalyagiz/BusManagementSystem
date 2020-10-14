package BusManagement;

import BusManagement.Destinations;

public class Seat {

    private int routeno;
    private int no;
    private String type;
    private double price;
    Destinations destination;

    public int getRouteno() {
        return routeno;
    }

    public void setRouteno(int routeno) {
        this.routeno = routeno;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Destinations getDestination() {
        return destination;
    }

    public void setDestination(Destinations destination) {
        this.destination = destination;
    }

    //no-argument constructor
    public Seat() {
    }
    //parametrized constructor
    public Seat(int routeno,int no,String type,Destinations destination){
        this.routeno = destination.getId();
        this.no = no;
        this.type = type;
        this.destination = destination;
        if(type.equals("vip"))
            this.price = destination.getPrice()*1.25;
        else
            this.price = destination.getPrice();

    }
}
