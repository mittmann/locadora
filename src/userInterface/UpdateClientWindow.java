package userInterface;

import java.awt.BorderLayout;
import model.ClientManager;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Client;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UpdateClientWindow extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField cepField;
	private JTextField cnhField;
	private JTextField cpfField;
	private JLabel lblNome;
	private JLabel lblCep;
	private JLabel lblCpf;
	private JLabel lblCnh;


	/**
	 * Create the frame.
	 */
	public UpdateClientWindow(Client cliente) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setText(cliente.getName());
		nameField.setBounds(116, 48, 230, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		cepField = new JTextField();
		cepField.setText(cliente.getCep());

		cepField.setBounds(116, 79, 86, 20);
		contentPane.add(cepField);
		cepField.setColumns(10);
		
		cnhField = new JTextField();
		cnhField.setText(cliente.getCnh());
		cnhField.setBounds(116, 141, 86, 20);
		contentPane.add(cnhField);
		cnhField.setColumns(10);
		
		cpfField = new JTextField();
		cpfField.setText(cliente.getCpf());
		cpfField.setBounds(116, 110, 86, 20);
		contentPane.add(cpfField);
		cpfField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.ClientManager.updateClient(cliente.getCode(), nameField.getText(), cpfField.getText(), cnhField.getText(), cepField.getText(),cliente.getCpf(),cliente.getCnh());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnOk.setBounds(101, 184, 131, 42);
		contentPane.add(btnOk);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(33, 51, 46, 14);
		contentPane.add(lblNome);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(33, 82, 46, 14);
		contentPane.add(lblCep);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(33, 113, 46, 14);
		contentPane.add(lblCpf);
		
		lblCnh = new JLabel("CNH");
		lblCnh.setBounds(33, 144, 46, 14);
		contentPane.add(lblCnh);
	}

}
