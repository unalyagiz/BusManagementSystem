package BusManagement;

import BusManagement.Destinations;
import BusManagement.User;
import BusManagement.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {


    public static void main(String args[]) throws SQLException {
        //connecting to database
        Connection con = null;
        User usr = new User();
        ArrayList<Destinations> dest = new ArrayList<Destinations>();
        try {
            String url = "jdbc:sqlite:C://users//YGU//Desktop//BusManagement.db";
            con = DriverManager.getConnection(url);
            System.out.println("Connection established");
            Statement statement = con.createStatement();
            String s = "SELECT * FROM Destination ";
            ResultSet rs = statement.executeQuery(s);
            ArrayList<Integer> availableseats = new ArrayList<Integer>();
            for (int i = 1; i <= 40; i++) {
                availableseats.add(i);
            }
            while (rs.next()) {

                //extracting the routes information from database and adding them into objects
                dest.add(new Destinations(rs.getInt("id"),rs.getString("where"),
                        rs.getString("to"), rs.getDouble("price"),
                        rs.getInt("duration"), new ArrayList<Integer>(availableseats)));


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        Scanner scan = new Scanner(System.in);
        //Deleting the booked seats from available seats
         Statement st = con.createStatement();
         ResultSet res =  st.executeQuery("SELECT routeno,seatno from Seat");
         while (res.next()){
             for(int i =0;i<dest.size();i++){
                 if(dest.get(i).getId()==(res.getInt("routeno"))) {
                     dest.get(i).getSeat().remove(Integer.valueOf(res.getInt("seatno")));
                 }
             }
         }
         //program launching
        System.out.println("\nWelcome to Bus Ticket System");
        System.out.println("Are you subscriber,yes for providing information..(NO) for without registration,(register)for registration");
        System.out.println("Registered costumers may have benefits..");
        //checking that user in the database
        String usrnf = scan.next();
         if (usrnf.toLowerCase().equals("yes")) {
             System.out.println("Enter your id");
             int usrid = scan.nextInt();
             System.out.println("Enter your password");
             String usrpw = scan.next();
             String statt = "SELECT * FROM User where [id]=? and [password]=?";
             PreparedStatement preff = con.prepareStatement(statt);
             preff.setInt(1, usrid);
             preff.setString(2, usrpw);
             ResultSet rsaa = preff.executeQuery();
             while (rsaa.next()) {
                 System.out.println("Welcome" + rsaa.getInt("id"));
             }
             usr.setId(usrid);
             usr.setPassword(usrpw);

         }
         else if(usrnf.toLowerCase().equals("register")){
             System.out.println("Choose your id");
             int idr=scan.nextInt();
             System.out.println("Choose your pw");
             String pwr=scan.next();
             usr.Register(idr,pwr,con);
             usr.setId(idr);
             usr.setPassword(pwr);
             System.out.println(idr+"Welcome...");
         }
         else {
             System.out.println("Proceeding without registration..");
         }

        //infinite while loop executes
        while (1 == 1) {
            System.out.println("\nWelcome to Bus Ticket System");
            System.out.println("1: Buy Ticket");
            System.out.println("2: See avaible routes and seats");
            System.out.println("Exit");
            int s = scan.nextInt();
            switch (s) {
                case 1:
                    //extracting the avaible routes information from database
                    //if particular search is not found then navigate through BusManagement.main loop
                    //to see available ones
                    System.out.println("Where are you located ?");
                    String where = scan.next().toLowerCase().trim();
                    System.out.println("Where would you like to go?");
                    String to = scan.next().toLowerCase().trim();
                    String stat = "SELECT * FROM Destination where [where]=? and [to]=?";
                    PreparedStatement pre = con.prepareStatement(stat);
                    pre.setString(1, where);
                    pre.setString(2, to);
                    ResultSet rsa1 = pre.executeQuery();
                    Destinations chosen = null;
                    if (rsa1.next() == false) {
                        System.out.println("No record is found..Please take a look at available routes..");
                        break;
                    } else {
                        do {
                            for(int i =0;i<dest.size();i++){
                                if(dest.get(i).getWhere().equals(rsa1.getString("where")) &&
                                dest.get(i).getTo().equals(rsa1.getString("to"))){
                                    chosen = dest.get(i);
                                    if(usr.getId()!=0){
                                        usr.setDestinations(chosen);
                                    }
                                }
                            }
                            System.out.println(rsa1.getString("where") + " - " +
                                    rsa1.getString("to") + " >> price: " +
                                    rsa1.getDouble("price") + " >> duration: " +
                                    rsa1.getInt("duration"));
                        }
                        while (rsa1.next());
                    }
                    //checking if user continue with the selected route
                    //if not navigate through BusManagement.main loop
                    System.out.println("Do you want to countinue with that route..(Y/N)");
                    String countinue = scan.next();
                    if (countinue.toUpperCase().equals("N"))
                        break;
                    else

                    if(usr.getId()!=0){
                        System.out.println("You are subscriber so your price is discounted");
                        System.out.println("Here is a route for you;\n" + usr.getDestinations().getWhere() +
                                " is the take-off place\n" + usr.getDestinations().getTo() +
                                " is the arrival point\n" + "Duration will be " + usr.getDestinations().getDuration() + " minutes" + "\nPrice is " + usr.getDestinations().getPrice());
                        System.out.println("Here is the avaible seats..");
                        //displaying the seats of particular route
                        //displaying the seats of particular route
                        System.out.println(usr.getDestinations().getSeat());
                        System.out.println("\nSelect seat ");
                        int seatNo = scan.nextInt();
                        //removing the selected seat from available seats.
                        usr.getDestinations().getSeat().remove(Integer.valueOf(seatNo));
                        System.out.println(usr.getDestinations().getSeat());
                        System.out.println("Would you like to take a vip seat with lots of benefits..");
                        System.out.println("Additional fee on %12.5 (if so type \"yes\")");
                        String seatType = scan.next();
                        //creating seat for storing data in the seat object
                        Seat seat;
                        if (seatType.toLowerCase().equals("yes")) {
                            seat = new Seat(usr.getDestinations().getId(),seatNo, "vip", usr.getDestinations());
                            //seat price is multiplied by the value of specified in the constructor
                            System.out.println("You have purchased vip seat for " + seat.getPrice());
                        } else {
                            seat = new Seat(usr.getDestinations().getId(),seatNo, "regular", usr.getDestinations());
                            System.out.println("You have purchased regular seat");
                        }
                        PreparedStatement pre1 = con.prepareStatement("INSERT INTO Seat values (?,?,?,?)");
                        pre1.setInt(1,seat.getRouteno());
                        pre1.setInt(2,seat.getNo());
                        pre1.setString(3,seat.getType());
                        pre1.setDouble(4,seat.getPrice());
                        pre1.executeUpdate();
                        break;

                    }
                    else {
                        System.out.println("Here is a route for you;\n" + chosen.getWhere() +
                                " is the take-off place\n" + chosen.getTo() +
                                " is the arrival point\n" + "Duration will be " + chosen.getDuration() + " minutes" + "\nPrice is " + chosen.getPrice());
                        System.out.println("Here is the avaible seats..");
                        //displaying the seats of particular route
                        System.out.println(chosen.getSeat());
                        System.out.println("\nSelect seat ");
                        int seatNo = scan.nextInt();
                        //removing the selected seat from available seats.
                        chosen.getSeat().remove(Integer.valueOf(seatNo));
                        System.out.println(chosen.getSeat());
                        System.out.println("Would you like to take a vip seat with lots of benefits..");
                        System.out.println("Additional fee on %12.5 (if so type \"yes\")");
                        String seatType = scan.next();
                        //creating seat for storing data in the seat object
                        Seat seat;
                        if (seatType.toLowerCase().equals("yes")) {
                            seat = new Seat(chosen.getId(),seatNo, "vip", chosen);
                            //seat price is multiplied by the value of specified in the constructor
                            System.out.println("You have purchased vip seat for " + seat.getPrice());
                        } else {
                            seat = new Seat(chosen.getId(),seatNo, "regular", chosen);
                            System.out.println("You have purchased regular seat");
                        }
                        PreparedStatement pre1 = con.prepareStatement("INSERT INTO Seat values (?,?,?,?)");
                        pre1.setInt(1,seat.getRouteno());
                        pre1.setInt(2,seat.getNo());
                        pre1.setString(3,seat.getType());
                        pre1.setDouble(4,seat.getPrice());
                        pre1.executeUpdate();
                        break;
                    }


                case 2:
                    //loop through available routes and their seats
                    for(int i=0;i<dest.size();i++)
                        System.out.println(dest.get(i).getWhere()+" - "+dest.get(i).getTo()+" >>"+"price: "+dest.get(i).getPrice()
                                +">>Avaible Seats:"+dest.get(i).getSeat().size());


                    break;
                case 3:
                    //terminating the program
                    System.exit(0);

            }
        }
    }
}


