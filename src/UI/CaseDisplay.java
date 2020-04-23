package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.CrimeDB_Functions;
import DB.PrinterTask;

import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class CaseDisplay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaseDisplay frame = new CaseDisplay();
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
	public CaseDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 696);
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
		
		JButton button = new JButton("Back search");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane.setVisible(false);
				Officercase.main(null);
			}
		});
		button.setForeground(new Color(255, 255, 240));
		button.setFont(new Font("Chilanka", Font.BOLD, 13));
		button.setBackground(new Color(0, 0, 139));
		button.setBounds(162, 396, 117, 25);
		contentPane.add(button);
		
		JPanel printPanel = new JPanel();
		printPanel.setBounds(0, 50, 590, 335);
		contentPane.add(printPanel);
		printPanel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 0, 236, 45);
		printPanel.add(panel_2);
		
		JLabel label = new JLabel("        CASE REPORT");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 19));
		label.setBackground(new Color(0, 0, 128));
		label.setBounds(0, 0, 244, 45);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("* Date");
		label_1.setForeground(SystemColor.activeCaption);
		label_1.setFont(new Font("Dialog", Font.BOLD, 13));
		label_1.setBounds(381, 14, 70, 15);
		printPanel.add(label_1);
		
		JLabel label_2 = new JLabel("* FIR ID");
		label_2.setForeground(SystemColor.activeCaption);
		label_2.setFont(new Font("Dialog", Font.BOLD, 13));
		label_2.setBounds(381, 73, 70, 15);
		printPanel.add(label_2);
		
		JLabel label_3 = new JLabel("* Case Id");
		label_3.setForeground(SystemColor.activeCaption);
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		label_3.setBounds(47, 71, 70, 15);
		printPanel.add(label_3);
		
		JLabel label_4 = new JLabel("* Incident Place");
		label_4.setForeground(SystemColor.activeCaption);
		label_4.setFont(new Font("Dialog", Font.BOLD, 13));
		label_4.setBounds(47, 125, 124, 15);
		printPanel.add(label_4);
		
		JLabel label_5 = new JLabel("* Objects Found");
		label_5.setForeground(SystemColor.activeCaption);
		label_5.setFont(new Font("Dialog", Font.BOLD, 13));
		label_5.setBounds(47, 180, 124, 15);
		printPanel.add(label_5);
		
		JLabel label_6 = new JLabel("* CrimeType");
		label_6.setForeground(SystemColor.activeCaption);
		label_6.setFont(new Font("Dialog", Font.BOLD, 13));
		label_6.setBounds(47, 240, 124, 15);
		printPanel.add(label_6);
		
		JLabel label_7 = new JLabel("* Other Details");
		label_7.setForeground(SystemColor.activeCaption);
		label_7.setFont(new Font("Dialog", Font.BOLD, 13));
		label_7.setBounds(47, 283, 124, 15);
		printPanel.add(label_7);
		
		JLabel place = new JLabel("");
		place.setBounds(178, 126, 150, 14);
		printPanel.add(place);
		
		JLabel objects = new JLabel("");
		objects.setBounds(183, 169, 236, 45);
		printPanel.add(objects);
		
		JLabel typeCrime = new JLabel("");
		typeCrime.setBounds(178, 241, 150, 14);
		printPanel.add(typeCrime);
		
		JLabel details = new JLabel("");
		details.setBounds(181, 269, 369, 55);
		printPanel.add(details);
		
		JLabel firId = new JLabel("");
		firId.setBounds(437, 74, 150, 14);
		printPanel.add(firId);
		
		JLabel dateEnter = new JLabel("");
		dateEnter.setBounds(437, 15, 150, 14);
		printPanel.add(dateEnter);
		
		JLabel caseId = new JLabel((String) null);
		caseId.setBounds(127, 74, 150, 14);
		printPanel.add(caseId);
		
		ResultSet rs = Officercase.rs;
		try {
			caseId.setText(rs.getString("caseId"));
			place.setText(rs.getString("place"));
			objects.setText(rs.getString("objects"));
			typeCrime.setText(rs.getString("typeOfCrime"));
			details.setText(rs.getString("details"));
			firId.setText(rs.getString("firId"));
			dateEnter.setText(rs.getString("dateEnter"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton button_2 = new JButton("Delete");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CrimeDB_Functions db = new CrimeDB_Functions();
					db.delete_case(caseId.getText());
					JOptionPane.showMessageDialog(contentPane , "Case deleted successfully!");
					contentPane.setVisible(false);
					Officercase.main(null);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(contentPane , "Problem deleting case!");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 0, 139));
		button_2.setBounds(483, 394, 117, 25);
		contentPane.add(button_2);
		
		
		JButton button_1 = new JButton("Print");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PrinterTask.printComponent(printPanel, true);
					JOptionPane.showMessageDialog(contentPane , "Case printed successfully!");
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setForeground(new Color(255, 255, 240));
		button_1.setFont(new Font("Chilanka", Font.BOLD, 13));
		button_1.setBackground(new Color(0, 0, 139));
		button_1.setBounds(332, 394, 117, 25);
		contentPane.add(button_1);
		
	}
}
