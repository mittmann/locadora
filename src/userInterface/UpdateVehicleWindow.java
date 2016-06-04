package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Vehicle;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateVehicleWindow extends JFrame {

	private JPanel contentPane;
	private JTextField marcaField;
	private JTextField placaField;
	private JTextField modeloField;
	private JTextField corField;
	private JTextField anoField;
	private JTextField filialField;
	private JTextField kmField;
	private JTextField valorField;


	public UpdateVehicleWindow(Vehicle vehicle) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 443, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		marcaField = new JTextField();
		marcaField.setText(vehicle.getMarca());
		marcaField.setBounds(69, 11, 119, 20);
		contentPane.add(marcaField);
		marcaField.setColumns(10);
		
		placaField = new JTextField();
		placaField.setText(vehicle.getPlaca());
		placaField.setBounds(69, 104, 86, 20);
		contentPane.add(placaField);
		placaField.setColumns(10);
		
		modeloField = new JTextField();
		modeloField.setText(vehicle.getModelo());
		modeloField.setBounds(69, 42, 119, 20);
		contentPane.add(modeloField);
		modeloField.setColumns(10);
		
		corField = new JTextField();
		corField.setText(vehicle.getCor());
		corField.setBounds(69, 73, 86, 20);
		contentPane.add(corField);
		corField.setColumns(10);
		
		anoField = new JTextField();
		anoField.setText(vehicle.getAno());
		anoField.setBounds(278, 11, 86, 20);
		contentPane.add(anoField);
		anoField.setColumns(10);
		
		filialField = new JTextField();
		filialField.setText(vehicle.getFilial());
		filialField.setBounds(278, 42, 86, 20);
		contentPane.add(filialField);
		filialField.setColumns(10);
		
		kmField = new JTextField();
		kmField.setText(vehicle.getKm());
		kmField.setBounds(278, 73, 86, 20);
		contentPane.add(kmField);
		kmField.setColumns(10);
		
		valorField = new JTextField();
		valorField.setText(vehicle.getValor());
		valorField.setBounds(278, 104, 86, 20);
		contentPane.add(valorField);
		valorField.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 14, 46, 14);
		contentPane.add(lblMarca);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(10, 107, 46, 14);
		contentPane.add(lblPlaca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 45, 46, 14);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(10, 76, 46, 14);
		contentPane.add(lblCor);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(219, 14, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblFilial = new JLabel("Filial");
		lblFilial.setBounds(219, 45, 46, 14);
		contentPane.add(lblFilial);
		
		JLabel lblKm = new JLabel("Km");
		lblKm.setBounds(219, 76, 46, 14);
		contentPane.add(lblKm);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(219, 107, 46, 14);
		contentPane.add(lblValor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.VehicleManager.updateVehicle(marcaField.getText(), placaField.getText(), modeloField.getText(), corField.getText(), anoField.getText(), filialField.getText(), kmField.getText(), valorField.getText(),vehicle.getPlaca());
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOk.setBounds(161, 144, 104, 48);
		contentPane.add(btnOk);
	}

}
