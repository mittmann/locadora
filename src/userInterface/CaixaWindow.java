package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Client;
import model.Reservation;
import model.Vehicle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class CaixaWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaixaWindow frame = new CaixaWindow();
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
	public CaixaWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton makeBorrow = new JButton("Efetuar Loca\u00E7\u00E3o");
		makeBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChooseRentalWindow h = new ChooseRentalWindow();
				int option = h.showDialog();
				if (option == 2) {
					if (createLocacao()) {
					try {
							ArrayList<Reservation> reservations = model.ListsManager.retrieveReservations();
							Reservation reservation = reservations.get(reservations.size()-1);
							model.RentalManager.addRental(reservation.getInicio(), reservation.getFim(), reservation.getClient(), reservation.getVehicle());
							model.ReservationManager.removeReservation(reservation.getCode());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				else {
					try {
						SearchClientsWindow m = new SearchClientsWindow();
						int result = m.showDialog();
						ArrayList<Client> clientes = model.ListsManager.retrieveClients();
						for(int i = 0; i < clientes.size(); i++) {
							if (clientes.get(i).getCode() == result) {
								System.out.println(result);
								SearchReservationWindow fr = new SearchReservationWindow(clientes.get(i));
								fr.setVisible(true);
							}
						
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		makeBorrow.setBounds(10, 11, 156, 64);
		contentPane.add(makeBorrow);
		
		JButton getReports = new JButton("Relat\u00F3rio de Ve\u00EDculos");
		getReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioVeiculoWindow r;
				try {
					r = new RelatorioVeiculoWindow();
					r.setVisible(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getReports.setBounds(187, 11, 150, 64);
		contentPane.add(getReports);
	}

	private static Boolean createLocacao() {
		
		SearchClientsWindow frame = null;
		SearchVehicleUpdateWindow fr = null;
		DatePickerWindow fra = null;
		Client client = null;
		Vehicle vehicle = null;
		String modelo = null;
		Date datas[]  = {null,null};
		try {
			ArrayList<Client> clientes = model.ListsManager.retrieveClients();
			frame = new SearchClientsWindow();
			int result = frame.showDialog();
			for(int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i).getCode() == result) {
					client = clientes.get(i);
				}
			
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.setVisible(false);
		
		SearchModelWindow fff;
		try {
			fff = new SearchModelWindow();
			modelo = fff.showDialog();

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			
			ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
			fr = new SearchVehicleUpdateWindow(modelo);
			String placa = fr.showDialog();
			for(int i = 0; i < vehicles.size(); i++) {
				if (vehicles.get(i).getPlaca().equals(placa)) {
					vehicle = vehicles.get(i);
				}
			
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		fr.setVisible(false);
		if (vehicle.getLocado()==false && vehicle.getReservado()==false) {
			try {
				fra = new DatePickerWindow(1);
				datas = fra.showDialog();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				if (model.ReservationManager.addReservation(datas[0], datas[1], client, vehicle)){
					System.out.println("funfou");
					return true;
				}
				else {
					JOptionPane.showMessageDialog(frame, "Locação não pode ser efetuada");
					return false;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				// TODO Auto-generated catch block
			}
		}
		else {
			JOptionPane.showMessageDialog(frame, "Veículo já locado");
			return false;
		}
		return false;
		
	}


}

