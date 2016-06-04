package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Vehicle;

public class RelatorioVeiculoWindow extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String placa = null;
	/**

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioVeiculoWindow frame = new RelatorioVeiculoWindow();
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
	public RelatorioVeiculoWindow() throws Exception {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
			String [] colunas = {"Placa","Modelo","Filial"};
			String [][] dados = new String[vehicles.size()][3];

			for ( int i = 0; i < vehicles.size(); i++ ){
						
					dados[i][0] = vehicles.get(i).getPlaca();
					dados[i][1] = vehicles.get(i).getModelo();
					dados[i][2] = vehicles.get(i).getFilial();
					
					
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
				    dispose();  // <-- Important
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