package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class VentanaFXMLController {


	@FXML
	private Button boton;
	@FXML
	private Button botom2;

	@FXML
	public void CambioColorClick(ActionEvent event)
	{
		boton.setTextFill(Color.AQUA);
		botom2.setTextFill(Color.BLUE);
	}

	@FXML
	public void botonPulsado(ActionEvent event)
	{
		if (boton!=null)
		boton.setText("No tan fuerte!!");
	}


	public void initialize(URL url, ResourceBundle resources) {
        // Initialization code can go here.
        // The parameters url and resources can be omitted if they are not needed
    }

}
