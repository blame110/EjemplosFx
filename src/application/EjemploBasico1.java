package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjemploBasico1 extends Application {

	@Override
	public void start(Stage stage) {

		VBox vbox = new VBox();

		Text texto = new Text("Atrevete a pulsar el botón!");

		vbox.getChildren().add(texto);

		Button boton = new Button("Venga!");

		vbox.getChildren().add(boton);

		vbox.setAlignment(Pos.CENTER);

		vbox.setSpacing(10.0);




		Scene scene = new Scene(vbox, 800.0,600.0);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
