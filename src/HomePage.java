import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;

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
		frame.setBounds(100, 100, 459, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnHrLogin = new JButton("HR Login");
		btnHrLogin.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Sharepoint-icon.png"));
		btnHrLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRLogin nw = new HRLogin();
				nw.newScreen();
			}
		});
		btnHrLogin.setBounds(28, 189, 166, 87);
		frame.getContentPane().add(btnHrLogin);
		
		JButton btnChiefLogin = new JButton("Chief Login");
		btnChiefLogin.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\boss-icon.png"));
		btnChiefLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChiefLogin nw = new ChiefLogin();
				nw.newScreen();
			}
		});
		btnChiefLogin.setBounds(239, 189, 166, 87);
		frame.getContentPane().add(btnChiefLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\ecorpsmall2.png"));
		label.setBounds(28, 9, 210, 169);
		frame.getContentPane().add(label);
		
		JLabel lblDevelopedByDimitris = new JLabel("Developed by Dimitris Kogianos & Thanos Divaris");
		lblDevelopedByDimitris.setFont(new Font("Tekton Pro Cond", Font.ITALIC, 11));
		lblDevelopedByDimitris.setBounds(239, 287, 194, 18);
		frame.getContentPane().add(lblDevelopedByDimitris);
		
		JLabel lbladd = new JLabel("~CREATE");
		lbladd.setFont(new Font("Papyrus", Font.BOLD, 14));
		lbladd.setBounds(272, 11, 112, 33);
		frame.getContentPane().add(lbladd);
		
		JLabel lbledit = new JLabel("~EDIT");
		lbledit.setFont(new Font("Papyrus", Font.BOLD, 14));
		lbledit.setBounds(272, 55, 71, 29);
		frame.getContentPane().add(lbledit);
		
		JLabel lblrate = new JLabel("~RATE");
		lblrate.setFont(new Font("Papyrus", Font.BOLD, 14));
		lblrate.setBounds(272, 95, 71, 29);
		frame.getContentPane().add(lblrate);
		
		JLabel lbldelete = new JLabel("~DELETE");
		lbldelete.setFont(new Font("Papyrus", Font.BOLD, 14));
		lbldelete.setBounds(272, 135, 112, 29);
		frame.getContentPane().add(lbldelete);
	}
}
