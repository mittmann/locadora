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

import model.Clerk;


public class RemoveClerkWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveClerkWindow frame = new RemoveClerkWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RemoveClerkWindow() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ArrayList<Clerk> staff = model.ListsManager.retrieveStaff();
		String [] colunas = {"Nome", "Cep", "Cpf", "Usertype"};
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
		contentPane.add(barraRolagem);
		barraRolagem.add(table);
		barraRolagem.setViewportView(table);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();
				if (i>-1) {
					try {
						
						model.ClerkManager.removeClerk(staff.get(i).getCpf());
	
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
