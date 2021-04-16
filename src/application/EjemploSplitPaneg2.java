package application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class EjemploSplitPaneg2 extends Application {

	@Override
	public void start(Stage stage) {

		//Creamos un Tab Pane
		TabPane tab = new TabPane();

		//Creamos 3 Pestañas
		Tab tab1 = new Tab("Pestaña 1");
		Tab tab2 = new Tab("Pestaña 2");
		Tab tab3 = new Tab("Pestaña 3");
		Tab tab4 = new Tab("Pestaña 4");

		//Creamos y añadimos un toggleButton a la pestaña1
		ToggleButton presion = new ToggleButton("Pulsame");
		tab1.setContent(presion);

		//Creamos un textArea y se lo añadimos a la pestaña2
		TextArea texto = new TextArea();
		tab2.setContent(texto);


		//Creamos un CheckBox y lo añadimos al tercer panel
		CheckBox check = new CheckBox("Quieres Recifbir Publicidad");
		check.setSelected(true);

		tab3.setContent(check);

		//añadimos los paneles al tabPAne
		tab.getTabs().addAll(tab1,tab2,tab3,tab4);


		//Creamos un Split Pane
		SplitPane split = new SplitPane();

		//Creamos y añadimos un toggleButton a la pestaña1
		ToggleButton presion2 = new ToggleButton("Pulsame");
		tab1.setContent(presion);

		//Creamos un textArea y se lo añadimos a la pestaña2
		TextArea texto2 = new TextArea();
		tab2.setContent(texto);

		//Añadimos los elementos al splitPane
		split.getItems().addAll(presion2,texto2);

		split.setOrientation(Orientation.VERTICAL);

		//Metemos el splitPane en la pestaña 4
		tab4.setContent(split);


		//Añadimos el panel a la escena
		Scene scene = new Scene(tab,500.0,500.0);

		//Añadimos la scene al Stage y lo mostramos
		stage.setScene(scene);
		stage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
