package ctec.view;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import ctec.controller.*;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private ShapePanel shapePanel;
	private JButton addRectangleButton;
	private JButton addCircleButton;
	private JButton addSquareButton;
	private JButton addTriangleButton;
	private JButton addEllipseButton;
	private JButton addPolygonButton;
	private JButton clearButton;
	private JButton clearButton_1;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPanel(DrawingController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		addRectangleButton =  new JButton("Add a Rectangle");
		addCircleButton = new JButton("add a circle");
		addSquareButton = new JButton("add a Square");
		addTriangleButton = new JButton("Add a Triangle");
		addEllipseButton = new JButton("Add a Ellipse");
		addPolygonButton = new JButton("Add a Polygon");
		rectangleList = new ArrayList<Rectangle>();
		shapePanel = new ShapePanel();
		clearButton = new JButton("clear the lists");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(addRectangleButton);
		this.add(addCircleButton);
		this.add(addSquareButton);
		this.add(addTriangleButton);
		this.add(addEllipseButton);
		this.add(clearButton);
		this.add(addPolygonButton);
		this.add(shapePanel);
		this.add(shapePanel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 0, SpringLayout.WEST, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -12, SpringLayout.NORTH, addEllipseButton);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 6, SpringLayout.SOUTH, clearButton);
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, addPolygonButton, 0, SpringLayout.WEST, addSquareButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, addPolygonButton, -6, SpringLayout.NORTH, addSquareButton);
		baseLayout.putConstraint(SpringLayout.WEST, clearButton, 0, SpringLayout.WEST, addCircleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addEllipseButton, 0, SpringLayout.NORTH, addTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addEllipseButton, 6, SpringLayout.EAST, addTriangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addTriangleButton, 0, SpringLayout.WEST, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, addTriangleButton, -6, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addSquareButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addSquareButton, 6, SpringLayout.EAST, addCircleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addCircleButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addCircleButton, 6, SpringLayout.EAST, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, addRectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, addRectangleButton, -10, SpringLayout.SOUTH, this);
	}
	
	private void setupListeners()
	{
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			}
		});
		
		addSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			}
		});
		
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
				repaint();
			}
		});
		
		addPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
		});
	
		addTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		addEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			}
		});
		
		addCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			}
		});
	
		
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setStroke(new BasicStroke(20));
		mainGraphics.setColor(Color.CYAN);
		mainGraphics.drawRect(50, 70, 200, 400);
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(current);
		}
		
	}
	
}
