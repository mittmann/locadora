package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.VehicleManager;
import javax.swing.JLabel;
public class AddVehicleWindow extends JFrame {

	private JPanel contentPane;
	private JTextField marcaField;
	private JTextField placaField;
	private JTextField modeloField;
	private JTextField corField;
	private JTextField anoField;
	private JTextField filialField;
	private JTextField kmField;
	private JTextField valorField;

	private JLabel lblMarca;
	private JLabel lblPlaca;
	private JLabel lblModelo;
	private JLabel lblCor;
	private JLabel lblAno;
	private JLabel lblFilial;
	private JLabel lblKm;
	private JLabel lblValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVehicleWindow frame = new AddVehicleWindow();
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
	public AddVehicleWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		marcaField = new JTextField();
		marcaField.setBounds(99, 29, 126, 20);
		contentPane.add(marcaField);
		marcaField.setColumns(10);
		
		placaField = new JTextField();
		placaField.setBounds(99, 122, 86, 20);
		contentPane.add(placaField);
		placaField.setColumns(10);
		
		modeloField = new JTextField();
		modeloField.setBounds(99, 60, 126, 20);
		contentPane.add(modeloField);
		modeloField.setColumns(10);
		
		corField = new JTextField();
		corField.setBounds(99, 91, 86, 20);
		contentPane.add(corField);
		corField.setColumns(10);
		
		anoField = new JTextField();
		anoField.setBounds(291, 29, 86, 20);
		contentPane.add(anoField);
		anoField.setColumns(10);
		
		filialField = new JTextField();
		filialField.setBounds(291, 60, 86, 20);
		contentPane.add(filialField);
		filialField.setColumns(10);
		
		kmField = new JTextField();
		kmField.setBounds(291, 91, 86, 20);
		contentPane.add(kmField);
		kmField.setColumns(10);
		
		valorField = new JTextField();
		valorField.setBounds(291, 122, 86, 20);
		contentPane.add(valorField);
		valorField.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.VehicleManager.addVehicle(marcaField.getText(), placaField.getText(), modeloField.getText(), corField.getText(), anoField.getText(), filialField.getText(), kmField.getText(), valorField.getText());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnOk.setBounds(170, 173, 89, 23);
		contentPane.add(btnOk);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(22, 32, 46, 14);
		contentPane.add(lblMarca);
		
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(22, 125, 46, 14);
		contentPane.add(lblPlaca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(22, 63, 46, 14);
		contentPane.add(lblModelo);
		
		lblCor = new JLabel("Cor");
		lblCor.setBounds(22, 94, 46, 14);
		contentPane.add(lblCor);
		
		lblAno = new JLabel("Ano");
		lblAno.setBounds(235, 32, 46, 14);
		contentPane.add(lblAno);
		
		lblFilial = new JLabel("Filial");
		lblFilial.setBounds(235, 63, 46, 14);
		contentPane.add(lblFilial);
		
		lblKm = new JLabel("Km");
		lblKm.setBounds(235, 94, 46, 14);
		contentPane.add(lblKm);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(235, 125, 46, 14);
		contentPane.add(lblValor);
	}

}
