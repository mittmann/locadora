package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Clerk;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManageStaffWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStaffWindow frame = new ManageStaffWindow();
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
	public ManageStaffWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 202, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionario");
		btnAdicionarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClerkWindow frame = new AddClerkWindow();
				frame.setVisible(true);
			}
		});
		btnAdicionarFuncionario.setBounds(10, 11, 165, 54);
		contentPane.add(btnAdicionarFuncionario);
		
		JButton btnRemoverFuncionario = new JButton("Remover Funcionario");
		btnRemoverFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveClerkWindow frame;
				try {
					frame = new RemoveClerkWindow();
					frame.setVisible(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemoverFuncionario.setBounds(10, 141, 165, 54);
		contentPane.add(btnRemoverFuncionario);
		
		JButton btnAtualizarFuncionario = new JButton("Atualizar Funcionario");
		btnAtualizarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClerkWindow frame = null;
				try {
					ArrayList<Clerk> staff = model.ListsManager.retrieveStaff();
					frame = new SearchClerkWindow();
					String result = frame.showDialog();
					for(int i = 0; i < staff.size(); i++) {
						if (staff.get(i).getCpf() == result) {
							System.out.println(result);
							UpdateClerkWindow fr = new UpdateClerkWindow(staff.get(i));
							fr.setVisible(true);
						}
					
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnAtualizarFuncionario.setBounds(10, 76, 165, 54);
		contentPane.add(btnAtualizarFuncionario);
	}

}
