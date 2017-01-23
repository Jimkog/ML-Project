import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HRdepNew extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField numtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRdepNew frame = new HRdepNew();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	/**
	 * Create the frame.
	 */
	public HRdepNew() {
		conn = SQLcon.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton button1 = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		button1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-document-save-as-icon.png"));
		button1.setBounds(37, 236, 203, 59);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into department(Name,Employee_Number) values(?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, nametext.getText());
					pst.setString(2, numtext.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Επιτυχής αποθήκευση!");
					pst.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		panel.setLayout(null);
		panel.add(button1);
		
		JLabel label1 = new JLabel("<html>\u038C\u03BD\u03BF\u03BC\u03B1<br>\u03C4\u03BC\u03AE\u03BC\u03B1\u03C4\u03BF\u03C2:</html>");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(10, 80, 83, 35);
		panel.add(label1);
		
		JLabel label2 = new JLabel("<html>\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2<br>\u0395\u03C1\u03B3\u03B1\u03B6\u03BF\u03BC\u03AD\u03BD\u03C9\u03BD:</html>");
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(10, 161, 107, 35);
		panel.add(label2);
		
		nametext = new JTextField();
		nametext.setBounds(117, 80, 140, 35);
		nametext.setColumns(10);
		panel.add(nametext);
		
		numtext = new JTextField();
		numtext.setBounds(117, 161, 140, 35);
		numtext.setColumns(10);
		panel.add(numtext);
		
		JButton button = new JButton("\u03A0\u03AF\u03C3\u03C9");
		button.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		button.setBounds(0, 11, 117, 35);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HRdep frame = new HRdep();
				frame.setVisible(true);
				dispose();
			}
		});
		panel.add(button);
	}

}
