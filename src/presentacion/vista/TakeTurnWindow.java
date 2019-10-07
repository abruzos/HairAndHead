package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TakeTurnWindow {
	private JFrame frmTakeTurn;
	private JButton btnAcceptService;
	private JButton btnAcceptProfessional;
	private JButton btnAcceptSchedule;
	private JButton btnTakeTurn;

	public TakeTurnWindow(){
		super();
		initialize();
	}

	private void initialize() 
	{
		frmTakeTurn = new JFrame();
		frmTakeTurn.setTitle("Hair & Head");
		
		frmTakeTurn.setBounds(100, 100, 1110, 446);
		frmTakeTurn.setAutoRequestFocus(true);
		frmTakeTurn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, frmTakeTurn.getWidth(), frmTakeTurn.getHeight()-100);
		frmTakeTurn.getContentPane().add(panel);
		panel.setLayout(null);
			
		btnAcceptService = new JButton("Aceptar");
		btnAcceptService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcceptService.setBounds(944, 112, 80, 38);
		panel.add(btnAcceptService);
		
		btnAcceptProfessional = new JButton("Aceptar");
		btnAcceptProfessional.setBounds(944, 41, 80, 38);
		panel.add(btnAcceptProfessional);
		
		btnAcceptSchedule = new JButton("Aceptar");
		btnAcceptSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcceptSchedule.setBounds(944, 184, 80, 38);
		panel.add(btnAcceptSchedule);
			
		btnTakeTurn = new JButton("Aceptar");
		btnTakeTurn.setBounds(944, 311, 80, 38);
		panel.add(btnTakeTurn);

	}
	
	public void show() 
	{
		this.frmTakeTurn.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frmTakeTurn.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) 
			{
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Desea salir?", 
		             "Confirmacion", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) 
		        {
		           System.exit(0);
		        }
		    }
		});
		this.frmTakeTurn.setVisible(true);
	}
	
	public JButton getBtnAcceptService() 
	{
		return btnAcceptService;
	}

	public JButton getBtnAcceptProfessional() 
	{
		return btnAcceptProfessional;
	}
	
	public JButton getBtnAcceptSchedule() 
	{
		return btnAcceptSchedule;
	}
	
	public JButton getBtnTakeTurn() 
	{
		return btnTakeTurn;
	}
}
