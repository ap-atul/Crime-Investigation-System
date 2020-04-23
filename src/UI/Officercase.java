package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import DB.CrimeDB_Functions;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Officercase {

	private JFrame frmOfficerCase;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public static ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Officercase window = new Officercase();
					
					window.frmOfficerCase.setVisible(true);
					window.frmOfficerCase.setVisible(true);
					window.frmOfficerCase.setSize(1650,1080);
					window.frmOfficerCase.setLocationRelativeTo(null);
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
	public Officercase() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		
		CrimeDB_Functions db = new CrimeDB_Functions();
		
		frmOfficerCase = new JFrame();
		frmOfficerCase.getContentPane().setBackground(Color.WHITE);
		frmOfficerCase.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -105, 300, 1080);
		frmOfficerCase.getContentPane().add(panel);
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
		
		JLabel lblOfficerLogin = new JLabel("* FIR");
		lblOfficerLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfficerHome.main(null);
				frmOfficerCase.setVisible(false);
				
			}
		});
		lblOfficerLogin.setToolTipText("Click to login ");
		lblOfficerLogin.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblOfficerLogin.setForeground(new Color(255, 255, 255));
		lblOfficerLogin.setBounds(36, 233, 169, 31);
		panel.add(lblOfficerLogin);
		
		JLabel userProfile = new JLabel("");
		userProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userProfile.setForeground(Color.WHITE);
		userProfile.setText(Officerlogin.userProfile);
		userProfile.setBounds(36, 758, 214, 31);
		panel.add(userProfile);
		
		JLabel lblAdminContact = new JLabel("* Cases");
		lblAdminContact.setToolTipText("Contact for Technical Help!");
		lblAdminContact.setForeground(new Color(255, 255, 255));
		lblAdminContact.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAdminContact.setBounds(36, 312, 139, 39);
		panel.add(lblAdminContact);
		
		JLabel lblNewOfficer = new JLabel("* Criminals");
		lblNewOfficer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfficerCriminals.main(null);
				frmOfficerCase.setVisible(false);

				
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
				Officerlogin.main(null);
               
				JOptionPane.showMessageDialog(frmOfficerCase, "Succesfully Logout.");

				frmOfficerCase.setVisible(false);
				

			}
		});
		lblLogOut.setToolTipText("Back to Police login?");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmOfficerCase.getContentPane().add(lblLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
		tabbedPane.setBounds(353, 12, 895, 600);
		frmOfficerCase.getContentPane().add(tabbedPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Make Case", null, desktopPane, null);
		
		JLabel lblFirId = new JLabel("* FIR ID");
		lblFirId.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblFirId.setBounds(61, 49, 70, 15);
		desktopPane.add(lblFirId);
		
		JLabel lblCaseId = new JLabel("* Case ID");
		lblCaseId.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblCaseId.setBounds(61, 87, 70, 15);
		desktopPane.add(lblCaseId);
		
		JLabel lblDate = new JLabel("* Date");
		lblDate.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblDate.setBounds(61, 130, 70, 15);
		desktopPane.add(lblDate);
		
		JLabel lblIncidentPlace = new JLabel("* Incident Place");
		lblIncidentPlace.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblIncidentPlace.setBounds(61, 162, 150, 15);
		desktopPane.add(lblIncidentPlace);
		
		JLabel lblObjectsFoundOn = new JLabel("* Objects Found on Place");
		lblObjectsFoundOn.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblObjectsFoundOn.setBounds(61, 189, 219, 26);
		desktopPane.add(lblObjectsFoundOn);
		
		JLabel lblCaseType = new JLabel("* Case Type");
		lblCaseType.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblCaseType.setBounds(61, 237, 150, 15);
		desktopPane.add(lblCaseType);
		
		JLabel lblOtherDetails = new JLabel("* Other Details");
		lblOtherDetails.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblOtherDetails.setBounds(61, 275, 150, 15);
		desktopPane.add(lblOtherDetails);
		
		textField = new JTextField();
		textField.setBounds(276, 45, 228, 19);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(276, 83, 228, 19);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(276, 126, 114, 19);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDdmmyyyy = new JLabel("DD/MM/YYYY");
		lblDdmmyyyy.setFont(new Font("Chilanka", Font.PLAIN, 11));
		lblDdmmyyyy.setBounds(405, 128, 99, 15);
		desktopPane.add(lblDdmmyyyy);
		
		textField_3 = new JTextField();
		textField_3.setBounds(276, 158, 228, 19);
		desktopPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(276, 191, 228, 19);
		desktopPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(276, 227, 114, 24);
		desktopPane.add(comboBox);
		comboBox.addItem("Select one");

		comboBox.addItem("Accident");

		comboBox.addItem("Crime");

		comboBox.addItem("Other");

		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setForeground(Color.GRAY);
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(276, 273, 228, 62);
		desktopPane.add(textArea);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String firId = textField.getText();
				String caseId = textField_1.getText();
				String dateEnter = textField_2.getText();
				String place = textField_3.getText();
				String objects = textField_4.getText();
				String type = comboBox.getSelectedItem().toString();
				String details = textArea.getText();
				
				try {
					if(db.create_case(caseId, firId, dateEnter, place, objects, type, details)) {
						JOptionPane.showMessageDialog(frmOfficerCase.getContentPane() , "Case created!");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frmOfficerCase.getContentPane() , "Server Error: Case already exists with id : "+ caseId);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Chilanka", Font.BOLD, 13));
		btnSubmit.setBounds(276, 347, 117, 25);
		desktopPane.add(btnSubmit);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		tabbedPane.addTab("Search Case", null, desktopPane_1, null);
		
		JLabel lblHelloUser = new JLabel("* Hello user you can now search cases with CASE-ID.");
		lblHelloUser.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblHelloUser.setForeground(Color.BLUE);
		lblHelloUser.setBounds(277, 93, 524, 15);
		desktopPane_1.add(lblHelloUser);
		
		JLabel lblEnterCaseid = new JLabel("* Enter CASE-ID");
		lblEnterCaseid.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblEnterCaseid.setBounds(283, 149, 176, 15);
		desktopPane_1.add(lblEnterCaseid);
		
		textField_5 = new JTextField();
		textField_5.setBounds(477, 145, 215, 19);
		desktopPane_1.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String caseId = textField_5.getText();
				try {
					rs = db.search_case(caseId);
					if(!rs.next()) {
						JOptionPane.showMessageDialog(frmOfficerCase.getContentPane() , "Case not found!");
						rs.first();
					}else {
						frmOfficerCase.setVisible(false);
						CaseDisplay.main(null);
					}
					/* TODO */
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frmOfficerCase.getContentPane() , "Error: Case not found!");
					e.printStackTrace();
				}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.BLUE);
		btnSearch.setFont(new Font("Chilanka", Font.BOLD, 13));
		btnSearch.setBounds(487, 176, 117, 25);
		desktopPane_1.add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("caseimage");
		lblNewLabel.setBounds(12, 64, 257, 212);
		desktopPane_1.add(lblNewLabel);
		Image im = new ImageIcon(this.getClass().getResource("/case.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(im));
		
		frmOfficerCase.setTitle("Officer case");
		frmOfficerCase.setBounds(100, 100, 1330, 560);
		frmOfficerCase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
