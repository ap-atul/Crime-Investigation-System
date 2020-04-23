package UI;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home {

	private JFrame frmCrimeInvestigationhome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmCrimeInvestigationhome.setVisible(true);
					window.frmCrimeInvestigationhome.setSize(1650,1080);
					window.frmCrimeInvestigationhome.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrimeInvestigationhome = new JFrame();
		frmCrimeInvestigationhome.getContentPane().setBackground(Color.WHITE);
		frmCrimeInvestigationhome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -105, 300, 1080);
		frmCrimeInvestigationhome.getContentPane().add(panel);
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
		lblOfficerLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Officerlogin.main(null);
				frmCrimeInvestigationhome.setVisible(false);
				
				
			}
		});
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
				frmCrimeInvestigationhome.setVisible(false);

			}
		});
		lblAdminContact.setToolTipText("Contact for Technical Help!");
		lblAdminContact.setForeground(new Color(255, 255, 255));
		lblAdminContact.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAdminContact.setBounds(36, 312, 139, 39);
		panel.add(lblAdminContact);
		
		JLabel lblAboutUs = new JLabel("* About Us");
		lblAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AboutUS.main(null);
				frmCrimeInvestigationhome.setVisible(false);

			}
		});
		lblAboutUs.setForeground(new Color(255, 255, 255));
		lblAboutUs.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAboutUs.setBounds(36, 363, 139, 23);
		panel.add(lblAboutUs);
		
		JLabel lblNewOfficer = new JLabel("* New officer Registration");
		lblNewOfficer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewOfficerRegistration.main(null);
				frmCrimeInvestigationhome.setVisible(false);

			}
		});
		lblNewOfficer.setForeground(Color.WHITE);
		lblNewOfficer.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblNewOfficer.setBounds(36, 276, 209, 28);
		panel.add(lblNewOfficer);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StationLogin.main(null);
				JOptionPane.showMessageDialog(frmCrimeInvestigationhome, "Succesfully Logout.");

				frmCrimeInvestigationhome.setVisible(false);

			}
		});
		lblLogOut.setToolTipText("Bck to Police login?");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmCrimeInvestigationhome.getContentPane().add(lblLogOut);
		
	   
	    
		JLabel lblWelcomeUserCrime = new JLabel("Welcome ! User to Crime Investigation System .");
		lblWelcomeUserCrime.setBackground(new Color(60, 179, 113));
		lblWelcomeUserCrime.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblWelcomeUserCrime.setBounds(371, 85, 374, 33);
		frmCrimeInvestigationhome.getContentPane().add(lblWelcomeUserCrime);
		frmCrimeInvestigationhome.setTitle("Crime Investigation/Home");
		frmCrimeInvestigationhome.setBounds(100, 100, 1348, 425);
		frmCrimeInvestigationhome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
