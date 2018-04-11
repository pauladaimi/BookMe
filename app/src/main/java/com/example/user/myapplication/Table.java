package com.example.user.myapplication;

import java.util.ArrayList;

public class Table extends Spot{
	private ArrayList<Chair> chairs;
	private Shape shape;

	public Table(ArrayList<Chair> chairs, Shape shape){
		this.chairs=chairs;
		this.shape=shape;
	}

	public Table(Shape shape){
		this.shape=shape;
	}

}
