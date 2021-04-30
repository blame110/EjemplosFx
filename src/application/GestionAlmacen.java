package application;

import Tema3.pctrunk.Categoria;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import Tema3.pctrunk.*;

public class GestionAlmacen extends Application {

	private Almacenes almacen;
	private int posicionAlmacen=0;

	@Override
	public void start(Stage stage) {


		//Cargamos los productos
		almacen = new Almacenes();
		almacen.cargarProductos();



		//Panel principal de la aplicacion
		VBox principal = new VBox();

		MenuBar barra = new MenuBar();
		Menu menuAlmacen = new Menu("Almacén");
		Menu menuAyuda = new Menu("Ayuda");


		MenuItem cargarProductos = new MenuItem("Cargar Productos");
		MenuItem cerrar = new MenuItem("Cerrar");

		MenuItem acercade = new MenuItem("Acerda de..");



		//añadimos los menus al menubar
		barra.getMenus().addAll(menuAlmacen,menuAyuda);


		//Añadimos a los menus los menuitems
		menuAlmacen.getItems().addAll(cargarProductos,cerrar);
		menuAyuda.getItems().add(acercade);


		//Creamos un gripane con los datos de los productos
		GridPane grid = new GridPane();

		Text lblNombre = new Text("Nombre");
		TextField txtNombre = new TextField();
		grid.add(lblNombre, 0, 0);
		grid.add(txtNombre, 1, 0);

		Text lblPrecio = new Text("Precio");
		TextField txtPrecio = new TextField();
		grid.add(lblPrecio, 0, 1);
		grid.add(txtPrecio, 1, 1);

		Text lblDescripcion = new Text("Descripción");
		TextField txtDescripcion = new TextField();
		grid.add(lblDescripcion, 0, 2);
		grid.add(txtDescripcion, 1, 2);

		Text lblCantidad = new Text("Cantidad");
		Slider sldrCantidad = new Slider();

		grid.add(lblCantidad, 0, 3);
		grid.add(sldrCantidad, 1, 3);

		Text lblCategoria = new Text("Categoria");
		TextField txtCategoria = new TextField();
		grid.add(lblCategoria, 0, 4);
		grid.add(txtCategoria, 1, 4);

		Button btnAtras = new Button("Anterior");
		Button btnAdelante = new Button("Siguiente");
		Button btnGuardar = new Button("Guardar");
		grid.add(btnAtras, 0, 5);
		grid.add(btnAdelante, 1, 5);
		grid.add(btnGuardar, 3, 5);

		grid.setVgap(20);
		grid.setHgap(20);

		grid.setPadding(new Insets(50.0,0.0,0.0,80.0));


		//Añadimos los elementos al vbox
		principal.getChildren().add(barra);
		principal.getChildren().add(grid);


		acercade.setOnAction(value ->{

			//Creamos el stage y el scene
			Stage stgAcercade = new Stage();
			VBox vboxAcerca = new VBox();

			Scene scene = new Scene(vboxAcerca, 400.0,400.0);

			//Ponemos un texto y un boton dentro del vbox
			Text info = new Text("Este programa ha sido creado rapidamente\n por el profesor");
			info.setTextAlignment(TextAlignment.CENTER);
			Button acercaCerrar = new Button("Cerrar");
			acercaCerrar.setOnAction(value1 ->{
				stgAcercade.close();
			});

			vboxAcerca.getChildren().addAll(info,acercaCerrar);
			vboxAcerca.setAlignment(Pos.CENTER);

			//Asignamos la scene al stage y lo mostramos
			stgAcercade.setScene(scene);
			stgAcercade.show();
		});

		//Eventos
		//Al pulsar sobre cerrar queremos que se cierre
		cerrar.setOnAction(value -> {

			 	AnchorPane ventanaDos = new AnchorPane();
	            Stage ventana = new Stage();
	            ventana.setTitle("Venta Dos");
	            ventana.initOwner(stage);
	            Scene scene = new Scene(ventanaDos, 600.0,400.0);
	            ventana.setScene(scene);

	            ventana.show();

			//stage.close();
				});

		//Al mover el slider cambia el valor
		sldrCantidad.setOnMouseDragged(value -> {
					lblCantidad.setText("Cantidad " + (int)sldrCantidad.getValue());
				});

		//Cargamos el primer producto del fichero al pulsar sobre esta opcion
		cargarProductos.setOnAction(value -> {
			txtNombre.setText(almacen.productos[0].getNombre());
			txtPrecio.setText(Double.toString(almacen.productos[0].getPrecio()));
			txtDescripcion.setText(almacen.productos[0].getDescripcion());
			sldrCantidad.setValue(almacen.productos[0].getCantidad());
			txtCategoria.setText(Integer.toString(almacen.productos[0].getCategoria().id));
		});


		btnAtras.setOnAction(value -> {

			//Pasamos al siguiente producto si no estamos en el ultimo

			if (posicionAlmacen !=0 )
			posicionAlmacen--;
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Que hacessss!!!");
				alert.setHeaderText(null);
				alert.setContentText("Es el primer producto dale palante");

				alert.showAndWait();

			}

			txtNombre.setText(almacen.productos[posicionAlmacen].getNombre());
			txtPrecio.setText(Double.toString(almacen.productos[posicionAlmacen].getPrecio()));
			txtDescripcion.setText(almacen.productos[posicionAlmacen].getDescripcion());
			sldrCantidad.setValue(almacen.productos[posicionAlmacen].getCantidad());
			txtCategoria.setText(Integer.toString(almacen.productos[posicionAlmacen].getCategoria().id));


		});
		btnAdelante.setOnMouseClicked(value -> {

			//Pasamos al siguiente producto si no estamos en el ultimo

			if (posicionAlmacen < almacen.productos.length -1 )
			posicionAlmacen++;
			else
			{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText(null);
				alert.setContentText("No hay mas productos en el fichero");

				alert.showAndWait();

			}



			txtNombre.setText(almacen.productos[posicionAlmacen].getNombre());
			txtPrecio.setText(Double.toString(almacen.productos[posicionAlmacen].getPrecio()));
			txtDescripcion.setText(almacen.productos[posicionAlmacen].getDescripcion());
			sldrCantidad.setValue(almacen.productos[posicionAlmacen].getCantidad());
			txtCategoria.setText(Integer.toString(almacen.productos[posicionAlmacen].getCategoria().id));
		});

		btnGuardar.setOnAction(value -> {

			//Modificamos el array de productos actualizando la posicion
			almacen.productos[posicionAlmacen].setNombre(txtNombre.getText());
			almacen.productos[posicionAlmacen].setPrecio(Double.valueOf(txtPrecio.getText()));
			almacen.productos[posicionAlmacen].setDescripcion(txtDescripcion.getText());
			almacen.productos[posicionAlmacen].setCantidad((int)sldrCantidad.getValue());
			almacen.productos[posicionAlmacen].setCategoria(new Categoria(Integer.valueOf(txtCategoria.getText()),"Nueva","Nueva"));

			//Salvamos en el fichero el array
			almacen.salvarProductos();

		});


		Scene scene = new Scene(principal, 500,400);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
