package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MainWindow {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public MainWindow() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 331, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (model.ClerkManager.checkEmpty()) {
			model.ClerkManager.addClerk("admin", "admin", "admin", "Gerente", "admin", "admin");
			
		}
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String login = model.Login.checkUsernameAndPassword(usernameField.getText(),passwordField.getText());
					if (login.equals("Gerente")) {
						
						GerenteWindow frame = new GerenteWindow();
						frame.setVisible(true);
					}
					if (login.equals("Atendente")) {
						AtendenteWindow frame = new AtendenteWindow();
						frame.setVisible(true);
					}
					if (login.equals("Caixa")) {
						CaixaWindow frame = new CaixaWindow();
						frame.setVisible(true);
					}
					if (login.equals("Error")) {
						JOptionPane.showMessageDialog(frame, "Usuario ou senha incorretos");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
			}
		});
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		passwordField = new JTextField();
		passwordField.setColumns(10);
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblPassword = new JLabel("Password");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(usernameField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(18)
					.addComponent(loginButton)
					.addGap(34))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
