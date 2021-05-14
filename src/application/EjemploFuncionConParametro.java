package application;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EjemploFuncionConParametro extends Application {

	private static final int BOTON_1 = 1;
	private static final int BOTON_2 = 2;

	@Override
	public void start(Stage primaryStage) {

		Button boton1 = new Button("Boton1");
		Button boton2 = new Button("Boton2");

		boton1.setOnAction(value ->{
			crearVentana(this.BOTON_1);
		});

		boton2.setOnAction(value ->{
			crearVentana(this.BOTON_2);
		});


	}


	void crearVentana(int botonPulsado)
	{
		//Crear stage, crear scene, crear gridpane

		if (botonPulsado == this.BOTON_1 )
		{
			//Hacer lo que tiene que hacer si pulsa el 1
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
