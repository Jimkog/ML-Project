import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class HRLogin {

	private JFrame frame;
	private JTextField unhr;
	private JPasswordField passwordFieldhr;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRLogin window = new HRLogin();
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
	public HRLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 272, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		unhr = new JTextField();
		unhr.setBounds(91, 151, 138, 33);
		frame.getContentPane().add(unhr);
		unhr.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(23, 160, 58, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(23, 202, 58, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLoghr = new JButton("Login");
		btnLoghr.setBounds(91, 241, 89, 48);
		frame.getContentPane().add(btnLoghr);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\Pictures\\Untitled-2.png"));
		label.setBounds(26, 11, 207, 129);
		frame.getContentPane().add(label);
		
		passwordFieldhr = new JPasswordField();
		passwordFieldhr.setBounds(91, 193, 138, 33);
		frame.getContentPane().add(passwordFieldhr);
	}
}
