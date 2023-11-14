package MyApp.Controller;

import MyApp.Model.Produkt;
import MyApp.Model.ProduktModel;
import MyApp.MyApp;
import MyApp.Utils.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class ProduktUpdateController {


    public TextField textProduktName;
    public TextField textPreis;
    public Button updateButton;

    public TextField textBeschreibung;

    public static Produkt produkt;

    public Label idLabel;
    ProduktModel produktupdate = new ProduktModel();

    public void initialize(){
        if(produkt != null){

            textProduktName.setText(produkt.getProdukt_name());
            textPreis.setText(String.valueOf(produkt.getPreis()));
            textBeschreibung.setText(produkt.getBeschreibung());
        }
    }

    public void onContextUpdateClick(ActionEvent actionEvent) throws SQLException, IOException {

        int id = produkt.getId();
        String produkt_name = textProduktName.getText();
        double preis = Double.parseDouble(textPreis.getText());
        String beschreibung = textBeschreibung.getText();


        Produkt produkt1 = new Produkt(id,produkt_name,preis,beschreibung);
        produktupdate.connect();

        produktupdate.updateProduktHandel(produkt1);

        MyApp.instance.loadView(View.ProdukteView);


    }
}
