package view;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import controller.MainController;
import model.Save;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class MainView {

	private JFrame frame;
	private JLabel keybindLabel;
	public int keybind;
	
	/**
	 * Launch the application.
	 */
	public void Run() {
		
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}
	
	public void setKeyBind(int keybind) {
		System.out.println("Save Keybind: " + keybind);
		this.keybind = keybind;
		keybindLabel.setText("<html>\r\n<center>\r\nCurrent Key Bind: " + keybind + "\r\n</center>\r\n</html>");
		System.out.println("Test - Save Keybind: " + keybind);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("Quick Discord Search");
		frame.setResizable(false);
		frame.setBounds(100, 100, 300, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton keybindButton = new JButton("<html>\r\n<center>\r\nClick on this button to \r\n<br/>change the key bind\r\n</center>\r\n</html>");
		keybindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		keybindButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		keybindButton.setBounds(10, 10, 260, 60);
		panel.add(keybindButton);
		
		keybindLabel = new JLabel("<html>\r\n<center>\r\nCurrent Key Bind: " + keybind + "\r\n</center>\r\n</html>");
		keybindLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		keybindLabel.setBounds(10, 80, 276, 13);
		panel.add(keybindLabel);
		
		panel.requestFocus();
		frame.setVisible(true);
	}
}
