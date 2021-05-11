package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class Ejemplo2Controller {

@FXML
Button boton;

@FXML
Label texto;

@FXML
public void botonPulsado(ActionEvent event)
{
	texto.setText("Me has pulsado demasiado Fuerte");
}

}
