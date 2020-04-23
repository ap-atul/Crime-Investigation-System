package UI;
import UI.NewOfficerRegistration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DB.CrimeDB_Functions;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Officerlogin {

	private JFrame frmOfficerLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String userProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Officerlogin window = new Officerlogin();
					window.frmOfficerLogin.setVisible(true);
					window.frmOfficerLogin.setSize(1650,1080);
					window.frmOfficerLogin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Officerlogin() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmOfficerLogin = new JFrame();
		CrimeDB_Functions db = new CrimeDB_Functions();
		
		frmOfficerLogin.getContentPane().setBackground(Color.WHITE);
		frmOfficerLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -105, 300, 1080);
		frmOfficerLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCrimeInvestigationSystem = new JLabel("CRIME INVESTIGATION ");
		lblCrimeInvestigationSystem.setBounds(36, 147, 252, 31);
		lblCrimeInvestigationSystem.setForeground(new Color(255, 255, 255));
		panel.add(lblCrimeInvestigationSystem);
		lblCrimeInvestigationSystem.setFont(new Font("Chandas", Font.BOLD, 16));
		
		JLabel label = new JLabel("________________________________________________");
		label.setBounds(36, 166, 276, 31);
		label.setFont(new Font("Dialog", Font.BOLD, 10));
		label.setForeground(new Color(255, 255, 255));
		panel.add(label);
		
		JLabel lblOfficerLogin = new JLabel("* Officer Login");
		lblOfficerLogin.setToolTipText("Click to login ");
		lblOfficerLogin.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblOfficerLogin.setForeground(new Color(255, 255, 255));
		lblOfficerLogin.setBounds(36, 233, 169, 31);
		panel.add(lblOfficerLogin);
		
		JLabel lblAdminContact = new JLabel("* Admin contact");
		lblAdminContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminContact.main(null);
				frmOfficerLogin.setVisible(false);

				
			}
		});
		lblAdminContact.setToolTipText("Contact for Technical Help!");
		lblAdminContact.setForeground(new Color(255, 255, 255));
		lblAdminContact.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAdminContact.setBounds(36, 318, 139, 39);
		panel.add(lblAdminContact);
		
		JLabel lblAboutUs = new JLabel("* About Us");
		lblAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AboutUS.main(null);
				frmOfficerLogin.setVisible(false);

			}
		});
		lblAboutUs.setForeground(new Color(255, 255, 255));
		lblAboutUs.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAboutUs.setBounds(36, 369, 139, 23);
		panel.add(lblAboutUs);
		
		JLabel lblNewOfficer = new JLabel("* New officer Registration");
		lblNewOfficer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewOfficerRegistration.main(null);
				frmOfficerLogin.setVisible(false);
			}
		});
		lblNewOfficer.setForeground(new Color(255, 255, 255));
		lblNewOfficer.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblNewOfficer.setBounds(36, 278, 209, 28);
		panel.add(lblNewOfficer);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StationLogin.main(null);
				JOptionPane.showMessageDialog(frmOfficerLogin, "Succesfully Logout.");

				frmOfficerLogin.setVisible(false);

			}
		});
		lblLogOut.setToolTipText("Bck to Police login?");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmOfficerLogin.getContentPane().add(lblLogOut);
		
		JLabel lblOfficerLogin_1 = new JLabel("Officer login");
		lblOfficerLogin_1.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		lblOfficerLogin_1.setBounds(678, 76, 120, 27);
		frmOfficerLogin.getContentPane().add(lblOfficerLogin_1);
		
		JLabel lblNewLabel = new JLabel("officer logo");
		Image im = new ImageIcon(this.getClass().getResource("/officer-logo.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(im));
		lblNewLabel.setBounds(439, 133, 129, 202);
		frmOfficerLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblUsername.setBounds(600, 145, 108, 40);
		frmOfficerLogin.getContentPane().add(lblUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter Password :");
		lblEnterPassword.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblEnterPassword.setBounds(600, 212, 137, 33);
		frmOfficerLogin.getContentPane().add(lblEnterPassword);
		
		textField = new JTextField();
		textField.setBounds(739, 150, 197, 27);
		frmOfficerLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(739, 217, 197, 28);
		frmOfficerLogin.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = textField.getText();
				userProfile = username;
				char[] pass = passwordField.getPassword();
				String password = new String(pass);
				
				try {
					if(db.police_officer_login(username, password)) {
						OfficerHome.main(null);
						frmOfficerLogin.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(frmOfficerLogin.getContentPane(), "Please enter valid login details");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 128));
		btnLogin.setBounds(678, 282, 117, 25);
		frmOfficerLogin.getContentPane().add(btnLogin);
		
		JLabel lblNote = new JLabel("* NOTE : - If you are not registered Police Officer then goto new registration for officer  .");
		lblNote.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblNote.setBounds(439, 426, 652, 15);
		frmOfficerLogin.getContentPane().add(lblNote);
		
		
		frmOfficerLogin.setTitle("Officer Login");
		frmOfficerLogin.setBounds(100, 100, 1366, 503);
		frmOfficerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
