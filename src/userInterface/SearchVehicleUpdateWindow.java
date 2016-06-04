package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import data.VehicleList;
import model.Vehicle;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class SearchVehicleUpdateWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String placa = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchVehicleUpdateWindow dialog = new SearchVehicleUpdateWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String showDialog() {
	    setVisible(true);
	    return placa;
	}
	
	public SearchVehicleUpdateWindow() throws Exception {
		super(null, ModalityType.APPLICATION_MODAL);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
			DefaultListModel lm = new DefaultListModel();
			String [] colunas = {"Placa", "Modelo", "Marca", "Cor", "Ano", "KM", "Valor", "Filial","Locado","Reservado"};
			String [][] dados = new String[vehicles.size()][10];

			for ( int i = 0; i < vehicles.size(); i++ ){
						
					dados[i][0] = vehicles.get(i).getPlaca();
					dados[i][1] = vehicles.get(i).getModelo();
					dados[i][2] = vehicles.get(i).getMarca();
					dados[i][3] = vehicles.get(i).getCor();
					dados[i][4] = vehicles.get(i).getAno();
					dados[i][5] = vehicles.get(i).getKm();
					dados[i][6] = vehicles.get(i).getValor();
					dados[i][7] = vehicles.get(i).getFilial();
					if (vehicles.get(i).getLocado())
						dados[i][8] = "Sim";
					else
						dados[i][8] = "Não";
					if (vehicles.get(i).getReservado())
						dados[i][9] = "Sim";
					else
						dados[i][9] = "Não";
					
			}
			table = new JTable(dados,colunas);
			JScrollPane barraRolagem = new JScrollPane(table);
			barraRolagem.setLocation(10, 11);
			barraRolagem.setSize(414, 207);
			contentPanel.add(barraRolagem);
			barraRolagem.add(table);
			barraRolagem.setViewportView(table);
			
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i>-1) {
						System.out.println(i);
						placa = dados[i][0];
				        dispose();  // <-- Important
					    }
				}
			});
			okButton.setBounds(181, 226, 73, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		
		
			
			table.setBounds(10, 11, 414, 201);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
	}
	
	public SearchVehicleUpdateWindow(String modelo) throws Exception {
		super(null, ModalityType.APPLICATION_MODAL);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
			DefaultListModel lm = new DefaultListModel();
			String [] colunas = {"Placa", "Modelo", "Marca", "Cor", "Ano", "KM", "Valor", "Filial","Locado","Reservado"};
			int count = 0;
			ArrayList<Vehicle> vehicleModel = new ArrayList<Vehicle>();
			if (vehicleModel.isEmpty())
				System.out.println("TA VAZIO");

			for ( int j = 0; j < vehicles.size(); j++ ){
				if (vehicles.get(j).getModelo().equals(modelo)) {
					count++;
					System.out.println("achei");
					vehicleModel.add(vehicles.get(j));
				}
			}
			String [][] dados = new String[count][10];

			for ( int i = 0; i < count; i++ ){
					dados[i][0] = vehicleModel.get(i).getPlaca();
					dados[i][1] = vehicleModel.get(i).getModelo();
					dados[i][2] = vehicleModel.get(i).getMarca();
					dados[i][3] = vehicleModel.get(i).getCor();
					dados[i][4] = vehicleModel.get(i).getAno();
					dados[i][5] = vehicleModel.get(i).getKm();
					dados[i][6] = vehicleModel.get(i).getValor();
					dados[i][7] = vehicleModel.get(i).getFilial();
					if (vehicleModel.get(i).getLocado())
						dados[i][8] = "Sim";
					else
						dados[i][8] = "Não";
					if (vehicleModel.get(i).getReservado())
						dados[i][9] = "Sim";
					else
						dados[i][9] = "Não";
					
					
			}
			table = new JTable(dados,colunas);
			JScrollPane barraRolagem = new JScrollPane(table);
			barraRolagem.setLocation(10, 11);
			barraRolagem.setSize(414, 207);
			contentPanel.add(barraRolagem);
			barraRolagem.add(table);
			barraRolagem.setViewportView(table);
			
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i>-1) {
						System.out.println(i);
						placa = dados[i][0];
				        dispose();  // <-- Important
					    }
				}
			});
			okButton.setBounds(181, 226, 73, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		
		
			
			table.setBounds(10, 11, 414, 201);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
	}
}
