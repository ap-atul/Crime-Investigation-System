package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.CrimeDB_Functions;
import DB.PrinterTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.SystemColor;

public class FIRdisplay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FIRdisplay frame = new FIRdisplay();
					frame.setVisible(true);
					frame.setSize(700,800);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FIRdisplay() {
		setTitle("FIR Found");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(-26, -24, 726, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCrimeInvestigation = new JLabel("CRIME INVESTIGATION");
		lblCrimeInvestigation.setForeground(new Color(255, 255, 255));
		lblCrimeInvestigation.setFont(new Font("Chilanka", Font.BOLD, 25));
		lblCrimeInvestigation.setBounds(240, 29, 307, 47);
		panel.add(lblCrimeInvestigation);
		
		JPanel printPanel = new JPanel();
		printPanel.setBounds(10, 53, 573, 407);
		contentPane.add(printPanel);
		printPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PrinterTask.printComponent(printPanel, true);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 139));
		btnNewButton.setForeground(new Color(255, 255, 240));
		btnNewButton.setFont(new Font("Chilanka", Font.BOLD, 13));
		btnNewButton.setBounds(290, 471, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnBackSearch = new JButton("Back search");
		btnBackSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OfficerHome.main(null);
				contentPane.setVisible(false);
				
			}
		});
		btnBackSearch.setForeground(new Color(255, 255, 240));
		btnBackSearch.setFont(new Font("Chilanka", Font.BOLD, 13));
		btnBackSearch.setBackground(new Color(0, 0, 139));
		btnBackSearch.setBounds(137, 469, 117, 25);
		contentPane.add(btnBackSearch);
		
		JLabel label = new JLabel("* FIR ID");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(401, 71, 70, 15);
		printPanel.add(label);
		
		JLabel label_1 = new JLabel("* Police Station Name ");
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("Dialog", Font.BOLD, 13));
		label_1.setBounds(10, 68, 174, 21);
		printPanel.add(label_1);
		
		JLabel label_2 = new JLabel("* Subject");
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(10, 169, 80, 15);
		printPanel.add(label_2);
		
		JLabel label_3 = new JLabel("* Complaint under ACT");
		label_3.setForeground(new Color(0, 0, 128));
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		label_3.setBounds(10, 136, 174, 15);
		printPanel.add(label_3);
		
		JLabel label_4 = new JLabel("* Name ");
		label_4.setForeground(new Color(0, 0, 128));
		label_4.setFont(new Font("Dialog", Font.BOLD, 13));
		label_4.setBounds(10, 109, 70, 15);
		printPanel.add(label_4);
		
		JLabel label_5 = new JLabel("* Address");
		label_5.setForeground(new Color(0, 0, 128));
		label_5.setFont(new Font("Dialog", Font.BOLD, 13));
		label_5.setBounds(10, 208, 154, 15);
		printPanel.add(label_5);
		
		JLabel label_6 = new JLabel("* City Area");
		label_6.setForeground(new Color(0, 0, 128));
		label_6.setFont(new Font("Dialog", Font.BOLD, 13));
		label_6.setBounds(10, 249, 126, 15);
		printPanel.add(label_6);
		
		JLabel label_7 = new JLabel("* Phone");
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setFont(new Font("Dialog", Font.BOLD, 13));
		label_7.setBounds(401, 249, 70, 15);
		printPanel.add(label_7);
		
		JLabel label_8 = new JLabel("* Email ");
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("Dialog", Font.BOLD, 13));
		label_8.setBounds(10, 296, 70, 15);
		printPanel.add(label_8);
		
		JLabel label_9 = new JLabel("* Details");
		label_9.setForeground(new Color(0, 0, 128));
		label_9.setFont(new Font("Dialog", Font.BOLD, 13));
		label_9.setBounds(10, 336, 70, 15);
		printPanel.add(label_9);
		
		JLabel policestationName = new JLabel("");
		policestationName.setBounds(196, 68, 183, 15);
		printPanel.add(policestationName);
		
		JLabel Dname = new JLabel("");
		Dname.setBounds(206, 109, 289, 15);
		printPanel.add(Dname);
		
		JLabel ACT = new JLabel("");
		ACT.setBounds(196, 136, 183, 15);
		printPanel.add(ACT);
		
		JLabel subject = new JLabel("");
		subject.setBounds(206, 169, 265, 15);
		printPanel.add(subject);
		
		JLabel address = new JLabel("");
		address.setBounds(206, 208, 373, 15);
		printPanel.add(address);
		
		JLabel cityarea = new JLabel("");
		cityarea.setBounds(209, 247, 180, 15);
		printPanel.add(cityarea);
		
		JLabel email = new JLabel("");
		email.setBounds(201, 294, 206, 15);
		printPanel.add(email);
		
		JLabel details = new JLabel("");
		details.setBounds(201, 334, 378, 15);
		printPanel.add(details);
		
		JLabel phone = new JLabel("");
		phone.setBounds(491, 247, 126, 15);
		printPanel.add(phone);
		
		JLabel firid = new JLabel("");
		firid.setBounds(491, 68, 126, 15);
		printPanel.add(firid);
		
		JLabel label_20 = new JLabel("* Date");
		label_20.setForeground(SystemColor.activeCaption);
		label_20.setFont(new Font("Dialog", Font.BOLD, 13));
		label_20.setBounds(401, 20, 70, 15);
		printPanel.add(label_20);
		
		JLabel date = new JLabel("");
		date.setBounds(491, 18, 70, 15);
		printPanel.add(date);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(10, 11, 294, 45);
		printPanel.add(panel_2);
		
		JLabel label_22 = new JLabel("    First Information Report");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Dialog", Font.BOLD, 19));
		label_22.setBackground(new Color(0, 0, 128));
		label_22.setBounds(0, 0, 322, 45);
		panel_2.add(label_22);
		
		
		ResultSet rs = OfficerHome.rs;
		try {
			firid.setText(rs.getString("firId"));
			policestationName.setText(rs.getString("policeStationName"));
			Dname.setText(rs.getString("name"));
			ACT.setText(rs.getString("act"));
			subject.setText(rs.getString("title"));
			address.setText(rs.getString("address"));
			cityarea.setText(rs.getString("city"));
			email.setText(rs.getString("email"));
			details.setText(rs.getString("details"));
			date.setText(rs.getString("dateAdded"));
			phone.setText(rs.getString("mobile"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CrimeDB_Functions db = new CrimeDB_Functions();
					db.delete_fir(firid.getText());
					JOptionPane.showMessageDialog(contentPane , "FIR deleted successfully!");
					contentPane.setVisible(false);
					OfficerHome.main(null);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(contentPane , "Problem deleting FIR!");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(0, 0, 139));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(436, 469, 117, 25);
		contentPane.add(btnNewButton_2);
	}
}
