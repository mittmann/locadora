package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Client;
import model.Reservation;
import model.Vehicle;

public class SearchReservationWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Reservation reservation = null;
	private JTable table;
	private JButton btnRemover;
	

	public SearchReservationWindow(Client client) throws Exception {
		super(null, ModalityType.APPLICATION_MODAL);
		Date dateToday = new Date();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		ArrayList<Reservation> reservations = model.ListsManager.retrieveReservations();
		int count = 0;
		ArrayList<Reservation> reservationsClient = new ArrayList<Reservation>();


		for ( int j = 0; j < reservations.size(); j++ ){
			if (reservations.get(j).getClient().getCpf().equals(client.getCpf())) {
				count++;
				reservationsClient.add(reservations.get(j));
			}
		}
		String [][] dados = new String[count][4];
		String [] colunas = {"Cpf do Cliente", "Placa do Veiculo", "Data Inicio", "Data Fim"};

		for ( int i = 0; i < reservationsClient.size(); i++ ){
					
				dados[i][0] = reservationsClient.get(i).getClient().getCpf();
				dados[i][1] = reservationsClient.get(i).getVehicle().getPlaca();
				dados[i][2] = reservationsClient.get(i).getInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
				dados[i][3] = reservationsClient.get(i).getFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
								
		}
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);
		table = new JTable(dados,colunas);
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(5, 5, 419, 211);
		contentPanel.add(barraRolagem);
		barraRolagem.add(table);
		barraRolagem.setViewportView(table);
		
		btnRemover = new JButton("Locar");
		btnRemover.setBounds(148, 227, 139, 23);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i>-1) {
					try {
						if (dateToday.compareTo(reservationsClient.get(i).getInicio()) >= 0 && dateToday.compareTo(reservationsClient.get(i).getFim()) < 0) {
							System.out.println("criou o bagulho");
							model.RentalManager.addRental(dateToday, reservationsClient.get(i).getFim(), reservationsClient.get(i).getClient(), reservationsClient.get(i).getVehicle());
							model.ReservationManager.removeReservation(reservationsClient.get(i).getCode());
						}
						else {
							System.out.println(" n criou o bagulho");

						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				dispose();
			}
		});
		contentPanel.add(btnRemover);
	}

}
