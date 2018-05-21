package com.example.user.myapplication;

import java.util.ArrayList;

public class Table extends Spot{
	private ArrayList<Chair> chairs;

	public Table(int ID, int X, int Y, int width, int height, Shape shape,int color) {
		super(ID, X, Y, width, height, shape, color);
	}

	public void addChairs(ArrayList<Chair> chairs){
		this.chairs=chairs;
	}

}
