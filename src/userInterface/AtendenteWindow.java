package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Client;
import model.Rental;
import model.Reservation;
import model.Vehicle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AtendenteWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtendenteWindow frame = new AtendenteWindow();
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
	public AtendenteWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton manageClients = new JButton("Gerenciar Clientes");
		manageClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageClientsWindow frame = new ManageClientsWindow();
				frame.setVisible(true);
			}
		});
		manageClients.setBounds(10, 150, 207, 23);
		contentPane.add(manageClients);
		
		JButton manageVeicles = new JButton("Gerenciar Ve\u00EDculos");
		manageVeicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageVehiclesWindow frame = new ManageVehiclesWindow();
				frame.setVisible(true);
			}
		});
		manageVeicles.setBounds(10, 116, 207, 23);
		contentPane.add(manageVeicles);
		
		JButton generateReports = new JButton("Gerar Relat\u00F3rio");
		generateReports.addActionListener(new ActionListener() {
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
		generateReports.setBounds(10, 82, 207, 23);
		contentPane.add(generateReports);
		
		JButton makeReservation = new JButton("Reservar Veiculo");
		makeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClientsWindow frame = null;
				SearchVehicleUpdateWindow fr = null;
				DatePickerWindow fra = null;
				Client client = null;
				Vehicle vehicle = null;
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
				try {
					ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
					fr = new SearchVehicleUpdateWindow();
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
				if (vehicle.getReservado()==false) {
					try {
						fra = new DatePickerWindow();
						datas = fra.showDialog();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						if (model.ReservationManager.addReservation(datas[0], datas[1], client, vehicle)){
							System.out.println("funfou");
						}
						else {
							JOptionPane.showMessageDialog(frame, "Reserva não pode ser efetuada");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Veículo já locado");
				}
					
			}
		});
		makeReservation.setBounds(10, 11, 207, 60);
		contentPane.add(makeReservation);
		
		JButton btnEntregarVeculo = new JButton("Entregar Ve\u00EDculo");
		btnEntregarVeculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Date todayDate = new Date();
					SearchRentalWindow r = new SearchRentalWindow();
					Rental rental = r.showDialog();
					model.FinishedRentalManager.addFinishedRental(rental);
					if (todayDate.compareTo(rental.getFim())>0) {
						Calendar calendar1 = Calendar.getInstance();
					    Calendar calendar2 = Calendar.getInstance();
					    calendar1.setTime(rental.getFim());
					    calendar2.setTime(todayDate);
					    long milliseconds1 = calendar1.getTimeInMillis();
					    long milliseconds2 = calendar2.getTimeInMillis();
					    long diff = milliseconds2 - milliseconds1;
					    long diffDays = diff / (24 * 60 * 60 * 1000);
					    
						JOptionPane.showMessageDialog(r, "Veículo está atrasado em " + String.valueOf(diffDays) + " dias");
					}
					model.RentalManager.removeRental(rental.getCode());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEntregarVeculo.setBounds(231, 82, 207, 60);
		contentPane.add(btnEntregarVeculo);
		
		JButton btnLocarVeculo = new JButton("Locar Ve\u00EDculo");
		btnLocarVeculo.addActionListener(new ActionListener() {
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
		btnLocarVeculo.setBounds(231, 11, 207, 60);
		contentPane.add(btnLocarVeculo);
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
