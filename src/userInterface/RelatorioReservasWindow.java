package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Reservation;

public class RelatorioReservasWindow extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Reservation reservation = null;
	private JTable table;
	private JButton btnRemover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioReservasWindow frame = new RelatorioReservasWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public RelatorioReservasWindow() throws Exception {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		ArrayList<Reservation> reservations = model.ListsManager.retrieveReservations();


		String [][] dados = new String[reservations.size()][4];
		String [] colunas = {"Modelo", "Nome do Cliente", "Data Inicio", "Data Fim"};

		for ( int i = 0; i < reservations.size(); i++ ){
					
				dados[i][1] = reservations.get(i).getClient().getName();
				dados[i][0] = reservations.get(i).getVehicle().getModelo();
				dados[i][2] = reservations.get(i).getInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
				dados[i][3] = reservations.get(i).getFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
								
		}
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		table = new JTable(dados,colunas);
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(5, 5, 419, 211);
		contentPanel.add(barraRolagem);
		barraRolagem.add(table);
		barraRolagem.setViewportView(table);
		
		btnRemover = new JButton("Ok");
		btnRemover.setBounds(148, 227, 139, 23);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPanel.add(btnRemover);
	}


}
