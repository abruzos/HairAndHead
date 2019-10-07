package presentacion.vista;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

// VENTANA DE GESTION DE PAGO.
public class ManagePaymentWindow
{

	// INSTANACIAS....
	private JFrame _frame;
	private JTextField _textName;
	private JTextField _textSurname;
	private JTextField _textMail;
	private JTextField _textAge;
	private JTextField _textNumbrePhone;
	private JTextField _textState;
	private JTextField _textServiceCost;
	private JTextField _textAcculatePoints;
	private JTextField _textPesosValue;
	private JTextField _textCurrentDebt;
	private JComboBox<String> _cmbPaymentType;
	private JButton _btnSelecPayment;
	private JButton _btnReport;
	
	
	// CONSTRUCTOR
	public ManagePaymentWindow() 
	{
		_frame = new JFrame();
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_frame.setSize( 375, 510);
		_frame.setTitle("Gestionar Pago");
		_frame.setLocationRelativeTo(null);
		_frame.getContentPane().setLayout(null);
		
		JLabel lblInformationClient = new JLabel("Datos del Usuario");
		lblInformationClient.setBounds(122, 11, 95, 14);
		_frame.getContentPane().add(lblInformationClient);
		
		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(22, 48, 46, 14);
		_frame.getContentPane().add(lblName);
			
		JLabel lblSurname = new JLabel("Apellido:");
		lblSurname.setBounds(166, 48, 51, 14);
		_frame.getContentPane().add(lblSurname);
		
		JLabel labelAge = new JLabel("Edad:");
		labelAge.setBounds(22, 84, 46, 14);
		_frame.getContentPane().add(labelAge);
		
		JLabel labelMail = new JLabel("E-mail:");
		labelMail.setBounds(166, 84, 46, 14);
		_frame.getContentPane().add(labelMail);
		
		JLabel labelPhone = new JLabel("Telefono:");
		labelPhone.setBounds(22, 120, 46, 14);
		_frame.getContentPane().add(labelPhone);
		
		JLabel labelState = new JLabel("Estado:");
		labelState.setBounds(166, 120, 95, 14);
		_frame.getContentPane().add(labelState);
		
		JLabel lblPaymentMethod= new JLabel("Formas de pago:");
		lblPaymentMethod.setBounds(147, 338, 95, 14);
		_frame.getContentPane().add(lblPaymentMethod);
		
		JLabel lblCostService = new JLabel("Costo del Servicio:");
		lblCostService.setBounds(10, 207, 101, 14);
		_frame.getContentPane().add(lblCostService);
		
		JLabel lblAcculatePoints = new JLabel("Puntos Acumulados:");
		lblAcculatePoints.setBounds(10, 248, 101, 14);
		_frame.getContentPane().add(lblAcculatePoints);
		
		JLabel lblValue = new JLabel("Valor en $:");
		lblValue.setBounds(196, 248, 58, 14);
		_frame.getContentPane().add(lblValue);
		
		JLabel lblCurrentDebt = new JLabel("Deuda actual:");
		lblCurrentDebt.setBounds(10, 290, 95, 14);
		_frame.getContentPane().add(lblCurrentDebt);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 152, 287, 2);
		_frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setToolTipText("Forma de Pagos");
		separator_1.setBounds(42, 324, 287, 2);
		_frame.getContentPane().add(separator_1);
		
		JLabel lblInformationService = new JLabel("Informacion de Servicio");
		lblInformationService.setBounds(122, 165, 120, 14);
		_frame.getContentPane().add(lblInformationService);
		
		_textName = new JTextField();
		_textName.setEditable(false);
		_textName.setColumns(10);
		_textName.setBounds(78, 45, 78, 20);
		_frame.getContentPane().add(_textName);
		
		_textSurname = new JTextField();
		_textSurname.setEditable(false);
		_textSurname.setColumns(10);
		_textSurname.setBounds(219, 45, 130, 20);
		_frame.getContentPane().add(_textSurname);
		
