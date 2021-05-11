package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ejemplo2FXML extends Application {

	@Override
	public void start(Stage stage) {

		Parent root;

		try {

			root = FXMLLoader.load(getClass().getResource("Ejemplo2FXML.fxml"));

			Scene scene = new Scene(root,800.0,600.0);
			stage.setScene(scene);
			stage.show();



		}catch (Exception e){
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
