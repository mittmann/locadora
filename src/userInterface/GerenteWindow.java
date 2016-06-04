package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Clerk;
import model.Client;
import model.Reservation;
import model.Vehicle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class GerenteWindow extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenteWindow frame = new GerenteWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GerenteWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		manageClients.setBounds(118, 221, 199, 23);
		contentPane.add(manageClients);
		
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
		makeBorrow.setBounds(10, 11, 205, 55);
		contentPane.add(makeBorrow);
		
		JButton generateReports = new JButton("Gerar Relatorios");
		generateReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatoriosWindow r = new RelatoriosWindow();
				r.setVisible(true);
			}
		});
		generateReports.setBounds(10, 77, 205, 55);
		contentPane.add(generateReports);
		
		JButton manageStaff = new JButton("Gerenciar Funcionarios");
		manageStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStaffWindow frame = new ManageStaffWindow();
				frame.setVisible(true);
			}
		});
		manageStaff.setBounds(118, 143, 199, 23);
		contentPane.add(manageStaff);
		
		JButton btnCancelarReservas = new JButton("Cancelar Reservas");
		btnCancelarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveReservationWindow frame;
				try {
					frame = new RemoveReservationWindow();
					frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancelarReservas.setBounds(225, 77, 199, 55);
		contentPane.add(btnCancelarReservas);
		
		JButton btnReservarVeiculo = new JButton("Reservar Veiculo");
		btnReservarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createReserva();
			}
		});
		btnReservarVeiculo.setBounds(225, 11, 199, 55);
		contentPane.add(btnReservarVeiculo);
		
		JButton btnGerenciarVeiculos = new JButton("Gerenciar Veiculos");
		btnGerenciarVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageVeiclesGerenteWindow frame = new ManageVeiclesGerenteWindow();
				frame.setVisible(true);
			}
		});
		btnGerenciarVeiculos.setBounds(118, 180, 199, 29);
		contentPane.add(btnGerenciarVeiculos);
	}
	
	private static void createReserva() {
		
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
		if (vehicle.getReservado()==false && vehicle.getLocado()==false) {
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
					JOptionPane.showMessageDialog(frame, "Reserva n�o pode ser efetuada");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			JOptionPane.showMessageDialog(frame, "Ve�culo j� reservado");
		}
			
		
		
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
					JOptionPane.showMessageDialog(frame, "Loca��o n�o pode ser efetuada");
					return false;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				// TODO Auto-generated catch block
			}
		}
		else {
			JOptionPane.showMessageDialog(frame, "Ve�culo j� locado");
			return false;
		}
		return false;
		
	}
}
