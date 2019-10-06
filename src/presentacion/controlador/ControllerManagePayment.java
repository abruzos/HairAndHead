package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import dto.CustomerDTO;
import presentacion.vista.ManagePaymentWindow;
import presentacion.vista.PaymentCashWindow;
import presentacion.vista.PaymentDebtWindow;
import presentacion.vista.PaymentPointsWindow;


public class ControllerManagePayment implements ActionListener{
	
	private ManagePaymentWindow _viewManagePay;
	private CustomerDTO _customer;
	
	public ControllerManagePayment(ManagePaymentWindow view, CustomerDTO customer)
	{
		_viewManagePay = view;
		_customer = customer;		
		loadInformationClient();
		loadInformationService();
		loadCBMwayToPay();	
		_viewManagePay.selectPayment().addActionListener(select -> choosePaymentWindow(select));
		_viewManagePay.getBtnReport().addActionListener(report -> showReport(report));
	}

	private void loadInformationClient() {
		_viewManagePay.getTextName().setText(_customer.getName());
		_viewManagePay.getTextSurname().setText(_customer.getSurname());
		_viewManagePay.getTextAge().setText(_customer.getAge());
		_viewManagePay.getTextMail().setText(_customer.getMail());
		_viewManagePay.getTextNumberPhone().setText(_customer.getNumberPhone());
		_viewManagePay.getTextState().setText(_customer.getState());
	}
	
	private void loadInformationService() {
		_viewManagePay.getTextServiceCost().setText("funcion CostService");
		_viewManagePay.getTextAcculatePoints().setText("funcion Accumulated points");
		_viewManagePay.getTextPesosValue().setText("funcion Accumulated points");
		_viewManagePay.getTextCurrentDebt().setText("funcion current debt");
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
			PaymentCashWindow view = new PaymentCashWindow();
			@SuppressWarnings("unused")
			ControllerPaymentCash controller = new ControllerPaymentCash(view);
		}
		if(_viewManagePay.getCmbSelectionPay().getSelectedItem().equals("Con Puntos"))
		{
			PaymentPointsWindow view = new PaymentPointsWindow();
			@SuppressWarnings("unused")
			ControllerPaymentPoints controller = new ControllerPaymentPoints(view);
		}
		if (_viewManagePay.getCmbSelectionPay().getSelectedItem().equals("Con Deuda"))
		{
			PaymentDebtWindow view = new PaymentDebtWindow();
			@SuppressWarnings("unused")
			ControllerPaymentDebt controller = new ControllerPaymentDebt(view);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"ADVERTENCIA!! No hay seleccion de ninguna Forma de Pago","Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	// Para realizar un reporte Global de pagos. 
	/** DECIDIR SI IMPLEMENTAR */
	private void showReport(ActionEvent report)
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{	
	}

}
