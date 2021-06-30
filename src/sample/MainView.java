package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class MainView extends  Application{





    public void menuSystemAdmin(){
        System.out.println("Hi System Admin");
        Parent root;

        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXML/menuSysAdmin.fxml"));
            root = myLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:///D:/iconsApplication/icons8.png"));
            stage.setTitle("System Admin");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Authorizathion() throws IOException {

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Авторизация");
        primaryStage.getIcons().add(new Image("file:///D:/iconsApplication/icons8.png"));
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXML/sample.fxml"));
        Parent root = myLoader.load();
        Controller controller = myLoader.getController();

        primaryStage.setResizable(false);
        Scene myScene = new Scene(root);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }


    public void menuAdmin(){
        System.out.println("Hi Admin");
        Parent root;

        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXML/menuAdmin.fxml"));
            root = myLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:///D:/iconsApplication/icons8.png"));
            stage.setTitle("Admin");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void meniUser(){
        System.out.println("Hi User");
        Parent root;

        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXML/menuUser.fxml"));
            root = myLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:///D:/iconsApplication/icons8.png"));
            stage.setTitle("User");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listOf(){
        Parent root;
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("FXML/listOfItemsSupplier.fxml"));
            root = myLoader.load();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("file:///D:/iconsApplication/icons8.png"));
            stage.setTitle("User");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
