package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EjemMenug2 extends Application {

	@Override
	public void start(Stage stage) {

		//Creamos la barra de menu
		MenuBar barra = new MenuBar();


		//Creamos los menus principales
		Menu productos = new Menu("Productos");
		Menu opciones = new Menu("Opciones");
		Menu ayuda = new Menu("Ayuda");

		//A�adimos opciones a los menus
		MenuItem verProductos = new MenuItem("Ver Productos");
		MenuItem calculos = new MenuItem("C�lculos");

		//Ponemos un icono a un menuItem con setGraphic
		calculos.setGraphic(new ImageView("file:pera.png"));


		MenuItem cerrar = new MenuItem("Cerrar");
		productos.getItems().addAll(verProductos,calculos,cerrar);

		MenuItem configuracion = new MenuItem("Configuraci�n");
		opciones.getItems().add(configuracion);

		MenuItem tutoriales = new MenuItem("Tutoriales");
		MenuItem acercade = new MenuItem("Acerca De");
		ayuda.getItems().addAll(tutoriales,acercade);

		//A�adimos los menus al menubar
		barra.getMenus().addAll(productos,opciones,ayuda);




		//A�adimos la barra de menu al Vbox
		VBox vbox = new VBox(barra);

		Scene scene = new Scene(vbox,500.0,500.0);





		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
