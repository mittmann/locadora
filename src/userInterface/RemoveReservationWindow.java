package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Client;
import model.Reservation;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveReservationWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnRemover;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveReservationWindow frame = new RemoveReservationWindow();
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
	public RemoveReservationWindow() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ArrayList<Reservation> reservations = model.ListsManager.retrieveReservations();
		String [] colunas = {"Cpf do Cliente", "Placa do Veiculo", "Data Inicio", "Data Fim"};
		String [][] dados = new String[reservations.size()][4];

		for ( int i = 0; i < reservations.size(); i++ ){
					
				dados[i][0] = reservations.get(i).getClient().getCpf();
				dados[i][1] = reservations.get(i).getVehicle().getPlaca();
				dados[i][2] = reservations.get(i).getInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
				dados[i][3] = reservations.get(i).getFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
								
		}
		contentPane.setLayout(null);
		table = new JTable(dados,colunas);
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setLocation(5, 5);
		barraRolagem.setSize(440, 261);
		contentPane.add(barraRolagem);
		barraRolagem.add(table);
		barraRolagem.setViewportView(table);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>-1) {
					try {
						model.ReservationManager.removeReservation(reservations.get(i).getCode());
	
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				dispose();
			}
		});
		btnRemover.setBounds(165, 278, 117, 29);
		contentPane.add(btnRemover);
	}

}
