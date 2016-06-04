package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Client;
import model.Rental;

public class SearchRentalWindow extends JDialog {
	private Rental result;
	private JTable table;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchRentalWindow dialog = new SearchRentalWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Rental showDialog() {
	    setVisible(true);
	    return result;
	}
	
	public SearchRentalWindow() throws Exception {
		super(null, ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<Rental> rentals = model.ListsManager.retrieveRentals();
			
			String [] colunas = {"Cpf do Cliente", "Placa do Veiculo", "Data Inicio", "Data Fim"};
			String [][] dados = new String[rentals.size()][4];

			for ( int i = 0; i < rentals.size(); i++ ){
						
				dados[i][0] = rentals.get(i).getClient().getCpf();
				dados[i][1] = rentals.get(i).getVehicle().getPlaca();
				dados[i][2] = rentals.get(i).getInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
				dados[i][3] = rentals.get(i).getFim().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
									
			}
			table = new JTable(dados,colunas);
			JScrollPane barraRolagem = new JScrollPane(table);
			barraRolagem.setLocation(10, 11);
			barraRolagem.setSize(414, 207);
			contentPanel.add(barraRolagem);
			barraRolagem.add(table);
			barraRolagem.setViewportView(table);
			
			
		
			JButton btnSelect = new JButton("Select");
			btnSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = table.getSelectedRow();
					if (i>-1) {
						
						result = rentals.get(i);
				        dispose();  // <-- Important
					    }
				}
			});
			btnSelect.setBounds(172, 227, 89, 23);
			contentPanel.add(btnSelect);
		}
	}
}
