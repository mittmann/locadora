package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DatePickerWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dateInicio;
	private JTextField dateFim;
	protected Date dataIncio;
	protected Date dataFim;
	Date data[] = {dataIncio,dataFim};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatePickerWindow dialog = new DatePickerWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Date[] showDialog() {
	    setVisible(true);
	    return data;
	}
	public DatePickerWindow() {
		super(null, ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 417, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(59, 41, 103, 16);
		contentPanel.add(lblDataInicio);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data[0]=dataIncio;
				data[1]=dataFim;
				dispose();
			}
		});
		btnOk.setBounds(164, 140, 117, 29);
		contentPanel.add(btnOk);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(59, 84, 61, 16);
		contentPanel.add(lblDataFim);
		
		dateInicio = new JTextField();
		dateInicio.setEditable(false);
		dateInicio.setBounds(151, 36, 130, 26);
		contentPanel.add(dateInicio);
		dateInicio.setColumns(10);
		
		dateFim = new JTextField();
		dateFim.setEditable(false);
		dateFim.setBounds(151, 79, 130, 26);
		contentPanel.add(dateFim);
		dateFim.setColumns(10);
		
		JButton btnK = new JButton("Calendar");
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarWindow frame = new CalendarWindow();
				frame.setVisible(false);
				dataIncio = frame.showDialog();
		    	LocalDate date = dataIncio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		    	dateInicio.setText(date.toString());
				
			}
		});
		btnK.setBounds(273, 36, 88, 29);
		contentPanel.add(btnK);
		
		JButton btnNewButton = new JButton("Calendar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarWindow frame = new CalendarWindow();
				frame.setVisible(false);
		    	dataFim = frame.showDialog();
		    	LocalDate date = dataFim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		    	dateFim.setText(date.toString());
			}
		});
		btnNewButton.setBounds(273, 79, 88, 29);
		contentPanel.add(btnNewButton);
	}
	
	public DatePickerWindow(int today) {
		super(null, ModalityType.APPLICATION_MODAL);
		Date dateToday = new Date();
		setBounds(100, 100, 417, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(59, 41, 103, 16);
		contentPanel.add(lblDataInicio);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataIncio=dateToday;
				data[0]=dataIncio;
				data[1]=dataFim;
				dispose();
			}
		});
		btnOk.setBounds(164, 140, 117, 29);
		contentPanel.add(btnOk);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(59, 84, 61, 16);
		contentPanel.add(lblDataFim);
		
		
		dateInicio = new JTextField();
		dateInicio.setEditable(false);
		dateInicio.setBounds(151, 36, 130, 26);
		contentPanel.add(dateInicio);
		dateInicio.setColumns(10);
		dateInicio.setText(dateToday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
		
		dateFim = new JTextField();
		dateFim.setEditable(false);
		dateFim.setBounds(151, 79, 130, 26);
		contentPanel.add(dateFim);
		dateFim.setColumns(10);
		
		JButton btnNewButton = new JButton("Calendar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarWindow frame = new CalendarWindow();
				frame.setVisible(false);
		    	dataFim = frame.showDialog();
		    	LocalDate date = dataFim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		    	dateFim.setText(date.toString());
			}
		});
		btnNewButton.setBounds(273, 79, 88, 29);
		contentPanel.add(btnNewButton);
	}
}
