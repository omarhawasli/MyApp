package MyApp.Model;

import MyApp.Controller.ProduktUpdateController;
import MyApp.Utils.DatabaseSetting;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ProduktModel {

    Connection connection;


    public void connect(){
        try{



            //Class.forName(DatabaseSetting.MYSQL_DRIVER);
            connection = DriverManager.getConnection(DatabaseSetting.MYSQL_URL,DatabaseSetting.MYSQL_USER,DatabaseSetting.MYSQL_PASSWORD);
            System.out.println("OK");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public ObservableList<Produkt> getAll() throws SQLException {

        String sql = "SELECT * FROM produkte;";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ObservableList<Produkt> produktListe = FXCollections.observableArrayList();

        while (resultSet.next()){

            int pid = resultSet.getInt("id");
            String produktname = resultSet.getString("produkte_name");
            double preis = resultSet.getDouble("preis");
            String beschreibung = resultSet.getString("beschreibung");

            Produkt produkt = new Produkt(pid, produktname, preis, beschreibung);
            produktListe.add(produkt);

        }

        return produktListe;
    }

    public void updateProduktHandel(Produkt produkt) throws SQLException {

        String sql = "UPDATE produkte SET produkte_name=? ,preis=? ,beschreibung=? WHERE id=?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        String produkt_name = produkt.getProdukt_name();
        double preis = produkt.getPreis();
        String beschreibung = produkt.getBeschreibung();
        int id = produkt.getId();

        preparedStatement.setString(1,produkt_name);
        preparedStatement.setDouble(2,preis);
        preparedStatement.setString(3,beschreibung);
        preparedStatement.setInt(4,id);

        preparedStatement.executeUpdate();


    }

    public void createProduktHandel(Produkt produkt) throws SQLException {
        String sql = "INSERT INTO produkte(produkte_name,preis,beschreibung) VALUES (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        String produkt_name = produkt.getProdukt_name();
        double preis = produkt.getPreis();
        String beschreibung = produkt.getBeschreibung();

        preparedStatement.setString(1,produkt_name);
        preparedStatement.setDouble(2,preis);
        preparedStatement.setString(3,beschreibung);

        preparedStatement.execute();
    }

}
