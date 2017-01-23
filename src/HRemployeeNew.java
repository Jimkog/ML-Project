import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HRemployeeNew extends JFrame {

	private JPanel contentPane;
	private JTextField idtext;
	private JTextField nametext;
	private JTextField surtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HRemployeeNew frame = new HRemployeeNew();
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
	public HRemployeeNew() {
		conn = SQLcon.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton button1 = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		button1.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\Actions-document-save-as-icon.png"));
		button1.setBounds(10, 236, 229, 59);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into employee(ID,Name,Surname) values(?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1, idtext.getText());
					pst.setString(2, nametext.getText());
					pst.setString(3, surtext.getText());
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
		
		JLabel label1 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(10, 125, 66, 25);
		panel.add(label1);
		
		JLabel label2 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF:");
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(10, 180, 66, 25);
		panel.add(label2);
		
		JLabel label3 = new JLabel("ID:");
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setBounds(10, 69, 46, 25);
		panel.add(label3);
		
		idtext = new JTextField();
		idtext.setBounds(108, 59, 131, 35);
		idtext.setColumns(10);
		panel.add(idtext);
		
		nametext = new JTextField();
		nametext.setBounds(108, 115, 131, 35);
		nametext.setColumns(10);
		panel.add(nametext);
		
		surtext = new JTextField();
		surtext.setBounds(108, 170, 130, 35);
		surtext.setColumns(10);
		panel.add(surtext);
		
		JButton button = new JButton("\u03A0\u03AF\u03C3\u03C9");
		button.setIcon(new ImageIcon("C:\\Users\\Jimkog\\workspace\\ML Project\\pics\\23.png"));
		button.setBounds(0, 0, 110, 48);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HRemployee frame = new HRemployee();
				frame.setVisible(true);
				dispose();
			}
		});
		panel.add(button);
	}

}
