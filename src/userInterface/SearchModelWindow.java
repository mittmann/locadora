package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.VehicleList;
import model.Vehicle;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SearchModelWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String modelo = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchModelWindow dialog = new SearchModelWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String showDialog() {
	    setVisible(true);
	    return modelo;
	}
	public SearchModelWindow() throws Exception {
		super(null, ModalityType.APPLICATION_MODAL);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			ArrayList<Vehicle> vehicles = model.ListsManager.retrieveVehicles();
			ArrayList<String> models = new ArrayList<String>();
			for(int i = 0; i < vehicles.size(); i++) {
				if (!models.contains(vehicles.get(i).getModelo())) {
					 models.add(vehicles.get(i).getModelo());
				}
			}
			DefaultListModel lm = new DefaultListModel();
			JList list = new JList(lm);
			for ( int i = 0; i < models.size(); i++ ){
				  lm.addElement(models.get(i));
				}
			list.setBounds(10, 11, 401, 206);
			contentPanel.add(list);
		JButton okButton = new JButton("OK");
		okButton.setBounds(189, 228, 47, 23);
		contentPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = list.getSelectedIndex();
				if (i>-1) {
					modelo = models.get(i);
			        dispose();  // <-- Important
				    }
			}
		});
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				buttonPane.setLayout(null);
			}
		}
	}
	}
}
