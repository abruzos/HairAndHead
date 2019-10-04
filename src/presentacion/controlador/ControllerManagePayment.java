package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Customer;
import presentacion.vista.ManagePaymentWindow;

public class ControllerManagePayment implements ActionListener{
	
	private ManagePaymentWindow _viewManagePay;
	private Customer _customer;
	
	public ControllerManagePayment(ManagePaymentWindow view, Customer customer)
	{
		_viewManagePay = view;
		_customer = customer;
		loadCBMwayToPay();
		_viewManagePay.selectPayment().addActionListener(select -> choosePaymentWindow(select));
	}
	
	// Carga el comboBox con las formas de pago.
	/** TENDRIA QUE SER UNA LISTA DE ESTADOS O ESTAR EN BDD */
	private void loadCBMwayToPay() 
	{
		// List<PaymentStatusDTO> PaymentStatus = BranchOffice.getPaymentStatus();
		// for (int status : PaymentStatus) {}
		_viewManagePay.getCmbSelectionPay().addItem("En Efectivo");
		_viewManagePay.getCmbSelectionPay().addItem("Con Puntos");
		_viewManagePay.getCmbSelectionPay().addItem("Con Deuda");	
	}

	// Elige la ventada de pago
	private void choosePaymentWindow(ActionEvent select)
	{
		if(_viewManagePay.getCmbSelectionPay().getSelectedItem().equals("En Efectivo"))
		{
			
		}
		if(_viewManagePay.getCmbSelectionPay().getSelectedItem().equals("Con Puntos"))
		{
				
		}
		if (_viewManagePay.getCmbSelectionPay().getSelectedItem().equals("Con Deuda"))
		{
					
		}
		else
		{
			JOptionPane.showMessageDialog(null,"ADVERTENCIA!! No hay seleccion de ninguna Forma de Pago","Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{	
	}

}
