package com.example.user.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Spot implements Drawable{
	private Shape shape=Shape.Rectangle;
	private int color;
	@SerializedName("x")
	@Expose
	private Double x;
	@SerializedName("y")
	@Expose
	private Double y;
	@SerializedName("w")
	@Expose
	private Double w;
	@SerializedName("h")
	@Expose
	private Double h;
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("editName")
	@Expose
	private String name;
	@SerializedName("description")
	@Expose
	private String description;

	public Spot(int ID, double X, double Y, double width, double height, Shape shape, int color) {
		this.id=ID;
		this.x=X;
		this.y=Y;
		this.w=width;
		this.h=height;
		this.shape=shape;
		this.color=color;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getW() {
		return w;
	}

	public void setW(Double w) {
		this.w = w;
	}

	public Double getH() {
		return h;
	}

	public void setH(Double h) {
		this.h = h;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void draw(Canvas canvas, int col) {

		Paint paint = new Paint();
		paint.setColor(col);
		//if(shape==Shape.Rectangle){
		Rect rect = new Rect(x.intValue(),y.intValue(),x.intValue()+w.intValue(),y.intValue()+h.intValue());
		canvas.drawRect(rect,paint);

		//}
		//else if(shape==Shape.Oval){
		//	RectF oval = new RectF(x.intValue(),y.intValue(),x.intValue()+w.intValue(),y.intValue()+h.intValue());
		//	canvas.drawOval(oval,paint);
		//}
	}
}
