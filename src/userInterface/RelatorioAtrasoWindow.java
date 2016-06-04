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

import model.Rental;
import model.Reservation;

public class RelatorioAtrasoWindow extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Reservation reservation = null;
	private JTable table;
	private JButton btnRemover;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioAtrasoWindow frame = new RelatorioAtrasoWindow();
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
	public RelatorioAtrasoWindow() throws Exception {
		Date dateToday = new Date();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		int count = 0;
		ArrayList<Rental> rentals = model.ListsManager.retrieveRentals();
		ArrayList<Rental> delayedRentals = new ArrayList<Rental>();
		
		for (int j=0;j<rentals.size();j++) {
			if (rentals.get(j).getFim().compareTo(dateToday)<0) {
				delayedRentals.add(rentals.get(j));
				count++;
			}
		}

		
		String [][] dados = new String[count][4];
		String [] colunas = {"Cpf do Cliente", "Placa do Veiculo", "Data Inicio", "Data Fim"};

		for ( int i = 0; i < delayedRentals.size(); i++ ){
				dados[i][0] = delayedRentals.get(i).getClient().getCpf();
				dados[i][1] = delayedRentals.get(i).getVehicle().getPlaca();
				dados[i][2] = delayedRentals.get(i).getInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
				dados[i][3] = delayedRentals.get(i).getFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();								
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


