package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import dto.ProfessionalDTO;
import dto.ServiceDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;


public class TakeTurnWindow {
	private JFrame frmTakeTurn;
	private JButton btnAcceptService;
	private JButton btnAcceptProfessional;
	private JButton btnAcceptSchedule;
	private JButton btnTakeTurn;
	private JComboBox<ServiceDTO> services;
	private JComboBox<ProfessionalDTO> professionals;
	private JComboBox<ArrayList<String>> schedules;
	
	public TakeTurnWindow(){
		super();
		initialize();
	}

	private void initialize() 
	{
		frmTakeTurn = new JFrame();
		frmTakeTurn.setTitle("Hair & Head");
		
		frmTakeTurn.setBounds(100, 100, 548, 347);
		frmTakeTurn.setAutoRequestFocus(true);
		frmTakeTurn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, frmTakeTurn.getWidth(), frmTakeTurn.getHeight()-100);
		frmTakeTurn.getContentPane().add(panel);
		panel.setLayout(null);
			
		btnAcceptService = new JButton("Aceptar");
		btnAcceptService.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAcceptService.setBounds(432, 121, 80, 38);
		panel.add(btnAcceptService);
		
		btnAcceptProfessional = new JButton("Aceptar");
		btnAcceptProfessional.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAcceptProfessional.setBounds(432, 59, 80, 38);
		panel.add(btnAcceptProfessional);
		
		btnAcceptSchedule = new JButton("Aceptar");
		btnAcceptSchedule.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAcceptSchedule.setBounds(432, 178, 80, 38);
		panel.add(btnAcceptSchedule);
			
		btnTakeTurn = new JButton("Aceptar");
		btnTakeTurn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnTakeTurn.setBounds(277, 247, 80, 38);
		panel.add(btnTakeTurn);
		
		services = new JComboBox<ServiceDTO>();
		services.setBounds(229, 121, 164, 20);
		panel.add(services);
		
		professionals = new JComboBox<ProfessionalDTO>();
		professionals.setBounds(229, 175, 164, 20);
		panel.add(professionals);
		
		schedules = new JComboBox<ArrayList<String>>();
		schedules.setBounds(229, 68, 164, 20);
		panel.add(schedules);
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
	
	public JComboBox<ServiceDTO> getService() {
		return services;
	}
	
	public JComboBox<ProfessionalDTO> getProfessional() {
		return professionals;
	}
	
	public JComboBox<ArrayList<String>> getSchedule() {
		return schedules;
	}
}
