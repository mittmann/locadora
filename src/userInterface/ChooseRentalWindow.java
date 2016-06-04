package userInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ChooseRentalWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int option;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChooseRentalWindow dialog = new ChooseRentalWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int showDialog() {
	    setVisible(true);
	    return option;
	}
	
	public ChooseRentalWindow() {
		super(null, ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnLocarAPartir = new JButton("Locar a partir de reserva");
		btnLocarAPartir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 1;
				dispose();
			}
		});
		btnLocarAPartir.setBounds(52, 40, 314, 50);
		contentPanel.add(btnLocarAPartir);
		
		JButton btnNovaLocao = new JButton("Locar sem reserva");
		btnNovaLocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 2;
				dispose();
			}
		});
		btnNovaLocao.setBounds(52, 120, 314, 48);
		contentPanel.add(btnNovaLocao);
	}
}
