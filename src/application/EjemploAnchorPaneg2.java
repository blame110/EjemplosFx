package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjemploAnchorPaneg2 extends Application {

	@Override
	public void start(Stage stage) {

		AnchorPane ancla = new AnchorPane();

		Text nombre = new Text("Nombre");
		TextField txtNombre = new TextField();

		Text sexo = new Text("Sexo");
		RadioButton masculino = new RadioButton("Masculino");
        RadioButton femenino = new RadioButton("Femenino");

        //Ponemos el nombre a 40px de distancia de arriba y 20 de la izquierda
        AnchorPane.setTopAnchor(nombre, 20.0);
        AnchorPane.setLeftAnchor(nombre, 20.0);

        //Añadimos el texto nombre al AnchorPane
        ancla.getChildren().add(nombre);

        //Ponemos el nombre a 40px de distancia de arriba y 20 de la izquierda
        AnchorPane.setTopAnchor(txtNombre, 18.0);
        AnchorPane.setLeftAnchor(txtNombre, 120.0);

        //Añadimos el texto nombre al AnchorPane
        ancla.getChildren().add(txtNombre);

      //Ponemos el nombre a 40px de distancia de arriba y 20 de la izquierda
        AnchorPane.setTopAnchor(sexo, 60.0);
        AnchorPane.setLeftAnchor(sexo, 20.0);

        //Añadimos el texto nombre al AnchorPane
        ancla.getChildren().add(sexo);

      //Ponemos el nombre a 40px de distancia de arriba y 20 de la izquierda
        AnchorPane.setTopAnchor(masculino, 60.0);
        AnchorPane.setLeftAnchor(masculino, 120.0);

        //Añadimos el texto nombre al AnchorPane
        ancla.getChildren().add(masculino);

        //Ponemos el nombre a 40px de distancia de arriba y 20 de la izquierda
        AnchorPane.setTopAnchor(femenino, 60.0);
        AnchorPane.setLeftAnchor(femenino, 210.0);

        //Añadimos el texto nombre al AnchorPane
        ancla.getChildren().add(femenino);

        //Para que los radiobutton funcionen como una unica seleccion
        //Hay que crear un ToggleGroup y asignarselo a todos los radioButton
        ToggleGroup sexGroup = new ToggleGroup();
        masculino.setToggleGroup(sexGroup);
        femenino.setToggleGroup(sexGroup);

        //Añadimos el texto de estado civil
        Text estadoCivil = new Text("Estado Civil");

        AnchorPane.setTopAnchor(estadoCivil, 90.0);
        AnchorPane.setLeftAnchor(estadoCivil, 20.0);

        ancla.getChildren().add(estadoCivil);

        //Añadimos un comboBox de seleccion
        ComboBox estado = new ComboBox();

        estado.getItems().add("Soltero");
        estado.getItems().add("Casado");
        estado.getItems().add("Divorciado");
        estado.getItems().add("Viudo");

        AnchorPane.setTopAnchor(estado, 90.0);
        AnchorPane.setLeftAnchor(estado, 120.0);

        ancla.getChildren().add(estado);








		Scene scene = new Scene(ancla, 400,400);

		stage.setScene(scene);

		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
