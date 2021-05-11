package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EjemploAnchorPane2 extends Application {

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

        //Cuando se seleciona un elemento del combobox se copia en el nombre
        estado.setOnAction(value ->{
        	int seleccionado = estado.getSelectionModel().getSelectedIndex();
        	txtNombre.setText((String)estado.getItems().get(seleccionado));
        });

        AnchorPane.setTopAnchor(estado, 90.0);
        AnchorPane.setLeftAnchor(estado, 120.0);

        ancla.getChildren().add(estado);

        Button cerrar = new Button("Cerrar");
        Button abrirVentana = new Button("Abrir Ventana");

        //Ponemos un evento para que se cierre la aplicacion al pulsar el boton cerrar
        cerrar.setOnMouseClicked(value -> {

        	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Aviso");
        	alert.setHeaderText(null);
        	alert.setContentText("La aplicación se cerrará en nada");

        	//Showandwait espera a que cierres la ventana para seguir
        	//Con el codigo
        	alert.showAndWait();

        	stage.close();
        });


        //Cuando pulsamos sobre abrirVentana
        //Cargamos otro stage
        abrirVentana.setOnAction(value->{

        	Stage ventana = new Stage();
        	Scene scene1;
        	VBox vbox = new VBox();

        	Text texto = new Text("Esta es una ventana customizada");
        	Button boton1 = new Button("Cerrar");

        	vbox.getChildren().addAll(texto,boton1);

        	scene1 = new Scene(vbox, 300.0,200.0);

        	boton1.setOnAction(value1 ->{
        		ventana.close();
        	});

        	ventana.setScene(scene1);
        	ventana.show();



        });


        cerrar.setOnMouseEntered(value ->{
        	cerrar.setTextFill(Color.DARKVIOLET);
        	cerrar.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(20.0), Insets.EMPTY)));
        });

        //Posicionamos los botones en el anchorPane
        AnchorPane.setTopAnchor(cerrar, 130.0);
        AnchorPane.setLeftAnchor(cerrar, 20.0);

        AnchorPane.setTopAnchor(abrirVentana, 130.0);
        AnchorPane.setLeftAnchor(abrirVentana, 120.0);

        //Añadimos los botones al panel
        ancla.getChildren().add(cerrar);
        ancla.getChildren().add(abrirVentana);











		Scene scene = new Scene(ancla, 400,400);

		stage.setScene(scene);

		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
