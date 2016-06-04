package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import data.ClientList;
import model.Client;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SearchClientsWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int result = -1;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchClientsWindow dialog = new SearchClientsWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the dialog.
	 */
	
	int showDialog() {
	    setVisible(true);
	    return result;
	}
	public SearchClientsWindow() throws Exception {
		
		super(null, ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
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
			contentPanel.add(barraRolagem);
			barraRolagem.add(table);
			barraRolagem.setViewportView(table);
			
			
		/*	JList list = new JList(lm);
			for ( int i = 0; i < clientes.size(); i++ ){
				  String namecpf = "Nome: " + clientes.get(i).getName() + ", Código: " + clientes.get(i).getCode();
				  lm.addElement(namecpf);
				}
			list.setBounds(23, 11, 382, 185);
			contentPanel.add(list);*/
		
			JButton btnSelect = new JButton("Select");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i>-1) {
						result = clientes.get(i).getCode();
				        dispose();  // <-- Important
					    }
				}
			});
			btnSelect.setBounds(172, 227, 89, 23);
			contentPanel.add(btnSelect);
		}
	}

}
