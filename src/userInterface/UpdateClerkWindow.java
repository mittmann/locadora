package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Clerk;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateClerkWindow extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField cepField;
	private JTextField cpfField;
	private JTextField usernameField;
	private JTextField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String usertype;


	public UpdateClerkWindow(Clerk clerk) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setText(clerk.getName());
		nameField.setBounds(113, 30, 275, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(57, 33, 46, 14);
		contentPane.add(lblNome);
		
		cepField = new JTextField();
		cepField.setText(clerk.getCep());
		cepField.setBounds(113, 61, 128, 20);
		contentPane.add(cepField);
		cepField.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(67, 67, 28, 14);
		contentPane.add(lblCep);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(65, 98, 28, 14);
		contentPane.add(lblCpf);
		
		cpfField = new JTextField();
		cpfField.setText(clerk.getCpf());
		cpfField.setBounds(113, 92, 128, 20);
		contentPane.add(cpfField);
		cpfField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setText(clerk.getUsername());
		usernameField.setBounds(113, 129, 86, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Usu\u00E1rio");
		lblUsername.setBounds(57, 132, 44, 14);
		contentPane.add(lblUsername);
		
		passwordField = new JTextField();
		passwordField.setText(clerk.getPassword());
		passwordField.setBounds(113, 160, 86, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setBounds(57, 163, 35, 14);
		contentPane.add(lblPassword);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		if (clerk.getUserType().equals("Gerente")) {
			rdbtnGerente.setSelected(true);
		}
		buttonGroup.add(rdbtnGerente);
		rdbtnGerente.setBounds(47, 196, 71, 23);
		contentPane.add(rdbtnGerente);
		
		JRadioButton rdbtnAtendente = new JRadioButton("Atendente");
		if (clerk.getUserType().equals("Atendente")) {
			rdbtnAtendente.setSelected(true);
		}
		buttonGroup.add(rdbtnAtendente);
		rdbtnAtendente.setBounds(164, 196, 77, 23);
		contentPane.add(rdbtnAtendente);
		
		JRadioButton rdbtnCaixa = new JRadioButton("Caixa");
		if (clerk.getUserType().equals("Caixa")) {
			rdbtnCaixa.setSelected(true);
		}
		buttonGroup.add(rdbtnCaixa);
		rdbtnCaixa.setBounds(279, 196, 109, 23);
		contentPane.add(rdbtnCaixa);
		
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rdbtnGerente.isSelected()) {
						usertype = "Gerente";
					}
					else if (rdbtnAtendente.isSelected()){
						usertype = "Atendente";
					}
					else {
						usertype = "Caixa";
					}
					model.ClerkManager.updateClerk(nameField.getText(), cepField.getText(), cpfField.getText(), usertype, usernameField.getText(), passwordField.getText(), clerk.getCpf(), clerk.getUsername());
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnConfirmar.setBounds(152, 226, 89, 23);
		contentPane.add(btnConfirmar);
		
	
		
		
	}

}
