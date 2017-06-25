

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
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
	
	boolean verify=false;
	/**
	 * Create the frame.
	 */
	Employee [] emp;
	private JLabel lblPicture;
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
		
		JTextPane txtpnOverallCompanyEmotion = new JTextPane();
		txtpnOverallCompanyEmotion.setText("Overall Company Emotion:");
		txtpnOverallCompanyEmotion.setBounds(55, 11, 226, 20);
		contentPane.add(txtpnOverallCompanyEmotion);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(311, 11, 123, 20);
		textPane_4.setText(getCompanyEmotions());
		contentPane.add(textPane_4);


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
			
				if(txtpnAge!=null){
					if(txtpnAge.isEnabled()){
				contentPane.remove(txtpnName);
				
				contentPane.remove(textPane);
				contentPane.remove(txtpnAge);
				contentPane.remove(textPane_1);
				contentPane.remove(txtpnEmployeeEmotions);
				contentPane.remove(txtpnPosition);
				contentPane.remove(textPane_2);
					}
				}
				inputVariables();
				verify=false;
				
			}
		});
		btnAddEmployee.setBounds(268, 227, 103, 23);
		contentPane.add(btnAddEmployee);
		
		
		
		
		
		
		
		
		
		

		

	}
	
	public void loadText(int index){
		
		if(txtName!=null&&txtName.isEnabled()){
			contentPane.remove(txtName);
			contentPane.remove(txtAge);
			contentPane.remove(txtPosition);
			contentPane.remove(txtPathToImage);
			contentPane.remove(btnEnter);
		}
		
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
		txtpnEmployeeEmotions.setBounds(10, 115, 120, 20);
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
		textPane_3.setBounds(127, 115, 116, 20);
		textPane_3.setText(emp[index].getDominantEmotions());
		contentPane.add(textPane_3);
		
		URL url;
		try {
			url = new URL(emp[index].getPath());
			ImageIcon image =new ImageIcon(url);
			lblPicture = new JLabel(image);
			lblPicture.setBounds(268, 63, 128, 110);
			contentPane.add(lblPicture);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
				arr[3]=txtPathToImage.getText();
				
				
				contentPane.remove(txtName);
				contentPane.remove(txtAge);
				contentPane.remove(txtPosition);
				contentPane.remove(txtPathToImage);
				contentPane.remove(btnEnter);
				
				verify=true;
			}
		});
		btnEnter.setBounds(207, 166, 89, 23);
		contentPane.add(btnEnter);
		
			if(verify=true)
		return arr;
		
		else
			return null;
		
		
	}
	
	public String getCompanyEmotions(){
		if(emp[0]==null)
			return "no employees added";
		
		String[]arr=new String[emp.length];
		int[]nums=new int[arr.length];
		for(int i =0;i<arr.length;i++){
			arr[i]=emp[i].getDominantEmotions();
			if(arr[i].compareTo("anger")==0){
				nums[i]=1;
			}
			else if(arr[i].compareTo("contempt")==0){
				nums[i]=2;
			}
			else if(arr[i].compareTo("disgust")==0){
				nums[i]=3;
			}
			else if(arr[i].compareTo("fear")==0){
				nums[i]=4;
			}
			else if(arr[i].compareTo("happiness")==0){
				nums[i]=5;
			}
			else if(arr[i].compareTo("neutral")==0){
				nums[i]=6;
			}
			else if(arr[i].compareTo("sadness")==0){
				nums[i]=7;
			}
			else if(arr[i].compareTo("surprise")==0){
				nums[i]=8;
			}
			
			
		}
	int emotion=calcMode(nums);
	
	if(emotion==1)
		return "anger";
	else if(emotion==2)
		return "contempt";
	else if(emotion==3)
		return "disgust";
	else if(emotion==4)
		return "fear";
	else if(emotion==5)
		return "happiness";
	else if(emotion==6)
		return "neutral";
	else if(emotion==7)
		return "sadness";
	else if(emotion==8)
		return "surprise";
		
	return null;
	}
	
	public int calcMode(int[] nums)
	  {
	    int mode = 0;
	    int[] tallies = new int[76];  /* array to hold the number of times each index occurs
	                                   * Note: index 0 is not used */
	    
	    Arrays.sort(nums);
	    
	    for (int k = 1; k <= 75; k++)
	    {
	      for (int i = 0; i < nums.length; i++)
	      {
	        if (nums[i] == k)
	        {
	          tallies[k]++;  // count how many times each index occurs
	        }
	      }
	      
	      if (tallies[k] > mode)
	      {
	        mode = tallies[k];   // store max occurrances
	      }
	    }
	    
	    int modeCount = mode;
	    
	    if (mode == 1)
	    {
	     mode = 0;   // no mode
	    }
	    else
	    {
	      for (int j = 1; j < tallies.length; j++)
	      {
	        if (modeCount == tallies[j])   // find index of max occurances (index is the mode)
	        {
	          mode = j;
	          break; // end loop once mode is found to prevent the value from being overwritten
	        }
	      }
	    }
	    return mode;
	  }
}
