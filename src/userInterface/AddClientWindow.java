package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddClientWindow extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextfield;
	private JTextField cepTextField;
	private JTextField cpfTextField;
	private JTextField cnhTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClientWindow frame = new AddClientWindow();
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
	public AddClientWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 261, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(34, 28, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(34, 53, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(34, 81, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblCnh = new JLabel("CNH");
		lblCnh.setBounds(34, 106, 46, 14);
		contentPane.add(lblCnh);
		
		nameTextfield = new JTextField();
		nameTextfield.setBounds(73, 25, 129, 20);
		contentPane.add(nameTextfield);
		nameTextfield.setColumns(10);
		
		cepTextField = new JTextField();
		cepTextField.setBounds(73, 50, 129, 20);
		contentPane.add(cepTextField);
		cepTextField.setColumns(10);
		
		cpfTextField = new JTextField();
		cpfTextField.setBounds(73, 78, 129, 20);
		contentPane.add(cpfTextField);
		cpfTextField.setColumns(10);
		
		cnhTextField = new JTextField();
		cnhTextField.setBounds(73, 103, 129, 20);
		contentPane.add(cnhTextField);
		cnhTextField.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.ClientManager.addClient(nameTextfield.getText(), cepTextField.getText(), cpfTextField.getText(), cnhTextField.getText());
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnConfirmar.setBounds(73, 153, 129, 51);
		contentPane.add(btnConfirmar);
	}

}
