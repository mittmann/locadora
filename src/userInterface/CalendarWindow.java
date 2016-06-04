package userInterface;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dialog.ModalityType;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;

public class CalendarWindow extends JDialog {

	private Date data;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CalendarWindow dialog = new CalendarWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	Date showDialog() {
	    setVisible(true);
	    return data;
	}
	
	public CalendarWindow() {
		super(null, ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 600, 252);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {

		    @Override
		    public void propertyChange(PropertyChangeEvent e) {
		        data = calendar.getDate(); 
		        dispose();
		    }
		});
		calendar.setBounds(0, 0, 600, 229);
		contentPanel.add(calendar);
		
	}
	
	
}
