package com.riceclient.launcher.api;

import com.riceclient.launcher.api.thread.ClientThread;

/**
 * @author XiaoBen
 */
public abstract class Launcher {
	
	private Thread thread;
	
	private String jar;
	
	public abstract void run();
	
	protected void launchClient(Configuration config) {
		this.thread = new Thread(new ClientThread(config));
		this.thread.start();
	}
	
	public String setJar(String jar) {
		return this.jar = jar;
	}
	
	public String getJar() {
		return jar;
	}
	
}
