package com.riceclient.launcher.api.gui;

import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

import com.riceclient.launcher.api.Launcher;

@SuppressWarnings("serial")
public abstract class ImGui extends JFrame implements ActionListener {
	
	private final Launcher launcher;
	
	public ImGui(Launcher launcher) {
		this.launcher = launcher;
	}
	
	public void setUp() {
		this.setResizable(false);
		
		this.init();
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	protected void startClient(String jar) {
		this.launcher.setJar(jar);
		this.launcher.run();
	}
	
	protected void displayScreen(String title, int width, int height, boolean undecorated) {
		this.setTitle(title);
		Container container = this.getContentPane();
		container.setLayout(null);
		container.setPreferredSize(new Dimension(width, height));
		this.setUndecorated(undecorated);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	protected void displayCustomDecoration() {
		this.displayCustomDecoration(30, Color.white);
	}
	
	protected void displayCustomDecoration(int height) {
		this.displayCustomDecoration(height, Color.white);
	}
	
	protected void displayCustomDecoration(int height, Color color) {
		JPanel jpanel = new JPanel();
		jpanel.setBounds(0, 0, 355, height);
		jpanel.setBackground(color);
		this.add(jpanel);
	}
	
	protected JButton createNewButton(String buttonText, int posX, int posY, int width, int height, boolean borderPainted, boolean focusPainted, Color foregroundColor, Color backgroundColor) {
		JButton button = new JButton(buttonText);
		button.setBounds(posX, posY, width, height);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBackground(backgroundColor);
		button.setForeground(foregroundColor);
		button.addActionListener(this);
		this.add(button);
		return button;
	}
	
	protected JComboBox<String> createNewChoiceBox(int posX, int posY, int width, int height, String... choices){
		JComboBox<String> comboBox = new JComboBox<String>();
		for(int i = 0; i < choices.length; i++) {
			comboBox.addItem(choices[i]);
		}
		comboBox.setBounds(posX, posY, width, height);
		this.add(comboBox);
		return comboBox;
	}
	
	protected JMenu[] createNewJMenuBar(JMenu... menus) {
		JMenuBar menuBar = new JMenuBar();
		for(int i = 0; i < menus.length; i++) {
			JMenu menu = menus[i];
			menuBar.add(menu);
			for(int j = 0; menu.getItemCount() > 0 && j < menu.getItemCount(); j++) {
				menu.getItem(j).addActionListener(this);
			}
		}
		this.setJMenuBar(menuBar);
		return menus;
	}
	
	protected URL getResource(String name) {
		return this.getClass().getResource(name);
	}
	
	protected Launcher getLauncher() {
		return launcher;
	}
	
	protected abstract void init();
}
