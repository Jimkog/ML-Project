import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ChiefLogin {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiefLogin window = new ChiefLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChiefLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 243, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Username:");
		label.setBounds(10, 154, 58, 14);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(71, 151, 138, 20);
		frame.getContentPane().add(textField);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setBounds(10, 196, 58, 14);
		frame.getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(71, 193, 138, 20);
		frame.getContentPane().add(textField_1);
		
		JButton button = new JButton("Login");
		button.setBounds(10, 241, 89, 48);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(120, 241, 89, 48);
		frame.getContentPane().add(button_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\Pictures\\chief.png"));
		label_2.setBounds(10, 11, 207, 129);
		frame.getContentPane().add(label_2);
	}

}
