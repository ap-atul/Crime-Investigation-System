package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AboutUS {

	private JFrame frmAboutUs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUS window = new AboutUS();
					window.frmAboutUs.setVisible(true);
					window.frmAboutUs.setSize(1650,1080);
					window.frmAboutUs.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AboutUS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAboutUs = new JFrame();
		
		frmAboutUs.getContentPane().setBackground(Color.WHITE);
		frmAboutUs.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -105, 300, 1080);
		frmAboutUs.getContentPane().add(panel);
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
				frmAboutUs.setVisible(false);
				
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
				frmAboutUs.setVisible(false);

			}
		});
		lblAdminContact.setToolTipText("Contact for Technical Help!");
		lblAdminContact.setForeground(new Color(255, 255, 255));
		lblAdminContact.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAdminContact.setBounds(36, 312, 139, 39);
		panel.add(lblAdminContact);
		
		JLabel lblAboutUs = new JLabel("* About Us");
		lblAboutUs.setForeground(new Color(255, 255, 255));
		lblAboutUs.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAboutUs.setBounds(36, 363, 139, 23);
		panel.add(lblAboutUs);
		
		JLabel lblNewOfficer = new JLabel("* New officer Registration");
		lblNewOfficer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewOfficerRegistration.main(null);
				frmAboutUs.setVisible(false);

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
				JOptionPane.showMessageDialog(frmAboutUs, "Succesfully Logout.");

				frmAboutUs.setVisible(false);

			}
		});
		lblLogOut.setToolTipText("Bck to Police login?");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmAboutUs.getContentPane().add(lblLogOut);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(406, 131, 70, 15);
		frmAboutUs.getContentPane().add(label_1);
		
		JLabel lblAboutimage = new JLabel("aboutimage");
		Image im = new ImageIcon(this.getClass().getResource("/about.jpg")).getImage();
		lblAboutimage.setIcon(new ImageIcon(im));
		lblAboutimage.setForeground(new Color(255, 255, 240));
		lblAboutimage.setBounds(691, 0, 279, 280);
		frmAboutUs.getContentPane().add(lblAboutimage);
		
		frmAboutUs.setTitle("About Us");
		frmAboutUs.setBounds(100, 100, 1196, 559);
		frmAboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
