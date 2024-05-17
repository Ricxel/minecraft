package Main;

import com.sun.webkit.dom.HTMLAppletElementImpl;
import controllers.MainSimpleController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.WrongCoordinatesException;

public class MainFX extends Application {

    public static void main(String[] args) throws WrongCoordinatesException {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainSimpleController mc = new MainSimpleController(new MainView());
        BorderPane root = (BorderPane) mc.getMainGUI();
        Scene scene = new Scene(root, 1200, 800);
        mc.redraw();
        stage.setScene(scene);
        stage.show();
    }
}
