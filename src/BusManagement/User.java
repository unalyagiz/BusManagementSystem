package BusManagement;

import java.sql.*;

public class User {
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private int id;
    private String password;
    private Destinations destinations;

    public User() {
    }

    public User(int id, String password, Destinations destinations) {
        this.id = id;
        this.password = password;
        this.destinations=destinations;

    }
    public int Register(int ID,String password,Connection con)throws SQLException {

        String query="Insert into User(id,password) values(?,?) ";

        ps=con.prepareStatement(query);
        ps.setInt(1, ID);
        ps.setString(2,password);
        ps.executeUpdate();
        return 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Destinations getDestinations() {
        return destinations;
    }

    public void setDestinations(Destinations destinations) {
        destinations.setPrice(destinations.getPrice()*0.75);
        this.destinations = destinations;
    }
}
