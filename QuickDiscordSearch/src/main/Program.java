package main;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.filechooser.FileSystemView;

import controller.KeyAction;
import model.Save;
import view.MainView;

public class Program {
	
	private static Logger log = new Logger();
	
	public static void main(String[] args) {
		
		log.Info("Program booted.");
		
		// Initialize save model
		Save sav = new Save();
		
		FileInitialization fi = new FileInitialization();
		sav.setKeyBind(fi.Initialize());
		
		KeyAction ka = new KeyAction();
		ka.KeyRun();
		ka.setSave(sav);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.setKeyBind(sav.getKeyBind());
				} catch (Exception e) {
					e.printStackTrace();
				}
				log.Info("GUI loaded successfully.");
			}
		});
		
	}
	
}
