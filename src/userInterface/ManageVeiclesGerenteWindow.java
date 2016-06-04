package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Vehicle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManageVeiclesGerenteWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageVeiclesGerenteWindow frame = new ManageVeiclesGerenteWindow();
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
	public ManageVeiclesGerenteWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 218, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionarVeiculo = new JButton("Adicionar Veiculo");
		btnAdicionarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVehicleWindow frame = new AddVehicleWindow();
				frame.setVisible(true);
			}
		});
		btnAdicionarVeiculo.setBounds(10, 11, 185, 60);
		contentPane.add(btnAdicionarVeiculo);
		
		JButton btnRemoverVeiculo = new JButton("Remover Veiculo");
		btnRemoverVeiculo.addActionListener(new ActionListener() {
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
		btnRemoverVeiculo.setBounds(10, 153, 185, 60);
		contentPane.add(btnRemoverVeiculo);
		
		JButton btnAtualizarVeiculo = new JButton("Atualizar Veiculo");
		btnAtualizarVeiculo.addActionListener(new ActionListener() {
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
		btnAtualizarVeiculo.setBounds(10, 82, 185, 60);
		contentPane.add(btnAtualizarVeiculo);
		
		JButton btnAdicionarDespesasAo = new JButton("Adicionar Despesas ao Veiculo");
		btnAdicionarDespesasAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdicionarDespesasAo.setBounds(10, 224, 185, 23);
		contentPane.add(btnAdicionarDespesasAo);
		
		JButton btnPagarDespesasDo = new JButton("Pagar Despesas do Veiculo");
		btnPagarDespesasDo.setBounds(10, 258, 185, 23);
		contentPane.add(btnPagarDespesasDo);
	}

}
