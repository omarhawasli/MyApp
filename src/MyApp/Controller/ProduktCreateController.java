package MyApp.Controller;

import MyApp.Model.Produkt;
import MyApp.Model.ProduktModel;
import MyApp.MyApp;
import MyApp.Utils.View;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class ProduktCreateController {

    public static Produkt produkt;

    public TextField textProduktName;
    public TextField textPreis;
    public TextField textBeschreibung;

    ProduktModel produktcreate = new ProduktModel();

//    public void initialize(){
//        if(produkt != null){
//
//            textProduktName.setText(produkt.getProdukt_name());
//            textPreis.setText(String.valueOf(produkt.getPreis()));
//            textBeschreibung.setText(produkt.getBeschreibung());
//        }
//    }
    public void buttonOnCreateProdukt(ActionEvent actionEvent) throws SQLException, IOException {

        String produkt_name = textProduktName.getText();
        double preis = Double.parseDouble(textPreis.getText());
        String beschreibung = textBeschreibung.getText();

        Produkt produkt1 = new Produkt(produkt_name,preis,beschreibung);
        produktcreate.connect();

        produktcreate.createProduktHandel(produkt1);

        MyApp.instance.loadView(View.ProdukteView);


    }
}
