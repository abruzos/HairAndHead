package presentacion.vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaymentCashWindow 
{
	private JFrame frmPaymentCash;
	private JPanel pnlPaymentCash;
	private JLabel lblServiceCost;
	private JLabel lblCurrentDebt;
	private JLabel lblDepositedCash;
	private JLabel lblTotalToPay;
	private JTextField txtServiceCost;
	private JTextField txtCurrentDebt;
	private JTextField txtDepositedCash;
	private JTextField txtTotalToPay;
	private JButton btnAccept;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentCashWindow window = new PaymentCashWindow();
					window.frmPaymentCash.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentCashWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmPaymentCash = new JFrame();
		frmPaymentCash.setResizable(false);
		frmPaymentCash.setTitle("Payment Cash");
		frmPaymentCash.setBounds(100, 100, 532, 300);
		frmPaymentCash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaymentCash.getContentPane().setLayout(null);
		
		pnlPaymentCash = new JPanel();
		pnlPaymentCash.setBounds(10, 11, 506, 249);
		frmPaymentCash.getContentPane().add(pnlPaymentCash);
		pnlPaymentCash.setLayout(null);
		
		lblServiceCost = new JLabel("Costo de servicio");
		lblServiceCost.setBounds(20, 23, 110, 23);
		pnlPaymentCash.add(lblServiceCost);
		
		lblCurrentDebt = new JLabel("Deuda actual");
		lblCurrentDebt.setBounds(20, 60, 110, 23);
		pnlPaymentCash.add(lblCurrentDebt);

		lblDepositedCash = new JLabel("Costo depositado");
		lblDepositedCash.setBounds(20, 145, 110, 23);
		pnlPaymentCash.add(lblDepositedCash);
				
		lblTotalToPay = new JLabel("Total a pagar");
		lblTotalToPay.setBounds(21, 109, 89, 25);
		pnlPaymentCash.add(lblTotalToPay);
		
		txtServiceCost = new JTextField();
		txtServiceCost.setColumns(10);
		txtServiceCost.setBounds(189, 24, 110, 20);
		pnlPaymentCash.add(txtServiceCost);
		
		txtCurrentDebt = new JTextField();
		txtCurrentDebt.setColumns(10);
		txtCurrentDebt.setBounds(189, 61, 110, 20);
		pnlPaymentCash.add(txtCurrentDebt);
		
		txtDepositedCash = new JTextField();
		txtDepositedCash.setColumns(10);
		txtDepositedCash.setBounds(189, 146, 110, 20);
		pnlPaymentCash.add(txtDepositedCash);
				
		txtTotalToPay = new JTextField();
		txtTotalToPay.setColumns(10);
		txtTotalToPay.setBounds(189, 105, 110, 20);
		pnlPaymentCash.add(txtTotalToPay);
				
		btnAccept = new JButton("Acepar");
		btnAccept.setBounds(95, 201, 89, 23);
		pnlPaymentCash.add(btnAccept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(280, 201, 99, 23);
		pnlPaymentCash.add(btnCancel);
	}

	public JFrame getFrmPaymentCash() {
		return frmPaymentCash;
	}

	public JPanel getPnlPaymentCash() {
		return pnlPaymentCash;
	}

	public JTextField getTxtServiceCost() {
		return txtServiceCost;
	}

	public JTextField getTxtCurrentDebt() {
		return txtCurrentDebt;
	}

	public JTextField getTxtDepositedCash() {
		return txtDepositedCash;
	}

	public JTextField getTxtTotalToPay() {
		return txtTotalToPay;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

}