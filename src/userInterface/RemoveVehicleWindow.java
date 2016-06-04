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

import model.Client;
import model.Vehicle;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class RemoveVehicleWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String placa = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RemoveVehicleWindow dialog = new RemoveVehicleWindow();
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
	
	public RemoveVehicleWindow() throws Exception {
		super(null, ModalityType.APPLICATION_MODAL);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
			String [] colunas = {"Placa", "Modelo", "Marca", "Cor", "Ano", "KM", "Valor", "Filial"};
			String [][] dados = new String[vehicles.size()][8];

			for ( int i = 0; i < vehicles.size(); i++ ){
						
					dados[i][0] = vehicles.get(i).getPlaca();
					dados[i][1] = vehicles.get(i).getModelo();
					dados[i][2] = vehicles.get(i).getMarca();
					dados[i][3] = vehicles.get(i).getCor();
					dados[i][4] = vehicles.get(i).getAno();
					dados[i][5] = vehicles.get(i).getKm();
					dados[i][6] = vehicles.get(i).getValor();
					dados[i][7] = vehicles.get(i).getFilial();					
			}
			table = new JTable(dados,colunas);
			JScrollPane barraRolagem = new JScrollPane(table);
			barraRolagem.setLocation(10, 11);
			barraRolagem.setSize(414, 207);
			contentPanel.add(barraRolagem);
			barraRolagem.add(table);
			barraRolagem.setViewportView(table);
			
			JButton okButton = new JButton("Remover");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i>-1) {
						try {
							System.out.println("TESTEEEEE");

							model.VehicleManager.removeVehicle(dados[i][0]);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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


