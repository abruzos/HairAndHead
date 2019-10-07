package presentacion.vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaymentPointsWindow 
{
	private JFrame frmPaymentPoints;
	private JPanel pnlPaymentPoints;
	private JLabel lblServiceCost;
	private JLabel lblPointsUsed;
	private JTextField txtServiceCost;
	private JTextField txtPointsUsed;
	private JButton btnAccept;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPointsWindow window = new PaymentPointsWindow();
					window.frmPaymentPoints.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentPointsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmPaymentPoints = new JFrame();
		frmPaymentPoints.setResizable(false);
		frmPaymentPoints.setTitle("Payment points");
		frmPaymentPoints.setBounds(100, 100, 532, 300);
		frmPaymentPoints.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaymentPoints.getContentPane().setLayout(null);
		
		pnlPaymentPoints = new JPanel();
		pnlPaymentPoints.setBounds(10, 11, 506, 249);
		frmPaymentPoints.getContentPane().add(pnlPaymentPoints);
		pnlPaymentPoints.setLayout(null);
		
		lblServiceCost = new JLabel("Costo de servicio");
		lblServiceCost.setBounds(20, 23, 110, 23);
		pnlPaymentPoints.add(lblServiceCost);
		
		txtServiceCost = new JTextField();
		txtServiceCost.setColumns(10);
		txtServiceCost.setBounds(189, 24, 110, 20);
		pnlPaymentPoints.add(txtServiceCost);
		
		lblPointsUsed = new JLabel("Puntos utilizados");
		lblPointsUsed.setBounds(20, 60, 110, 23);
		pnlPaymentPoints.add(lblPointsUsed);
		
		txtPointsUsed = new JTextField();
		txtPointsUsed.setColumns(10);
		txtPointsUsed.setBounds(189, 61, 110, 20);
		pnlPaymentPoints.add(txtPointsUsed);
		
		btnAccept = new JButton("Acepar");
		btnAccept.setBounds(96, 178, 89, 23);
		pnlPaymentPoints.add(btnAccept);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(279, 178, 99, 23);
		pnlPaymentPoints.add(btnCancel);
	}
	
	public JFrame getFrmPaymentPoints() {
		return frmPaymentPoints;
	}

	public JPanel getPnlPaymentPoints() {
		return pnlPaymentPoints;
	}

	public JTextField getTxtServiceCost() {
		return txtServiceCost;
	}

	public JTextField getTxtPointsUsed() {
		return txtPointsUsed;
	}

	public JButton getBtnAccept() {
		return btnAccept;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

}