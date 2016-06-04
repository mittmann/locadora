package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import data.ClerkList;
import data.ClientList;
import model.Clerk;

public class SearchClerkWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String result = null;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchClerkWindow dialog = new SearchClerkWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String showDialog() {
	    setVisible(true);
	    return result;
	}
	
	public SearchClerkWindow() throws Exception {
		super(null, ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<Clerk> staff = model.ListsManager.retrieveStaff();
			
			String [] colunas = {"Nome", "Cep", "Cpf", "Tipo"};
			String [][] dados = new String[staff.size()][4];

			for ( int i = 0; i < staff.size(); i++ ){
						
					dados[i][0] = staff.get(i).getName();
					dados[i][1] = staff.get(i).getCep();
					dados[i][2] = staff.get(i).getCpf();
					dados[i][3] = staff.get(i).getUserType();
			}
			table = new JTable(dados,colunas);
			JScrollPane barraRolagem = new JScrollPane(table);
			barraRolagem.setLocation(10, 11);
			barraRolagem.setSize(414, 207);
			contentPanel.add(barraRolagem);
			barraRolagem.add(table);
			barraRolagem.setViewportView(table);
			
		
			JButton btnSelect = new JButton("Select");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i>-1) {
						result = staff.get(i).getCpf();
				        dispose();  // <-- Important
					    }
				}
			});
			btnSelect.setBounds(172, 227, 89, 23);
			contentPanel.add(btnSelect);
		}
	}

}
