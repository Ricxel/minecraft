package Main;

import data.SandBlock;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import visual.BlockPane;

public class MainGUI extends Application {
    public void start(Stage primaryStage){
        BlockPane root = new BlockPane(new SandBlock());
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Prova");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch();
    }
}
