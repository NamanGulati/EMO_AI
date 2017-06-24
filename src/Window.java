import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
		Employee [] emp=new Employee[20];
		for(int i=0;i<emp.length-2;i++){
			emp[i]=new Employee("bob",35,"manager",new Emotions(),"C:");
		}
		emp[19]=new Employee("Joe",34,"CEO",new Emotions(),"C:");
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

		int index;
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = txtEnterEmployeeName.getText();
				for(int i=0;i<emp.length;i++){
					if(name.equals(emp[i].name)){
						index=i;
						break;
					}
							
				}
				
			}
		});
		btnSubmit.setBounds(150, 227, 89, 23);
		contentPane.add(btnSubmit);
	}
}
