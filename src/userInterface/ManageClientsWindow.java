package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.ClientList;
import model.Clerk;
import model.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManageClientsWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClientsWindow frame = new ManageClientsWindow();
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
	public ManageClientsWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 208, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClientWindow frame = new AddClientWindow();
				frame.setVisible(true);
			}
		});
		btnAdicionarCliente.setBounds(10, 7, 168, 55);
		contentPane.add(btnAdicionarCliente);
		
		JButton btnRemoverCliente = new JButton("Remover Cliente");
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveClientWindow frame = null;
				try {
					frame = new RemoveClientWindow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
			}
		});
		btnRemoverCliente.setBounds(10, 139, 168, 55);
		contentPane.add(btnRemoverCliente);
		
		JButton btnAtualizarCliente = new JButton("Atualizar Cliente");
		btnAtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClientsWindow frame = null;
				try {
					ArrayList<Client> clientes = model.ListsManager.retrieveClients();
					frame = new SearchClientsWindow();
					int result = frame.showDialog();
					for(int i = 0; i < clientes.size(); i++) {
						if (clientes.get(i).getCode() == result) {
							System.out.println(result);
							UpdateClientWindow fr = new UpdateClientWindow(clientes.get(i));
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
		btnAtualizarCliente.setBounds(10, 73, 168, 55);
		contentPane.add(btnAtualizarCliente);
	}

}
