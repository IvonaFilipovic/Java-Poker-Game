package test;

import java.io.Serializable;

public class GameTest implements Serializable{
	int current = 0;

	public GameTest(){

	}

	public void update(){
		this.current += 1;
	}

	public int getCurrent() {
		return this.current;
	}
	
	public String toString(){
		return ("current: " + current);
	}
}