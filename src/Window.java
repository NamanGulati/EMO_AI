

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEnterEmployeeName;
	private JTextPane txtpnName;
	private JTextPane textPane;
	private JTextPane txtpnAge;
	private JTextPane textPane_1;
	private JTextPane txtpnEmployeeEmotions;
	private JButton btnAddEmployee;
	private JTextPane txtpnPosition;
	private JTextPane textPane_2;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtPosition;
	private JTextField txtPathToImage;
	private JButton btnEnter;
	private JTextPane textPane_3;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	Employee [] emp;
	public Window(Employee[]emp) {
	
		this.emp=emp;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterEmployeeName = new JTextField();
		txtEnterEmployeeName.setText("Enter Employee Name");
		txtEnterEmployeeName.setBounds(198, 200, 123, 20);
		contentPane.add(txtEnterEmployeeName);
		txtEnterEmployeeName.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");


		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index=-1;
				String name = txtEnterEmployeeName.getText();
				
				for(int i=0;i<emp.length;i++){
					if(name.equals(emp[i].getName())){
						index=i;
						break;
					}
				/*	if(index==-1&&i==emp.length-1){
						System.out.println("I didnt find yo dude");
						
					}*/
							
				}
				
				if(index!=-1)
				loadText(index);
						
			}
		});
		
		
		btnSubmit.setBounds(150, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		
		
		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnAddEmployee.setEnabled(false);
				txtpnName.setEnabled(false);
				textPane.setEnabled(false);
				txtpnAge.setEnabled(false);
				textPane_1.setEnabled(false);
				txtpnEmployeeEmotions.setEnabled(false);
				txtpnPosition.setEnabled(false);
				textPane_2.setBounds(69, 84, 113, 20);
				textPane_2.setText(inputVariables().toString());
				contentPane.add(textPane_2);
				System.out.println();
			}
		});
		btnAddEmployee.setBounds(268, 227, 103, 23);
		contentPane.add(btnAddEmployee);
		
		
		
		

		

	}
	
	public void loadText(int index){
		txtpnName = new JTextPane();
		txtpnName.setText("Name:");
		txtpnName.setBounds(10, 27, 49, 20);
		contentPane.add(txtpnName);
		
		textPane = new JTextPane();
		textPane.setBounds(69, 27, 113, 20);
		textPane.setText(emp[index].getName());
		contentPane.add(textPane);
		
		txtpnAge = new JTextPane();
		txtpnAge.setText("Age:");
		txtpnAge.setBounds(10, 58, 49, 20);
		contentPane.add(txtpnAge);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(69, 58, 59, 20);
		textPane_1.setText(""+emp[index].getAge());
		contentPane.add(textPane_1);
		
		txtpnEmployeeEmotions = new JTextPane();
		txtpnEmployeeEmotions.setText("Employee Emotions:");
		txtpnEmployeeEmotions.setBounds(10, 115, 103, 20);
		contentPane.add(txtpnEmployeeEmotions);
		
		txtpnPosition = new JTextPane();
		txtpnPosition.setText("Position");
		txtpnPosition.setBounds(10, 84, 49, 20);
		contentPane.add(txtpnPosition);
		
		textPane_2 = new JTextPane();
		textPane_2.setBounds(69, 84, 113, 20);
		textPane_2.setText(emp[index].getPosition());
		contentPane.add(textPane_2);
		
		textPane_3 = new JTextPane();
		textPane_3.setBounds(123, 129, 116, 20);
		textPane_3.setText(emp[index].getDominantEmotions());
		contentPane.add(textPane_3);
		
	}
	
	public String[] inputVariables(){
		String [] arr=new String[4];
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setBounds(198, 27, 123, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtAge = new JTextField();
		txtAge.setText("age");
		txtAge.setBounds(198, 58, 86, 20);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtPosition = new JTextField();
		txtPosition.setText("Position");
		txtPosition.setBounds(220, 84, 113, 20);
		contentPane.add(txtPosition);
		txtPosition.setColumns(10);
		
		txtPathToImage = new JTextField();
		txtPathToImage.setText("Path to Image");
		txtPathToImage.setBounds(198, 115, 151, 20);
		contentPane.add(txtPathToImage);
		txtPathToImage.setColumns(10);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arr[0]=txtName.getText();
				arr[1]=txtAge.getText();
				arr[2]=txtPosition.getText();
				arr[4]=txtPathToImage.getText();
				
				txtName.setEnabled(false);
				txtAge.setEnabled(false);
				txtPosition.setEnabled(false);
				txtPathToImage.setEnabled(false);
				btnEnter.setEnabled(false);
			}
		});
		btnEnter.setBounds(207, 166, 89, 23);
		contentPane.add(btnEnter);
		return arr;
		
		
		
	}
}
