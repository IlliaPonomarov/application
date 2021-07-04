package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        MainView view = new MainView();
        Stage window;


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


    public static void main(String[] args) throws FileNotFoundException {

       Application.launch(args);
    }
}
