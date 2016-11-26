import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnHrLogin = new JButton("HR Login");
		btnHrLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRLogin nw = new HRLogin();
				nw.NewScreen();
			}
		});
		btnHrLogin.setBounds(66, 212, 105, 47);
		frame.getContentPane().add(btnHrLogin);
		
		JButton btnChiefLogin = new JButton("Chief Login");
		btnChiefLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChiefLogin nw = new ChiefLogin();
				nw.NewScreen();
			}
		});
		btnChiefLogin.setBounds(265, 212, 116, 47);
		frame.getContentPane().add(btnChiefLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Jimkog\\Desktop\\welcome.png"));
		label.setBounds(10, 11, 427, 195);
		frame.getContentPane().add(label);
	}
}
