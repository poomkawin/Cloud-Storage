package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cGui {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnRegister;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cGui window = new cGui();
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
	public cGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setUIFont (new javax.swing.plaf.FontUIResource("Segoe UI", Font.PLAIN, 16));
		frame = new JFrame();
//		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setFont(null);
		frame.setBounds(100, 100, 310, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		txtUsername = new JTextField();
		txtUsername.setBounds(106, 27, 178, 29);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 67, 177, 29);
		frame.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setBounds(10, 28, 86, 26);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(11, 68, 86, 26);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(emptyBorder);
		btnLogin.setFocusPainted(false);
		btnLogin.setBackground(new Color(46, 204, 113));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(10, 129, 274, 40);
		frame.getContentPane().add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.setBorder(emptyBorder);
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFocusPainted(false);
		btnRegister.setBackground(new Color(231, 76, 60));
		btnRegister.setBounds(10, 195, 274, 40);
		frame.getContentPane().add(btnRegister);
	}
	
	public static void setUIFont (javax.swing.plaf.FontUIResource f){
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get (key);
			if (value != null && value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put (key, f);
		}
	}
}
