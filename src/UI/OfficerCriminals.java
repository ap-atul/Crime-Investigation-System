package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import DB.CrimeDB_Functions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class OfficerCriminals {

	private JFrame frmCriminals;
	private JTextField criminalId;
	private JTextField name;
	private JTextField address;
	private JTextField city;
	private JTextField dateArrest;
	private JTextField dateBirth;
	private JTextField occupation;
	private JTextField act;
	private JTextField place;
	private JTextField dateRelease;
	private JTextField height;
	private JTextField weight;
	private JTextField textField_12;
	public CrimeDB_Functions db;
	public static ResultSet rs;
	public BufferedImage bn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfficerCriminals window = new OfficerCriminals();
					window.frmCriminals.setVisible(true);
					window.frmCriminals.setSize(1650,1080);
					window.frmCriminals.setLocationRelativeTo(null);
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
	public OfficerCriminals() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		db = new CrimeDB_Functions();
		frmCriminals = new JFrame();
		frmCriminals.getContentPane().setBackground(Color.WHITE);
		frmCriminals.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(0, -105, 300, 1080);
		frmCriminals.getContentPane().add(panel);
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
		
		JLabel label_1 = new JLabel("* FIR");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfficerHome.main(null);
				frmCriminals.setVisible(false);
				
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Chilanka", Font.BOLD, 14));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(36, 249, 99, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("* Criminals");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Chilanka", Font.BOLD, 14));
		label_2.setBounds(36, 285, 139, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("* Cases");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Officercase.main(null);
				frmCriminals.setVisible(false);

				
			}
		});
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Chilanka", Font.BOLD, 14));
		label_3.setBounds(36, 325, 70, 15);
		panel.add(label_3);
		
		JLabel lblLogOut = new JLabel("Log out");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Officerlogin.main(null);
				JOptionPane.showMessageDialog(frmCriminals, "Succesfully Logout.");

				frmCriminals.setVisible(false);

			}
		});
		lblLogOut.setToolTipText("Bck to Police login?");
		lblLogOut.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblLogOut.setBounds(1266, 12, 70, 15);
		frmCriminals.getContentPane().add(lblLogOut);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("Menu.acceleratorForeground"));
		tabbedPane.setBounds(353, 12, 895, 600);
		frmCriminals.getContentPane().add(tabbedPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Add Criminal", null, desktopPane, null);
		
		JLabel lblCriminalId = new JLabel("* Criminal ID");
		lblCriminalId.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblCriminalId.setBounds(40, 33, 122, 15);
		desktopPane.add(lblCriminalId);
		
		JLabel lblName = new JLabel("* Name");
		lblName.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblName.setBounds(40, 72, 70, 15);
		desktopPane.add(lblName);
		
		JLabel lblAddress = new JLabel("* Address");
		lblAddress.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblAddress.setBounds(40, 107, 122, 15);
		desktopPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("* City");
		lblCity.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblCity.setBounds(40, 146, 70, 15);
		desktopPane.add(lblCity);
		
		JLabel lblMari = new JLabel("* Marital Status");
		lblMari.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblMari.setBounds(40, 183, 122, 15);
		desktopPane.add(lblMari);
		
		JLabel lblHeight = new JLabel("* Height");
		lblHeight.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblHeight.setBounds(479, 219, 70, 15);
		desktopPane.add(lblHeight);
		
		JLabel lblWeight = new JLabel("* Weight");
		lblWeight.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblWeight.setBounds(303, 217, 70, 15);
		desktopPane.add(lblWeight);
		
		JLabel lblGender = new JLabel("* Gender");
		lblGender.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblGender.setBounds(40, 217, 106, 15);
		desktopPane.add(lblGender);
		
		JLabel lblDateOf = new JLabel("* Date Of Arrest");
		lblDateOf.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblDateOf.setBounds(40, 257, 122, 15);
		desktopPane.add(lblDateOf);
		
		JLabel lblDateOf_1 = new JLabel("* Date Of Release");
		lblDateOf_1.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblDateOf_1.setBounds(479, 257, 132, 15);
		desktopPane.add(lblDateOf_1);
		
		JLabel lblDateOf_2 = new JLabel("* Date Of Birth");
		lblDateOf_2.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblDateOf_2.setBounds(40, 294, 122, 15);
		desktopPane.add(lblDateOf_2);
		
		JLabel lblBirthPlace = new JLabel("* Birth Place");
		lblBirthPlace.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblBirthPlace.setBounds(479, 294, 112, 15);
		desktopPane.add(lblBirthPlace);
		
		JLabel lblOccupation = new JLabel("* Occupation");
		lblOccupation.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblOccupation.setBounds(40, 335, 122, 15);
		desktopPane.add(lblOccupation);
		
		JLabel lblArrestedUnder = new JLabel("* Arrested under ACT");
		lblArrestedUnder.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblArrestedUnder.setBounds(40, 369, 170, 15);
		desktopPane.add(lblArrestedUnder);
		
		
		criminalId = new JTextField();
		criminalId.setBounds(180, 29, 179, 19);
		desktopPane.add(criminalId);
		criminalId.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(180, 70, 179, 19);
		desktopPane.add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(180, 103, 179, 19);
		desktopPane.add(address);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(180, 142, 179, 19);
		desktopPane.add(city);
		
		dateArrest = new JTextField();
		dateArrest.setColumns(10);
		dateArrest.setBounds(180, 246, 179, 19);
		desktopPane.add(dateArrest);
		
		dateBirth = new JTextField();
		dateBirth.setColumns(10);
		dateBirth.setBounds(180, 292, 179, 19);
		desktopPane.add(dateBirth);
		
		occupation = new JTextField();
		occupation.setColumns(10);
		occupation.setBounds(180, 331, 179, 19);
		desktopPane.add(occupation);
		
		act = new JTextField();
		act.setColumns(10);
		act.setBounds(229, 365, 179, 19);
		desktopPane.add(act);
		
		place = new JTextField();
		place.setColumns(10);
		place.setBounds(630, 290, 179, 19);
		desktopPane.add(place);
		
		dateRelease = new JTextField();
		dateRelease.setColumns(10);
		dateRelease.setBounds(630, 253, 179, 19);
		desktopPane.add(dateRelease);
		
		height = new JTextField();
		height.setColumns(10);
		height.setBounds(630, 215, 179, 19);
		desktopPane.add(height);
		
		weight = new JTextField();
		weight.setColumns(10);
		weight.setBounds(391, 215, 70, 19);
		desktopPane.add(weight);
		
		JComboBox mstatus = new JComboBox();
		mstatus.setBounds(180, 176, 116, 24);
		mstatus.addItem("select one");
		mstatus.addItem("Married");
		mstatus.addItem("Unmarried");
		desktopPane.add(mstatus);
		
		
		JComboBox gender = new JComboBox();
		gender.setBounds(180, 212, 116, 24);
		gender.addItem("select one");
		gender.addItem("Male");
		gender.addItem("Female");
		
		gender.addItem("Other");
		desktopPane.add(gender);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		tabbedPane.addTab("Search Criminal", null, desktopPane_1, null);
		
		JLabel lblHelloUser = new JLabel("* Hello user You can search Criminals stored among the Database .");
		lblHelloUser.setForeground(Color.GREEN);
		lblHelloUser.setFont(new Font("Chilanka", Font.BOLD, 14));
		lblHelloUser.setBackground(Color.GREEN);
		lblHelloUser.setBounds(43, 78, 517, 15);
		desktopPane_1.add(lblHelloUser);
		
		JLabel userProfile = new JLabel("");
		userProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userProfile.setForeground(Color.WHITE);
		userProfile.setText(Officerlogin.userProfile);
		userProfile.setBounds(36, 758, 214, 31);
		panel.add(userProfile);
		
		JLabel lblEnterCriminalId = new JLabel("Enter Criminal ID ");
		lblEnterCriminalId.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblEnterCriminalId.setBounds(43, 136, 146, 15);
		desktopPane_1.add(lblEnterCriminalId);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(212, 132, 179, 19);
		desktopPane_1.add(textField_12);
		
		JButton button = new JButton("Search");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String criminalId = textField_12.getText();
				try {
					rs = db.search_criminal(criminalId);
					if(rs.next()) {
						CriminalDisplay.main(null);
						frmCriminals.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(frmCriminals , "Criminal does not exists!");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmCriminals , "Criminal does not exists!");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLUE);
		button.setBounds(434, 129, 117, 25);
		desktopPane_1.add(button);

		
		
		frmCriminals.setTitle("Criminals");
		frmCriminals.setBounds(100, 100, 1366, 559);
		frmCriminals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String criminalID = criminalId.getText();
				String Name = name.getText();
				String addres = address.getText();
				String City = city.getText();
				String status = mstatus.getSelectedItem().toString();
				String Gender = gender.getSelectedItem().toString();
				String wei = weight.getText();
				String hei = height.getText();
				String dateA = dateArrest.getText();
				String dateR = dateRelease.getText();
				String dateB = dateBirth.getText();
				String bplace = place.getText();
				String occ = occupation.getText();
				String Act = act.getText();
				
				try {
					db = new CrimeDB_Functions();
					if(db.create_criminal(criminalID, Name, addres, City, status, Gender, wei, hei, dateA, dateR, dateB, bplace, occ, Act)) {
						File outputfile = new File("./criminals/" + criminalId.getText() + ".jpg");
						ImageIO.write(bn, "jpg", outputfile); 
						JOptionPane.showMessageDialog(frmCriminals , "Criminal added successfully!");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frmCriminals , "Criminal cannot be added, ID already exists!");
					e1.printStackTrace();
				}catch (IOException e1) {
					JOptionPane.showMessageDialog(frmCriminals, "Image upload failed!");
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(195, 418, 117, 25);
		desktopPane.add(btnNewButton);
		
		JLabel lblAddImage = new JLabel("Add image");
		lblAddImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser filechooser = new JFileChooser();
			    filechooser.setDialogTitle("Choose Your File");
			    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    // below code selects the file 
			    int returnval = filechooser.showOpenDialog(lblAddImage);
			    if (returnval == JFileChooser.APPROVE_OPTION)
			    {
			        File file = filechooser.getSelectedFile();
			        BufferedImage bi;
			        try {
			            // display the image in a Jlabel
			            bi = ImageIO.read(file);
			            bn = scale(bi, 132, 156);
			            lblAddImage.setIcon(new ImageIcon(bn));
			            
			        } catch(IOException e1) {
			        	JOptionPane.showMessageDialog(frmCriminals, "Image upload failed!");
			           e1.printStackTrace(); 
			        }
			    }
			}
			public BufferedImage scale(BufferedImage src, int w, int h)
			{
			    BufferedImage img = 
			            new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			    int x, y;
			    int ww = src.getWidth();
			    int hh = src.getHeight();
			    int[] ys = new int[h];
			    for (y = 0; y < h; y++)
			        ys[y] = y * hh / h;
			    for (x = 0; x < w; x++) {
			        int newX = x * ww / w;
			        for (y = 0; y < h; y++) {
			            int col = src.getRGB(newX, ys[y]);
			            img.setRGB(x, y, col);
			        }
			    }
			    return img;
			}
		});
		
		lblAddImage.setBounds(526, 29, 132, 146);
		desktopPane.add(lblAddImage);
	}
}
