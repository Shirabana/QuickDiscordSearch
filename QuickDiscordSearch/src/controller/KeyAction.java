package controller;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.*;

import model.Save;
import view.MainView;

public class KeyAction implements NativeKeyListener {
	
	private Save save;
	private MainController mc;
	private int keybind;
	
	public void setSave(Save save) {
		this.save = save;
	}
	
	public void setKeybind(int keybind) {
		this.keybind = keybind;
	}
	
	public void KeyRun() {
		
		// Get the logger for "org.jnativehook" and set the level to warning.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);

		// Don't forget to disable the parent handlers.
		logger.setUseParentHandlers(false);
		
		// Adding global key listener
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException e) {
			e.printStackTrace();
			System.exit(1);
		}

		try {
			GlobalScreen.addNativeKeyListener(new KeyAction());
		}
		catch (StackOverflowError soe) {
			soe.printStackTrace();
			try {
				GlobalScreen.unregisterNativeHook();
			} 
			catch (NativeHookException e) {
				e.printStackTrace();
			}
			System.exit(1);
		}
	}
	
	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		String documentsPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
		String directoryPath = documentsPath + "/QuickDiscordSearch/";
		String filePath = directoryPath + "keybind.txt";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			keybind = Integer.parseInt(reader.readLine());
			reader.close();
		}
		catch (IOException io) {
			io.printStackTrace();
		}
		
		System.out.println("Key: " + e.getKeyCode() + " | Bind: " + keybind);
		
		if (e.getKeyCode() == keybind) {
			try {
				// Cannot call awt.robot normally from swing so a new thread has to be made
				new Thread(() -> {
		            try {
						new MainController();
		            } 
		            catch (Exception d) {
		                d.printStackTrace();
		            }
		        }).start();
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
