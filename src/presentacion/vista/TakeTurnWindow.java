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
	private JButton btnAcceptDay;
	private JComboBox<ServiceDTO> services;
	private JComboBox<ProfessionalDTO> professionals;
	private JComboBox<ArrayList<String>> schedules;
	protected DatePicker calendar;
	
	public TakeTurnWindow(){
		super();
		initialize();
	}

	private void initialize() 
	{
		frmTakeTurn = new JFrame();
		frmTakeTurn.setTitle("Hair & Head");
		
		frmTakeTurn.setBounds(100, 100, 559, 347);
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
		btnAcceptService.setBounds(444, 59, 80, 38);
		panel.add(btnAcceptService);
		
		btnAcceptProfessional = new JButton("Aceptar");
		btnAcceptProfessional.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{			
			}
		});
		btnAcceptProfessional.setBounds(444, 112, 80, 38);
		panel.add(btnAcceptProfessional);
		
		btnAcceptDay = new JButton("Aceptar");
		btnAcceptDay.setBounds(90, 142, 80, 38);
		panel.add(btnAcceptDay);
		
		btnAcceptSchedule = new JButton("Aceptar");
		btnAcceptSchedule.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
			}
		});
		btnAcceptSchedule.setBounds(444, 169, 80, 38);
		panel.add(btnAcceptSchedule);
			
		btnTakeTurn = new JButton("Sacar Turno");
		btnTakeTurn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
			}
		});
		btnTakeTurn.setBounds(291, 229, 114, 38);
		panel.add(btnTakeTurn);
		
		services = new JComboBox<ServiceDTO>();
		services.setBounds(258, 68, 164, 20);
		panel.add(services);
		
		professionals = new JComboBox<ProfessionalDTO>();
		professionals.setBounds(258, 121, 164, 20);
		panel.add(professionals);
		
		schedules = new JComboBox<ArrayList<String>>();
		schedules.setBounds(258, 178, 164, 20);
		panel.add(schedules);
		
		calendar = new DatePicker();
		calendar.getComponentToggleCalendarButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		calendar.setBounds(30, 68, 200, 20);
		calendar.getComponentDateTextField().setEditable(false);
		panel.add(calendar);
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
	
	public JButton getBtnAcceptDay() 
	{
		return btnAcceptDay;
	}
	
	public JButton getBtnAcceptSchedule() 
	{
		return btnAcceptSchedule;
	}
	
	public JButton getBtnTakeTurn() 
	{
		return btnTakeTurn;
	}
	
	public JComboBox<ServiceDTO> getService() 
	{
		return services;
	}
	
	public JComboBox<ProfessionalDTO> getProfessional() 
	{
		return professionals;
	}
	
	public JComboBox<ArrayList<String>> getSchedule()
	{
		return schedules;
	}
	
	public DatePicker getDay() 
	{
		return calendar;
	}
}
