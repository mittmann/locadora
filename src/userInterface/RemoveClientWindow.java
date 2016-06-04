package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Client;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RemoveClientWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveClientWindow frame = new RemoveClientWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RemoveClientWindow() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ArrayList<Client> clientes = model.ListsManager.retrieveClients();
		String [] colunas = {"Nome", "Cep", "Cpf", "CNH"};
		String [][] dados = new String[clientes.size()][4];

		for ( int i = 0; i < clientes.size(); i++ ){
					
				dados[i][0] = clientes.get(i).getName();
				dados[i][1] = clientes.get(i).getCep();
				dados[i][2] = clientes.get(i).getCpf();
				dados[i][3] = clientes.get(i).getCnh();
								
		}
		table = new JTable(dados,colunas);
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setLocation(10, 11);
		barraRolagem.setSize(414, 207);
		contentPane.add(barraRolagem);
		barraRolagem.add(table);
		barraRolagem.setViewportView(table);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();
				if (i>-1) {
					try {
						
						model.ClientManager.removeClient(clientes.get(i).getCode());
	
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				dispose();
			}
		});
		btnRemover.setBounds(170, 227, 89, 23);
		contentPane.add(btnRemover);
	}
}
