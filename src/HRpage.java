import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HRpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRpage frame = new HRpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HRpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0395\u03C1\u03B3\u03B1\u03B6\u03CC\u03BC\u03B5\u03BD\u03BF\u03B9");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Preppy-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HRemployee hre=new HRemployee();
				hre.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(49, 101, 208, 63);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u03A4\u03BC\u03AE\u03BC\u03B1\u03C4\u03B1");
		button.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Business-Department-icon.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HRdep hrd=new HRdep();
				hrd.setVisible(true);
				dispose();
			}
		});
		button.setBounds(49, 188, 208, 63);
		contentPane.add(button);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\User-Interface-Logout-icon.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLogout.setBounds(80, 262, 141, 43);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\ecorpssmall2.png"));
		lblNewLabel.setBounds(90, 11, 120, 79);
		contentPane.add(lblNewLabel);
	}
}
