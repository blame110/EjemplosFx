package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class EjemploBorderPane2 extends Application {

	@Override
	public void start(Stage stage) {



		BorderPane borde = new BorderPane();

		TextArea texto = new TextArea();
		texto.setMaxSize(350.0, 550.0);

		borde.setRight(texto);

		ToggleButton pulsame1 = new ToggleButton("Pulsame");
		ToggleButton pulsame2 = new ToggleButton("Pulsame ya");
		ToggleButton pulsame3 = new ToggleButton("Vengaaaa");

		//Cambio del tipo y tamaño de la fuente
		pulsame1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 17));
		//Cambiamos el color de la fuente
		pulsame1.setTextFill(Color.BLUEVIOLET);

		//Creamos un toggleGroup para que todos los botones sean
		//Un unico elemento
		ToggleGroup toggle1 = new ToggleGroup();
		toggle1.getToggles().addAll(pulsame1,pulsame2,pulsame3);


		//Creamos un Hbox para contener todos los toggle button
		HBox hbox = new HBox();
		hbox.getChildren().addAll(pulsame1,pulsame2,pulsame3);
		hbox.setSpacing(8.0);

		borde.setTop(hbox);
		//Creo una separación por margen para el primer boton
		HBox.setMargin(pulsame1, new Insets(10.0,0.0,10.0,0.0));
		HBox.setMargin(pulsame2, new Insets(10.0,0.0,10.0,0.0));
		HBox.setMargin(pulsame3, new Insets(10.0,0.0,10.0,0.0));


		//Creamos un grid pane

		GridPane grid = new GridPane();

		TextField nombre = new TextField();
		TextField apellidos = new TextField();
		Text txtNombre = new Text("Nombre:");
		Text txtApellidos = new Text("Apellidos:");
		CheckBox publicidad = new CheckBox("Recibir Publicidad");
		RadioButton masculino = new RadioButton("Masculino");
		RadioButton femenino = new RadioButton("Femenino");
		ComboBox edad = new ComboBox();

		//Añadimos valores al combobox
		for(int i=0; i<99;i++)
			edad.getItems().add(i);
		edad.setPrefWidth(200.0);

		//Añadimos un slider en la ultima fila
		 Slider slider = new Slider(0, 100, 0);

		 //Creamos un datepicker
		 DatePicker fecha = new DatePicker();

		 ColorPicker color = new ColorPicker();



		Button enviar = new Button("Enviar");

		//Ponemos un mensaje en el campo nombre
		nombre.setText("Escribe tu nombre");


		//Si pulsamos sobre el campo nombre borramos el texto inicial
		nombre.setOnMouseClicked(value -> {
			nombre.setText("");
		});

		//Primera fila del grid
		grid.add(txtNombre, 0, 0);
		grid.add(nombre, 1, 0);
		grid.add(masculino, 2, 0);

		//Segunda Fila
		grid.add(txtApellidos, 0, 1);
		grid.add(apellidos, 1, 1);
		grid.add(femenino, 2, 1);

		//Tercera Fila
//el combo box ocupa dos posiciones en horizontal
		grid.add(edad, 0, 2,2,1);
		grid.add(enviar, 2, 2);

		//Cuarta Fila
		grid.add(slider, 0, 4,3,1);

		//Quinta fila
		grid.add(fecha, 0, 5);
		grid.add(color, 2, 5);


		grid.setPadding(new Insets(8.0,8.0,8.0,8.0));
		grid.setHgap(10);
		grid.setVgap(10);




		//Ponemos el panel de grid en el centro del bordePane
		borde.setCenter(grid);








		Scene scene = new Scene(borde, 800.0,600.0);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
