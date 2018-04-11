package com.example.user.myapplication;

import java.util.ArrayList;

public class Room {
	int ID;
	int height;
	int width;

	private ArrayList<Chair> chairs;
	private ArrayList<Table> tables;
	private ArrayList<Decoration> decorations;

	public Room(ArrayList<Chair> chairs, ArrayList<Table> tables, ArrayList<Decoration> decorations){
		this.chairs=chairs;
		this.tables=tables;
		this.decorations=decorations;
	}
}
