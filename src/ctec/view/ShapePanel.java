package ctec.view;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	
	public ShapePanel()
	{
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		circleList = new ArrayList<Ellipse2D>();
		ellipseList = new ArrayList<Ellipse2D>();
		
	}
	
	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 150);
		int yPosition = (int)(Math.random() * 150);
		int width = (int)(Math.random() * 150);
		int height = (int)(Math.random() * 150);
		
		Rectangle rectangle = new Rectangle (xPosition, yPosition, width, height);
		rectangleList.add(rectangle);
	}

	public void addSquare()
	{
		int xPosition = (int)(Math.random() * 150);
		int yPosition = (int)(Math.random() * 150);
		int width = (int)(Math.random() * 150);
		
		
		Rectangle square = new Rectangle (xPosition, yPosition, width, width);
		squareList.add(square);
	}

	public void addEllipse()
	{
		int xPosition = (int)(Math.random() * getWidth()), yPosition = (int)(Math.random() * getHeight());
		int width = (int)(Math.random() * 200), height = (int)(Math.random() * 200);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition,yPosition,width,height);
		ellipseList.add(currentEllipse);
	}
	
	public void addCircle()
	{
		int xPosition = (int)(Math.random() * getWidth()), yPosition = (int)(Math.random() * getHeight());
		int size = (int)(Math.random() * 200);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition,yPosition,size,size);
		ellipseList.add(currentEllipse);
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int[3];
		xPoints[0] = (int)(Math.random() * 150);
		xPoints[1] = (int)(Math.random() * 150);
		xPoints[2] = (int)(Math.random() * 150);
		
		int [] yPoints ={(int)(Math.random() * 250), (int)(Math.random() * 450), (int)(Math.random() * 250)};
				
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		triangleList.add(triangle);
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 9) + 3;
		int [] xPoints = new int [numberOfSides];
		int [] yPoints = new int [numberOfSides];
		
		for(int side = 0; side < numberOfSides; side++)
		{
			xPoints[side] = (int)(Math.random() * 200);
			yPoints[side] = (int)(Math.random() * 200);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
		
	}
	
	
 	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		
		for(Polygon currentTriangle : triangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10)+3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentTriangle);
		}
		
		
		for(Rectangle currentRectangle : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10)+3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentRectangle);
		}
		
		for(Ellipse2D currentCircle : circleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10)+3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentCircle);
		}
		
		for(Ellipse2D currentEllipse2D : ellipseList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10)+3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentEllipse2D);
		}
		
		for(Rectangle currentRectangle : squareList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			int penSize = (int)(Math.random() * 10)+3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			
			mainGraphics.draw(currentRectangle);
		}
		
		for(Polygon current : polygonList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
		
			mainGraphics.setColor(new Color(red, green, blue));
			
			mainGraphics.fill(current);
		}
	}

	public void clear()
	{
		rectangleList.clear();
		circleList.clear();
		polygonList.clear();
		ellipseList.clear();
		triangleList.clear();
		ellipseList.clear();
		squareList.clear();
		
	}
}
