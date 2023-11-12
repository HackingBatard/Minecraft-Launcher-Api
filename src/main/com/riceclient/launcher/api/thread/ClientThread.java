package com.riceclient.launcher.api.thread;

import java.io.*;

import com.riceclient.launcher.api.Configuration;

public class ClientThread implements Runnable {
	
	private Configuration config;
	
	public ClientThread(Configuration config) {
		this.config = config;
	}

	@Override
	public void run() {
		try {
			this.config.setUp();
			
			Process process = Runtime.getRuntime().exec("java " + this.config.getArgs());
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			String s = null;
			while((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
			while((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
}
