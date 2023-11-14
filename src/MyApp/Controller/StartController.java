package MyApp.Controller;

import MyApp.MyApp;
import MyApp.Utils.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;

import java.io.IOException;


public class StartController {
    public MenuItem menuClose;
    public MenuItem menuAbout;

    public View currentView = View.None;

    public void onMenuCloseClick() {
        MyApp.instance.shutdown();
    }

    public void onMenuAboutClick(){
        MyApp.instance.showAboutBox();
    }


    public void onMenuTicTacToeClick(ActionEvent actionEvent) throws IOException {
        MyApp.instance.loadView(View.TicTacToeView);
    }

    public void onMenuShellGameClick(ActionEvent actionEvent) throws IOException {
        MyApp.instance.loadView(View.shellGameView);
    }

    public void onMenuReadClick(ActionEvent actionEvent) throws IOException {
        MyApp.instance.loadView(View.ProdukteView);

    }

    public void onMenuCreateClick(ActionEvent actionEvent) throws IOException {
        MyApp.instance.loadView(View.ProduktCreateView);
    }



}
