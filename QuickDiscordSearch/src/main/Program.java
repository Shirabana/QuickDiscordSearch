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
	
	private Save save;
	
	public static void main(String[] args) {
		
		Save sav = new Save();
		
		try {
			String documentsPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
			String directoryPath = documentsPath + "/QuickDiscordSearch/";
			new File(directoryPath).mkdirs();
			
			String filePath = directoryPath + "keybind.txt";
			
			if (!(new File(filePath).exists())) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
				writer.write("43");
				writer.close();
			}
			else {
				BufferedReader reader = new BufferedReader(new FileReader(filePath));
				sav.setKeyBind(Integer.parseInt(reader.readLine()));
				reader.close();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
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
			}
		});
		
	}
	
}
