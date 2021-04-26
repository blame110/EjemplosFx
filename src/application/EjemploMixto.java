package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EjemploMixto extends Application {

	@Override
	public void start(Stage stage) {


		//Creamos un Vbox, en la primera porcion añadiremos el menu
		//Y en la parte de abajo el tabpane con todo lo demas
		VBox principal = new VBox();
		SplitPane split = new SplitPane();
		TabPane pesta = new TabPane();

		MenuBar barraMenu = new MenuBar();

		//Creamos los menus
		Menu archivo = new Menu("Archivo");
		Menu opciones = new Menu("Opciones");
		Menu ayuda = new Menu("Ayuda");
		Menu preferencias = new Menu("Preferencias");

		//Al menu archivo le añadimos tres opciones
		MenuItem nuevo = new MenuItem("Nuevo..");
		MenuItem abrir = new MenuItem("Abrir");
		MenuItem cerrar = new MenuItem("Cerrar");

		nuevo.setOnAction( value ->{
			 final Stage dialog = new Stage();
             dialog.initModality(Modality.APPLICATION_MODAL);
             dialog.initOwner(stage);
             VBox dialogVbox = new VBox(20);
             dialogVbox.getChildren().add(new Text("This is a Dialog"));
             Scene dialogScene = new Scene(dialogVbox, 300, 200);
             dialog.setScene(dialogScene);
             dialog.show();
		});

		abrir.setOnAction( value ->{

			Parent root;

			try {
			//Cargamos el FXML
			root = FXMLLoader.load(getClass().getResource("EjemploFXLM.fxml"));

			final Stage dialog = new Stage();
	        dialog.initModality(Modality.APPLICATION_MODAL);
	        dialog.initOwner(stage);

	        Scene scene = new Scene(root, 300, 275);

	        dialog.setTitle("FXML Welcome");
	        dialog.setScene(scene);
	        dialog.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		//Ponemos un evento al pulsar sobre cerrar para que cierre la aplicacion
		cerrar.setOnAction(value -> {
			stage.close();
		});

		archivo.getItems().addAll(nuevo,abrir,cerrar);

		//En preferencias añadimos la opcion estilo
		MenuItem estilo = new MenuItem("Estilo");
		preferencias.getItems().add(estilo);
		//Añadimos el menu preferencias dentro del menu opciones
		//Para que se despliegen sus opciones
		opciones.getItems().add(preferencias);
		opciones.setGraphic(new ImageView("file:pera.png"));


		//Añadimos los menus a la barra de menu
		barraMenu.getMenus().addAll(archivo,opciones,ayuda);

		MenuItem acercade = new MenuItem("Acerca de..");
		MenuItem tutoriales = new MenuItem("Tutoriales");
		MenuItem cargar = new MenuItem("Cargar");



		principal.getChildren().add(barraMenu);
		principal.getChildren().add(pesta);


		//Creacion de splitPane


		Text izquierda = new Text("Izquierda");
		//Para que haya una barra de scroll a la derecha
		//Creamos un ScrollPane y metemos dentro el contenido que
		//Queremos mostrar con barra de scroll
		ScrollPane scroll = new ScrollPane();
		GridPane grid = new GridPane();
		scroll.setContent(grid);

		for (int i = 0; i < 100; i++) {
			grid.add(new Button("Boton " + i), 0, i);

		}

		split.getItems().add(izquierda);
		split.getItems().add(scroll);

		//Creación de Tabpane


		Tab tab1 = new Tab("Pestaña1");
		Tab tab2 = new Tab("Pestaña2");
		Tab tab3 = new Tab("Pestaña3");

		pesta.getTabs().addAll(tab1,tab2,tab3);

		//Añadimos un textArea en la pestaña1 y la ponemos que no se pueda cerrar
		tab1.setClosable(false);
		TextArea texto = new TextArea();
		tab1.setContent(texto);
		tab1.setGraphic(new ImageView("file:pera.png"));

		//Añadimos un  progressbar
		ProgressBar progreso = new ProgressBar();
		progreso.setProgress(0.43);
		tab2.setContent(progreso);

		//En la pestaña 3 añadimos el splitpane
		tab3.setContent(split);





		Scene scene = new Scene(principal,600,400);

		stage.setScene(scene);
		stage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
