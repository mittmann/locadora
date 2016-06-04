package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddClerkWindow extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField cepField;
	private JTextField cpfField;
	private JTextField usernameField;
	private JTextField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String usertype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClerkWindow frame = new AddClerkWindow();
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
	public AddClerkWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(113, 30, 252, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(62, 33, 41, 14);
		contentPane.add(lblNome);
		
		cepField = new JTextField();
		cepField.setBounds(113, 61, 128, 20);
		contentPane.add(cepField);
		cepField.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(72, 64, 28, 14);
		contentPane.add(lblCep);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(75, 95, 28, 14);
		contentPane.add(lblCpf);
		
		cpfField = new JTextField();
		cpfField.setBounds(113, 92, 128, 20);
		contentPane.add(cpfField);
		cpfField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setBounds(113, 129, 128, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Usu\u00E1rio");
		lblUsername.setBounds(47, 132, 56, 14);
		contentPane.add(lblUsername);
		
		passwordField = new JTextField();
		passwordField.setBounds(113, 160, 128, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setBounds(58, 163, 45, 14);
		contentPane.add(lblPassword);
		
		JRadioButton rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setSelected(true);
		buttonGroup.add(rdbtnGerente);
		rdbtnGerente.setBounds(47, 196, 97, 23);
		contentPane.add(rdbtnGerente);
		
		JRadioButton rdbtnAtendente = new JRadioButton("Atendente");
		buttonGroup.add(rdbtnAtendente);
		rdbtnAtendente.setBounds(144, 196, 97, 23);
		contentPane.add(rdbtnAtendente);
		
		JRadioButton rdbtnCaixa = new JRadioButton("Caixa");
		buttonGroup.add(rdbtnCaixa);
		rdbtnCaixa.setBounds(253, 196, 109, 23);
		contentPane.add(rdbtnCaixa);
		

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rdbtnGerente.isSelected()) {
						usertype = "Gerente";
					}
					if (rdbtnAtendente.isSelected()){
						usertype = "Atendente";
					}
					if (rdbtnCaixa.isSelected())
					{
						usertype = "Caixa";
					}
					
					model.ClerkManager.addClerk(nameField.getText(), cepField.getText(), cpfField.getText(),usertype, usernameField.getText(), passwordField.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnAdicionar.setBounds(153, 226, 109, 35);
		contentPane.add(btnAdicionar);
	}
}
