import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ChiefLogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
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
	Connection conn=null;
	private JTextField unch;
	private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public ChiefLogin() {
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
		
		JLabel label = new JLabel("Username:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 181, 77, 14);
		frame.getContentPane().add(label);
		
		unch = new JTextField();
		unch.setColumns(10);
		unch.setBounds(108, 174, 138, 32);
		frame.getContentPane().add(unch);
		
		JLabel label1 = new JLabel("Password:");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(10, 221, 77, 14);
		frame.getContentPane().add(label1);
		
		JButton btnlogch = new JButton("Login");
		btnlogch.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\User-Interface-Login-icon.png"));
		btnlogch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="select * from chieflog where username=? and password=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, unch.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next()){
						count=count+1;
					}
					if(count==1){
						JOptionPane.showMessageDialog(null, "Επιτυχής σύνδεση!");
						frame.dispose();
						ChiefPage chp=new ChiefPage();
						chp.setVisible(true);
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
		btnlogch.setBounds(10, 257, 108, 48);
		frame.getContentPane().add(btnlogch);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(108, 214, 138, 32);
		frame.getContentPane().add(passwordField);
		
		JLabel lblDefault = new JLabel("default:  un:guest  /  pass:guest");
		lblDefault.setBounds(48, 144, 194, 26);
		frame.getContentPane().add(lblDefault);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(143, 257, 103, 48);
		frame.getContentPane().add(btnBack);
		
		JLabel label2 = new JLabel("");
		label2.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\chief.png"));
		label2.setBounds(38, 11, 175, 132);
		frame.getContentPane().add(label2);
	}
}
