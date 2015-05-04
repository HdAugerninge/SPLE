package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Model.Person;
import Model.Variance;
import Model.mock.MockResources;

public class Login extends JFrame {

	private JPanel contentPane;
	private JList<Person> peopleList;

	public Login() {
		WindowListener windowsListener = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					// Variationspunkt einbringen
					Files.deleteIfExists(Paths.get(System
							.getProperty("java.io.tmpdir")
							+ File.separator
							+ "messagepipe.bin"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {
			}
		};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		peopleList = new JList<Person>();

		peopleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		peopleList.setLayoutOrientation(JList.VERTICAL_WRAP);
		peopleList.setVisibleRowCount(-1);
		DefaultListModel<Person> listModel = new DefaultListModel<Person>();
		MockResources.PERSONS.forEach((person) -> listModel.addElement(person));
		contentPane.setLayout(null);
		peopleList.setModel(listModel);
		peopleList.setBounds(5, 5, 439, 227);
		contentPane.add(peopleList);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(164, 244, 117, 29);
		contentPane.add(btnLogin);

		btnLogin.addActionListener((event) -> {

			this.setVisible(false);

			Variance var = new Variance();

			if (var.hasAuthentification()) {
				JOptionPane.showInputDialog(null, "Bitte Passwort eingeben",
						"Passwort benötigt", JOptionPane.INFORMATION_MESSAGE);

			}
			Gui window = new Gui(peopleList.getSelectedValue());
			window.init();
			window.frame.addWindowListener(windowsListener);

		});
		this.addWindowListener(windowsListener);
	}
}
