package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			//Creamos un panel donde iran todos los controles
			BorderPane root = new BorderPane();

			//Creamos un boton con el texto pulsame
			Button boton = new Button("Pulsame");

			//Creamos un texto para añdir al panel
			Text texto = new Text();
			texto.setText("A la derecha tienes un boton");

			texto.setFill(Color.GREEN);

			//Cambiamos la fuente del texto a Verdana, negrita, italica tamaño 30
			texto.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 30));

			//Cambiamos la alineacion del boton al centro, por defecto sale arriba
			BorderPane.setAlignment(boton, Pos.CENTER);


			BorderPane.setMargin(boton, new Insets(20,40,20,40));

			//Creamos un Grid
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


			//Creamos un panel VBox para el menu izquierdo de la app
			VBox izquierda = new VBox();

			//Creamos 5 botones
			Button boton2 = new Button("Opcion1");
			Button boton3 = new Button("Opcion2");
			Button boton4 = new Button("Opcion3");
			Button boton5 = new Button("Opcion4");
			Button boton6 = new Button("Opcion5");



			//Añadimos los botones al Vbox
			izquierda.getChildren().add(boton2);
			izquierda.getChildren().add(boton3);
			izquierda.getChildren().add(boton4);
			izquierda.getChildren().add(boton5);
			izquierda.getChildren().add(boton6);


			//Añadimos el boton en la posicion derecha del borderPane
			root.setRight(boton);

			//Añadimos un gridpanel en el centro
			root.setCenter(grid);

			//Añadimos un Vbox de menus a la izquierda
			root.setLeft(izquierda);

			//Se crea una escena a partir de ese panel, con una resolucion de 400x400
			//Las resoluciones siempre son horizontalxvertical
			Scene scene = new Scene(root,800,400);

			//Esta instruccion carga la hoja de estilos css
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//Cargamos la Scene en la Stage
			primaryStage.setScene(scene);

			//Mostramos la Stage en pantalla
			primaryStage.show();


		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
