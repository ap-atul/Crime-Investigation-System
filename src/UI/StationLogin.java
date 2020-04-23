package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import DB.CrimeDB_Functions;

public class StationLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static StationLogin frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StationLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public StationLogin() throws ClassNotFoundException, SQLException {

		CrimeDB_Functions db = new CrimeDB_Functions();
		
		setBackground(Color.WHITE);
		setFont(new Font("Chandas", Font.BOLD, 14));
		setTitle("Crime Investigation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 340);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBox.focus"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Police Station Login");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(227, 12, 196, 29);
		lblNewLabel.setFont(new Font("Chilanka", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(305, 90, 98, 15);
		lblUsername.setFont(new Font("Chilanka", Font.BOLD, 13));
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Chilanka", Font.BOLD, 13));
		lblNewLabel_1.setBounds(305, 142, 79, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(408, 88, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(408, 140, 114, 19);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = textField.getText();
				char[] pass = passwordField.getPassword();
				String password = new String(pass);
				
				try {
					if(db.police_station_login(username, password)) {
						Home.main(null);
						frame.setVisible(false);
						contentPane.setVisible(false);
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Invalid Credentials");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, "Server not responding");
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(374, 198, 73, 25);
		btnLogin.setBorder(new RoundedBorder(15));
		btnLogin.setBackground(new Color(102, 163, 255));
		
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel();
		Image im = new ImageIcon(this.getClass().getResource("/police.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(im));
		
		lblNewLabel_2.setBounds(28, 53, 260, 224);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }


	
}