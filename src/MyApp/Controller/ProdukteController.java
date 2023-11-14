package MyApp.Controller;

import MyApp.Model.Produkt;
import MyApp.Model.ProduktModel;
import MyApp.MyApp;
import MyApp.Utils.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class ProdukteController {

    @FXML
    TextField textSearch;
    @FXML
    public TableView<Produkt> tableProdukte;
    @FXML
    public TableColumn<Produkt, Integer> id;
    @FXML
    public TableColumn<Produkt, String> produkt_name;
    @FXML
    public TableColumn<Produkt, Double> preis;
    @FXML
    public TableColumn<Produkt, String> beschreibung;

    ObservableList<Produkt> produkteListe = FXCollections.observableArrayList();


    public void initialize() throws SQLException {

        id.setCellValueFactory(new PropertyValueFactory<Produkt,Integer>("id"));
        produkt_name.setCellValueFactory(new PropertyValueFactory<Produkt,String>("produkt_name"));
        preis.setCellValueFactory(new PropertyValueFactory<Produkt,Double>("preis"));
        beschreibung.setCellValueFactory(new PropertyValueFactory<Produkt,String>("beschreibung"));

        ProduktModel produktemodel = new ProduktModel();

        produktemodel.connect();
        produkteListe = produktemodel.getAll();
        tableProdukte.setItems(produkteListe);

        textSearch.textProperty().addListener(((observable, oldText, newText) -> searchByName() ));

    }

    public void searchByName(){
            String Keyword = textSearch.getText();

            if(Keyword.isEmpty()){
                tableProdukte.setItems(produkteListe);
            }else{
                ObservableList<Produkt> filteredList = FXCollections.observableArrayList();

                for (Produkt produkt: produkteListe) {
                    if(produkt.getProdukt_name().toLowerCase().contains(Keyword))
                        filteredList.add(produkt);
                }
                tableProdukte.setItems(filteredList);
        }
    }

    public void onContextUpdateClick(ActionEvent actionEvent) throws IOException, SQLException {
        if(!produkteListe.isEmpty()){
            Produkt produkt = tableProdukte.getSelectionModel().getSelectedItem();

            if(produkt != null){

                ProduktUpdateController.produkt = produkt;
                MyApp.instance.loadView(View.ProduktUpdateView);

            }else{
                System.out.println("Debug es wurde Kein Produkt ausgewaelt");
            }
        }else{
            System.out.println("There is no Produkt");
        }

    }


}
