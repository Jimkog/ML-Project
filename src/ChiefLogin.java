import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiefLogin {

	private JFrame frame;
	private JTextField unch;
	private JPasswordField passwordFieldch;

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
		frame.setBounds(100, 100, 272, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Username:");
		label.setBounds(29, 159, 58, 14);
		frame.getContentPane().add(label);
		
		unch = new JTextField();
		unch.setColumns(10);
		unch.setBounds(97, 151, 138, 31);
		frame.getContentPane().add(unch);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setBounds(29, 207, 58, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnlogch = new JButton("Login");
		btnlogch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnlogch.setBounds(83, 241, 89, 48);
		frame.getContentPane().add(btnlogch);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\Pictures\\chief.png"));
		label_2.setBounds(28, 11, 207, 129);
		frame.getContentPane().add(label_2);
		
		passwordFieldch = new JPasswordField();
		passwordFieldch.setBounds(97, 199, 138, 31);
		frame.getContentPane().add(passwordFieldch);
	}
}
