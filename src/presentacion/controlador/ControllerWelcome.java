package presentacion.controlador;

import javafx.scene.control.Button;

public class ControllerWelcome {
	
	Button comprobante;
	Button pago;
	Button turno;

	public void viewPayment() {
		System.out.println("pago");
	}
	
	public void viewTurn() {
		System.out.println("turno");
	}

	public void viewComprobante() {
		System.out.println("comprobante");
	}
}
