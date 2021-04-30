package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaFXML extends Application {

	@Override
	public void start(Stage stage) {

		Parent root;

		try {

			root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
			Scene scene = new Scene (root, 600.0,400.0);

			stage.setScene(scene);
			stage.show();


		}catch (IOException e){
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
