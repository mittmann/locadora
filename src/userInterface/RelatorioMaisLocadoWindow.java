package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Rental;
import model.RentedModel;
import model.Reservation;
import model.Vehicle;

public class RelatorioMaisLocadoWindow extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Reservation reservation = null;
	private JTable table;
	private JButton btnRemover;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioMaisLocadoWindow frame = new RelatorioMaisLocadoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RelatorioMaisLocadoWindow() throws Exception {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		
		ArrayList<Rental> finishedRentals = model.ListsManager.retrieveFinishedRentals();
		ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
		ArrayList<RentedModel> rented = new ArrayList<RentedModel>();
		ArrayList<String> models = new ArrayList<String>();
		
		System.out.println(finishedRentals.size());
		for (int i=0;i<finishedRentals.size();i++) {
			if (!models.contains(finishedRentals.get(i).getVehicle().getModelo())) {
				models.add(finishedRentals.get(i).getVehicle().getModelo());
			}
		}
		
		for (int i=0;i<models.size();i++) {
			RentedModel r = new RentedModel();
			r.setModel(models.get(i));
			rented.add(r);
		}
		
		for (int j=0;j<rented.size();j++) {
			for (int i=0;i<finishedRentals.size();i++) {
				if(rented.get(j).getModel().equals(finishedRentals.get(i).getVehicle().getModelo())) {
					rented.get(j).setRentCount(rented.get(j).getRentCount()+1);
				}
			}
		}
		
		for (int j=0;j<rented.size();j++) {
			for (int i=0;i<vehicles.size();i++) {
				if(rented.get(j).getModel().equals(vehicles.get(i).getModelo())) {
					rented.get(j).setAmount(rented.get(j).getAmount()+1);
				}
			}
		}
		
		
		String [] colunas = {"Modelo","Vezes Locado","Quantidade no Sistema"};
		String [][] dados = new String[rented.size()][3];

		for ( int i = 0; i < rented.size(); i++ ){
					
				dados[i][0] = rented.get(i).getModel();
				dados[i][1] = String.valueOf(rented.get(i).getRentCount());
				dados[i][2] = String.valueOf(rented.get(i).getAmount());
				
				
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
	



