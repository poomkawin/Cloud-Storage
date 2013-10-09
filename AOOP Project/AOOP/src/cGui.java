import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;


public class cGui {

	private JFrame frmLogIn;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cGui window = new cGui();
					window.frmLogIn.setVisible(true);
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
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In / Register");
		frmLogIn.setBounds(100, 100, 600, 200);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(112, 6, 134, 28);
		frmLogIn.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 45, 134, 28);
		frmLogIn.getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Balsamiq Sans", lblUsername.getFont().getStyle(), lblUsername.getFont().getSize() + 3));
		lblUsername.setBounds(17, 12, 83, 16);
		frmLogIn.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(17, 51, 83, 16);
		frmLogIn.getContentPane().add(lblPassword);
	}
}
