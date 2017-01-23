import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HRLogin {

	private JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void newScreen() {
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
	Connection conn=null;
	private JTextField unhr;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public HRLogin() {
		initialize();
		conn = SQLcon.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 272, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		unhr = new JTextField();
		unhr.setBounds(108, 169, 138, 33);
		frame.getContentPane().add(unhr);
		unhr.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(10, 178, 88, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(10, 222, 88, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLoghr = new JButton("Login");
		btnLoghr.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\User-Interface-Login-icon.png"));
		btnLoghr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from hrlog where username=? and password=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, unhr.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count=count+1;
					}
					if(count==1){
						JOptionPane.showMessageDialog(null, "Επιτυχής σύνδεση!");
						frame.dispose();
						HRpage hrp=new HRpage();
						hrp.setVisible(true);
					}
					else if(count>1){
						JOptionPane.showMessageDialog(null, "Τα στοιχεία χρησιμοποιούνται απο άλλον χρήστη. Αλλάξτε τα!");
					}
					else{
						JOptionPane.showMessageDialog(null, "Τα στοιχεία σύνδεσης είναι λάθος!");
					}
					rs.close();
					pst.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);	
				}
			}
		});
		btnLoghr.setBounds(10, 257, 107, 48);
		frame.getContentPane().add(btnLoghr);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 213, 138, 33);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("default:  un:guest  /  pass:guest");
		label.setBounds(32, 138, 196, 20);
		frame.getContentPane().add(label);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBack.setBounds(139, 257, 107, 48);
		frame.getContentPane().add(btnBack);
		
		JLabel label1 = new JLabel("");
		label1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Untitled-2.png"));
		label1.setBounds(22, 11, 212, 129);
		frame.getContentPane().add(label1);
	}
}
