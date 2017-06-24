import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEnterEmployeeName;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterEmployeeName = new JTextField();
		txtEnterEmployeeName.setText("Enter Employee Name");
		txtEnterEmployeeName.setBounds(128, 200, 123, 20);
		contentPane.add(txtEnterEmployeeName);
		txtEnterEmployeeName.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(150, 227, 89, 23);
		contentPane.add(btnSubmit);
	}
}
