package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaymentDebtWindow 
{
	private JFrame frmPaymentDebt;
	private JPanel pnlPaymentDebt;
	private JLabel lblServiceCost;
	private JLabel lblPendingDebt;
	private JLabel lblCurrentDebt;
	private JTextField txtServiceCost;
	private JTextField txtPendingDebt;
	private JTextField txtCurrentDebt;
	private JButton btnAccept;
	private JButton btnCancel;


	public PaymentDebtWindow()
	{
		frmPaymentDebt = new JFrame();
		frmPaymentDebt.setResizable(false);
		frmPaymentDebt.setTitle("Payment Debt");
		frmPaymentDebt.setBounds(100, 100, 532, 300);
		frmPaymentDebt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaymentDebt.getContentPane().setLayout(null);
		
		pnlPaymentDebt = new JPanel();
		pnlPaymentDebt.setBounds(10, 11, 506, 249);
		frmPaymentDebt.getContentPane().add(pnlPaymentDebt);
		pnlPaymentDebt.setLayout(null);
		
		lblServiceCost = new JLabel("Costo de servicio");
		lblServiceCost.setBounds(20, 23, 110, 23);
		pnlPaymentDebt.add(lblServiceCost);
				
		lblPendingDebt = new JLabel("Deuda pendiente");
		lblPendingDebt.setBounds(20, 60, 110, 23);
		pnlPaymentDebt.add(lblPendingDebt);
		
		lblCurrentDebt = new JLabel("Deuda actual");
		lblCurrentDebt.setBounds(20, 101, 110, 23);
		pnlPaymentDebt.add(lblCurrentDebt);
		
		txtServiceCost = new JTextField();
		txtServiceCost.setEditable(false);
		txtServiceCost.setColumns(10);
		txtServiceCost.setBounds(189, 24, 110, 20);
		pnlPaymentDebt.add(txtServiceCost);
		
		txtPendingDebt = new JTextField();
		txtPendingDebt.setEditable(false);
		txtPendingDebt.setColumns(10);
		txtPendingDebt.setBounds(189, 61, 110, 20);
		pnlPaymentDebt.add(txtPendingDebt);
		
		txtCurrentDebt = new JTextField();
		txtCurrentDebt.setEditable(false);
		txtCurrentDebt.setColumns(10);
		txtCurrentDebt.setBounds(189, 102, 110, 20);
		pnlPaymentDebt.add(txtCurrentDebt);
				
		btnAccept = new JButton("Acepar");
		btnAccept.setBounds(96, 178, 89, 23);
		pnlPaymentDebt.add(btnAccept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(279, 178, 99, 23);
		pnlPaymentDebt.add(btnCancel);
		
		frmPaymentDebt.setVisible(false);
	}

	public void mostrarVentana()
	{
		frmPaymentDebt.setVisible(true);
	}
	
	public void cerrar()
	{
		frmPaymentDebt.dispose();
	}

	public JFrame getFrmPaymentDebt() {
		return frmPaymentDebt;
	}

	public JPanel getPnlPaymentDebt() {
		return pnlPaymentDebt;
	}

	public JTextField getTxtServiceCost() {
		return txtServiceCost;
	}

	public JTextField getTxtPendingDebt() {
		return txtPendingDebt;
	}

	public JTextField getTxtCurrentDebt() {
		return txtCurrentDebt;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

}