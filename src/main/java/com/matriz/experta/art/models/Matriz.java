package com.matriz.experta.art.models;

public class Matriz {
	private int valX;
	private int valY;
	private int valZ;
	private int valW;
	
	
	public Matriz() {
	}

	public Matriz(int valX, int valY, int valZ, int valW) {
		this.valX = valX;
		this.valY = valY;
		this.valZ = valZ;
		this.valW = valW;
	}

	public int getValX() {
		return valX;
	}

	public void setValX(int valX) {
		this.valX = valX;
	}

	public int getValY() {
		return valY;
	}

	public void setValY(int valY) {
		this.valY = valY;
	}

	public int getValZ() {
		return valZ;
	}

	public void setValZ(int valZ) {
		this.valZ = valZ;
	}

	public int getValW() {
		return valW;
	}

	public void setValW(int valW) {
		this.valW = valW;
	}
	
}
