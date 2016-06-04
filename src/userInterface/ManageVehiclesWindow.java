package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Clerk;
import model.Vehicle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManageVehiclesWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageVehiclesWindow frame = new ManageVehiclesWindow();
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
	public ManageVehiclesWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 204, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar Veiculo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVehicleWindow frame = new AddVehicleWindow();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 175, 63);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atualizar Veiculo");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchVehicleUpdateWindow frame = null;
				ArrayList<Vehicle> vehicles = null;
				try {
					vehicles = model.ListsManager.retrieveVehicles();
				} catch (Exception e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

				try {
					frame = new SearchVehicleUpdateWindow();
					String placa = frame.showDialog();
					for(int i = 0; i < vehicles.size(); i++) {
						if (vehicles.get(i).getPlaca().equals(placa)) {
							UpdateVehicleWindow fr = new UpdateVehicleWindow(vehicles.get(i));
							fr.setVisible(true);
						}
					}
					System.out.println(placa);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frame.setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(10, 85, 175, 63);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remover Veiculo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RemoveVehicleWindow frame = new RemoveVehicleWindow();
					frame.setVisible(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(10, 159, 175, 63);
		contentPane.add(btnNewButton_2);
	}

}
