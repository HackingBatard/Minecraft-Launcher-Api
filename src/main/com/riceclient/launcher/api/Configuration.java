package com.riceclient.launcher.api;

import java.io.*;

import com.riceclient.launcher.api.util.*;

public abstract class Configuration {
	
	private final File mc;
	private final File storage;
	private final File assets;
	private File jar;
	
	private File natives;
	private File libraries;
	
	public Configuration(String storage, String jar, String libraries, String natives) {
		this.mc = new File(OSHelper.getOS().getMc());
		if(!this.mc.exists()) {
			this.mc.mkdirs();
		}
		this.assets = new File(this.mc, "assets");
		if(!this.assets.exists()) {
			this.assets.mkdirs();
		}
		this.storage = new File(this.mc, storage);
		if(!this.storage.exists()) {
			this.storage.mkdirs();
		}
		this.jar = new File(this.storage, jar);
		this.natives = new File(this.storage, natives);
		this.libraries = new File(this.storage, libraries);
	}

	public abstract void setUp() throws Exception;
	
	/**
	 * Returns launcher arguments, like version, libraries directory... something like that
	 * 
	 * @return launcher arguments
	 */
	public abstract String getArgs(); 
	
	public void setJar(String jar) {
		this.jar = new File(jar);
	}
	
	public void setNatives(String directory) {
		this.natives = new File(this.storage, directory);
	}
	
	public void setLibraries(String directory) {
		this.libraries = new File(this.storage, directory);
	}
	
	public File getNatives() {
		return this.natives;
	}
	
	public File getLibraries() {
		return this.libraries;
	}
	
	public File getMc() {
		return mc;
	}

	public File getStorage() {
		return storage;
	}

	public File getAssets() {
		return assets;
	}

	public File getJar() {
		return jar;
	}
}
