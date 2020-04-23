package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;

import DB.CrimeDB_Functions;
import DB.PrinterTask;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CriminalDisplay {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriminalDisplay window = new CriminalDisplay();
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
	public CriminalDisplay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 726, 66);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("CRIME INVESTIGATION");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 25));
		label.setBounds(240, 29, 307, 47);
		panel.add(label);
		
		JPanel printPanel = new JPanel();
		printPanel.setBounds(46, 90, 667, 485);
		frame.getContentPane().add(printPanel);
		printPanel.setLayout(null);
		
		JLabel lblCriminalReport = new JLabel("            Criminal Report");
		lblCriminalReport.setBounds(10, 11, 322, 45);
		printPanel.add(lblCriminalReport);
		lblCriminalReport.setForeground(Color.WHITE);
		lblCriminalReport.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCriminalReport.setBackground(new Color(0, 0, 128));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 294, 45);
		printPanel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		
		JLabel label_1 = new JLabel("* Criminal ID");
		label_1.setFont(new Font("Dialog", Font.BOLD, 13));
		label_1.setBounds(10, 88, 122, 15);
		printPanel.add(label_1);
		
		JLabel criminalId = new JLabel((String) null);
		criminalId.setBounds(142, 89, 106, 14);
		printPanel.add(criminalId);
		
		JLabel label_3 = new JLabel("* Name");
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		label_3.setBounds(10, 127, 70, 15);
		printPanel.add(label_3);
		
		JLabel name = new JLabel((String) null);
		name.setBounds(142, 128, 106, 14);
		printPanel.add(name);
		
		JLabel label_5 = new JLabel("* Address");
		label_5.setFont(new Font("Dialog", Font.BOLD, 13));
		label_5.setBounds(10, 162, 122, 15);
		printPanel.add(label_5);
		
		JLabel address = new JLabel((String) null);
		address.setBounds(142, 163, 245, 27);
		printPanel.add(address);
		
		JLabel label_7 = new JLabel("* City");
		label_7.setFont(new Font("Dialog", Font.BOLD, 13));
		label_7.setBounds(10, 201, 70, 15);
		printPanel.add(label_7);
		
		JLabel city = new JLabel((String) null);
		city.setBounds(142, 202, 106, 14);
		printPanel.add(city);
		
		JLabel label_9 = new JLabel("* Marital Status");
		label_9.setFont(new Font("Dialog", Font.BOLD, 13));
		label_9.setBounds(10, 238, 122, 15);
		printPanel.add(label_9);
		
		JLabel mstatus = new JLabel((String) null);
		mstatus.setBounds(142, 239, 106, 14);
		printPanel.add(mstatus);
		
		JLabel label_11 = new JLabel("* Gender");
		label_11.setFont(new Font("Dialog", Font.BOLD, 13));
		label_11.setBounds(10, 272, 106, 15);
		printPanel.add(label_11);
		
		JLabel gender = new JLabel((String) null);
		gender.setBounds(142, 273, 106, 14);
		printPanel.add(gender);
		
		JLabel label_13 = new JLabel("* Date Of Arrest");
		label_13.setFont(new Font("Dialog", Font.BOLD, 13));
		label_13.setBounds(10, 312, 122, 15);
		printPanel.add(label_13);
		
		JLabel dateArrest = new JLabel((String) null);
		dateArrest.setBounds(142, 313, 106, 14);
		printPanel.add(dateArrest);
		
		JLabel label_15 = new JLabel("* Date Of Birth");
		label_15.setFont(new Font("Dialog", Font.BOLD, 13));
		label_15.setBounds(10, 349, 122, 15);
		printPanel.add(label_15);
		
		JLabel dateBirth = new JLabel((String) null);
		dateBirth.setBounds(142, 350, 106, 14);
		printPanel.add(dateBirth);
		
		JLabel label_17 = new JLabel("* Occupation");
		label_17.setFont(new Font("Dialog", Font.BOLD, 13));
		label_17.setBounds(10, 390, 122, 15);
		printPanel.add(label_17);
		
		JLabel occupation = new JLabel((String) null);
		occupation.setBounds(142, 391, 106, 14);
		printPanel.add(occupation);
		
		JLabel act = new JLabel((String) null);
		act.setBounds(167, 425, 106, 14);
		printPanel.add(act);
		
		JLabel label_20 = new JLabel("* Arrested under ACT");
		label_20.setFont(new Font("Dialog", Font.BOLD, 13));
		label_20.setBounds(10, 424, 170, 15);
		printPanel.add(label_20);
		
		JLabel weight = new JLabel((String) null);
		weight.setBounds(333, 273, 106, 14);
		printPanel.add(weight);
		
		JLabel label_22 = new JLabel("* Weight");
		label_22.setFont(new Font("Dialog", Font.BOLD, 13));
		label_22.setBounds(273, 272, 70, 15);
		printPanel.add(label_22);
		
		JLabel label_23 = new JLabel("* Height");
		label_23.setFont(new Font("Dialog", Font.BOLD, 13));
		label_23.setBounds(449, 274, 70, 15);
		printPanel.add(label_23);
		
		JLabel height = new JLabel((String) null);
		height.setBounds(529, 273, 106, 14);
		printPanel.add(height);
		
		JLabel label_25 = new JLabel("* Date Of Release");
		label_25.setFont(new Font("Dialog", Font.BOLD, 13));
		label_25.setBounds(449, 312, 132, 15);
		printPanel.add(label_25);
		
		JLabel dateRelease = new JLabel((String) null);
		dateRelease.setBounds(563, 313, 106, 14);
		printPanel.add(dateRelease);
		
		JLabel bplace = new JLabel((String) null);
		bplace.setBounds(553, 350, 106, 14);
		printPanel.add(bplace);
		
		JLabel label_28 = new JLabel("* Birth Place");
		label_28.setFont(new Font("Dialog", Font.BOLD, 13));
		label_28.setBounds(449, 349, 112, 15);
		printPanel.add(label_28);
		
		JLabel image = new JLabel("Add image");
		image.setBounds(496, 84, 132, 146);
		printPanel.add(image);
		
		JButton button = new JButton("Back search");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				OfficerCriminals.main(null);
			}
		});
		button.setForeground(new Color(255, 255, 240));
		button.setFont(new Font("Dialog", Font.BOLD, 13));
		button.setBackground(new Color(0, 0, 139));
		button.setBounds(144, 603, 117, 25);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Print");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PrinterTask.printComponent(printPanel, true);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, "Error printing the report");
					e1.printStackTrace();
				}
			}
		});
		button_1.setForeground(new Color(255, 255, 240));
		button_1.setFont(new Font("Dialog", Font.BOLD, 13));
		button_1.setBackground(new Color(0, 0, 139));
		button_1.setBounds(315, 603, 117, 25);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CrimeDB_Functions db = new CrimeDB_Functions();
					if(db.delete_criminal(criminalId.getText()))
						JOptionPane.showMessageDialog(frame, "Report deleted successfuly!");
					frame.setVisible(false);
					OfficerCriminals.main(null);
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Error deleting the report");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 0, 139));
		button_2.setBounds(465, 604, 117, 25);
		frame.getContentPane().add(button_2);
		
		ResultSet rs = OfficerCriminals.rs;
		try {
			criminalId.setText(rs.getString("criminalId"));
			name.setText(rs.getString("name"));
			address.setText(rs.getString("address"));
			city.setText(rs.getString("city"));
			mstatus.setText(rs.getString("mstatus"));
			gender.setText(rs.getString("gender"));
			weight.setText(rs.getString("weight"));
			height.setText(rs.getString("height"));
			dateArrest.setText(rs.getString("dateArrest"));
			dateBirth.setText(rs.getString("dateBirth"));
			dateRelease.setText(rs.getString("dateRelease"));
			bplace.setText(rs.getString("bplace"));
			occupation.setText(rs.getString("occupation"));
			act.setText(rs.getString("act"));
			
			File file = new File("./criminals/" + rs.getString("criminalId") + ".jpg");
			BufferedImage bi = ImageIO.read(file);
			image.setIcon(new ImageIcon(bi));
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(frame, "Error finding the image");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
