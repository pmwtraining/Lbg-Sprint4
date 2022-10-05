package com.qa.project;

import java.io.Closeable;
import java.util.Scanner;

public class UserInput implements Closeable {
	
	private final Scanner scan;
	
	public UserInput(Scanner scan) {
		this.scan = scan;
	}
	
	public String read() {
		return this.scan.nextLine();
	}
	
	@Override
	public void close() {
		this.scan.close();
	}
	
}