		_textMail = new JTextField();
		_textMail.setEditable(false);
		_textMail.setColumns(10);
		_textMail.setBounds(219, 81, 130, 20);
		_frame.getContentPane().add(_textMail);
		
		_textAge = new JTextField();
		_textAge.setEditable(false);
		_textAge.setColumns(10);
		_textAge.setBounds(78, 81, 78, 20);
		_frame.getContentPane().add(_textAge);
		
		_textNumbrePhone = new JTextField();
		_textNumbrePhone.setEditable(false);
		_textNumbrePhone.setColumns(10);
		_textNumbrePhone.setBounds(78, 114, 78, 20);
		_frame.getContentPane().add(_textNumbrePhone);
		
		_textState = new JTextField();
		_textState.setEditable(false);
		_textState.setColumns(10);
		_textState.setBounds(219, 114, 130, 20);
		_frame.getContentPane().add(_textState);
		
		_textServiceCost = new JTextField();
		_textServiceCost.setEditable(false);
		_textServiceCost.setColumns(10);
		_textServiceCost.setBounds(122, 204, 58, 20);
		_frame.getContentPane().add(_textServiceCost);
		
		_textAcculatePoints = new JTextField();
		_textAcculatePoints.setEditable(false);
		_textAcculatePoints.setColumns(10);
		_textAcculatePoints.setBounds(122, 245, 58, 20);
		_frame.getContentPane().add(_textAcculatePoints);
		
		_textPesosValue = new JTextField();
		_textPesosValue.setEditable(false);
		_textPesosValue.setColumns(10);
		_textPesosValue.setBounds(261, 245, 58, 20);
		_frame.getContentPane().add(_textPesosValue);
		
		_textCurrentDebt = new JTextField();
		_textCurrentDebt.setEditable(false);
		_textCurrentDebt.setColumns(10);
		_textCurrentDebt.setBounds(122, 287, 58, 20);
		_frame.getContentPane().add(_textCurrentDebt);
		
		_cmbPaymentType = new JComboBox<String>();
		_cmbPaymentType.setBounds(133, 376, 164, 20);
		_frame.getContentPane().add(_cmbPaymentType);
	
		_btnSelecPayment = new JButton("Selecionar");
		_btnSelecPayment.setBounds(10, 375, 95, 23);
		_frame.getContentPane().add(_btnSelecPayment);
		
		_btnReport = new JButton("Reportes");
		_btnReport.setBounds(122, 437, 95, 23);
		_frame.getContentPane().add(_btnReport);
		
		_frame.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		_frame.setVisible(true);
	}
	
	public void cerrar()
	{
		_frame.dispose();
	}

	public JFrame getFrame() {
		return _frame;
	}

	public void setFrame(JFrame frame) {
		this._frame = frame;
	}
	
	// METODOS 
	
	// ComboBox PARA ELEGIR EL PAGO 
	public JComboBox<String> getCmbSelectionPay()
	{
		return _cmbPaymentType;
	}
	
	// BOTON QUE SELECCIONA EL PAGO
	public JButton selectPayment()
	{
		return _btnSelecPayment;
	}
	
	// BOTON QUE SELECCIONA EL REPORTE 
	public JButton getBtnReport() 
	{
		return _btnReport;
	}
	
	// RETORNA EL JTextField DONDE ESTA EL NOMBRE DE USUARIO
	public JTextField getTextName()
	{
		return _textName; 
	}

	public JTextField getTextSurname()
	{
		return _textSurname;
	}

	public JTextField getTextAge()
	{
		return _textAge; 
	}

	public JTextField getTextMail()
	{
		return _textMail; 
	}

	public JTextField getTextNumberPhone()
	{
		return _textNumbrePhone;
	}
	
	public JTextField getTextState()
	{
		return _textState; 
	}
	
	public JTextField getTextServiceCost()
	{
		return _textServiceCost;
	}

	public JTextField getTextAcculatePoints()
	{
		return _textAcculatePoints; 
	}

	public JTextField getTextPesosValue()
	{
		return _textPesosValue;
	}
	
	public JTextField getTextCurrentDebt()
	{
		return _textCurrentDebt; 
	}
}
