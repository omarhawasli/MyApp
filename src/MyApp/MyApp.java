    package MyApp;

    import MyApp.Model.Produkt;
    import MyApp.Model.ProduktModel;
    import MyApp.Utils.View;
    import javafx.application.Application;
    import javafx.application.Platform;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.control.Alert;
    import javafx.scene.control.ButtonType;
    import javafx.scene.control.Label;
    import javafx.scene.image.Image;
    import javafx.scene.layout.*;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.io.InputStream;



    public class MyApp extends Application {

        //SINGLETON

        public static MyApp instance;
        Stage primaryStage;
        BorderPane rootLayout;
        public static void run(String []args){
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {

            this.primaryStage = primaryStage;
            if(instance == null){
                instance = this; //singleton zuweisen
            }


            primaryStage.setTitle("MyApp");
            primaryStage.setWidth(1024);
            primaryStage.setHeight(768);
            primaryStage.setResizable(false);

            setIcon();
            initRootLayout();
//            loadView(View.ProdukteView);

            primaryStage.show();


        }

        void setIcon(){
            InputStream iconStream = getClass().getResourceAsStream("/images/j.png");
            Image image = new Image(iconStream);
            primaryStage.getIcons().add(image);

        }

        public void initRootLayout(){
            try{
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/MyApp/View/StartView.fxml"));
                rootLayout = loader.load();

                Scene scene = new Scene(rootLayout);
                primaryStage.setScene(scene);


            }catch(IOException e){
                e.printStackTrace();
            }
        }

        public void loadView(View newView) throws IOException {



            String viewPath = "/MyApp/View/" + newView.toString() + ".fxml";

            rootLayout.getChildren().remove(rootLayout.getCenter());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(viewPath));

            Pane pane = loader.load();
            rootLayout.setCenter(pane);

        }

        public void shutdown(){
            if(showConfirmation("MyApp","Schliessen?","Wollen Sie Wirklich die App Beenden?") == 1){
                Platform.exit();
                System.exit(0);
            }
        }

        public void showAboutBox(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("My App");
            alert.setHeaderText("My App 2023");
            alert.setContentText("Dies ist eine Demo App");
            alert.show();
        }

        public int showConfirmation(String title,String header, String content){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,title, ButtonType.YES,ButtonType.NO);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);

            alert.showAndWait();

            if(alert.getResult() == ButtonType.YES){
                return 1;
            }else if(alert.getResult() == ButtonType.NO){
                return 0;
            }else{
                return -1;
            }
        }




    }
