package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjemploGridPaneg2 extends Application {

	@Override
	public void start(Stage stage) {

		GridPane grid = new GridPane();

		Slider slider = new Slider(0, 100, 20);

		Text texto1 = new Text("Texto1");

		Text texto2 = new Text("Texto2");

		Text texto3 = new Text("Texto3");

		Text texto4 = new Text("Texto4");

		Text textObs = new Text("Observaciones:");

		Button boton1 = new Button("Atrevete a pulsarme");

		TextField nombre = new TextField();

		TextArea observaciones = new TextArea();



		grid.setAlignment(Pos.CENTER);
		/*
		grid.setMargin(texto1, new Insets(10,10,10,10));
		grid.setMargin(texto2, new Insets(10,10,10,10));
		grid.setMargin(texto3, new Insets(10,10,10,10));
		grid.setMargin(texto4, new Insets(10,10,10,10));
		grid.setMargin(boton1, new Insets(10,10,10,10));
		grid.setMargin(nombre, new Insets(10,10,10,10));
		grid.setMargin(slider, new Insets(10,10,10,10));
		grid.setMargin(textObs, new Insets(10,10,10,10));
		grid.setMargin(observaciones, new Insets(10,10,10,10));
*/

		TextField nombre2 = new TextField();
		grid.add(nombre2, 0, 5);

		ComboBox edad = new ComboBox();

		edad.getItems().add("1");
		edad.getItems().add("1");
		edad.setValue("18");


		grid.setHgap(10);
		grid.setVgap(10);

		//Primera Fila
		grid.add(texto1,0,0);
		grid.add(texto2,1,0);
		grid.add(texto3, 2, 0);

		//Segunda Fila
		grid.add(texto4, 0, 1);
		grid.add(boton1, 1,1);
		grid.add(nombre, 2,1);


		//Añadimos el slider en la tercera fila (2)
		//para que ocupe las tres columnas ponemos 3 en colspan
		//para que ocupe tres posiciones en horizontal del grid
		grid.add(slider,0,2,3,1);

		//Añadimos las observaciones
		grid.add(textObs, 0, 3);
		grid.add(observaciones,1,3,2,2);

		Scene scene = new Scene(grid,600,400);

		stage.setScene(scene);

		stage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
