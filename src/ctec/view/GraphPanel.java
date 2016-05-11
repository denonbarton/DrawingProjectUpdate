package ctec.view;

import java.awt.*;
import javax.swing.*;

public class GraphPanel extends JPanel
	{
		private int [] graphSource;
		
		public GraphPanel()
		{
			graphSource = new int[] 
					{
					120,4,213,10,20,12,75
					};
		}
		
		@Override
		protected void paintComponent(Graphics currentGraphics)
		{
			super.paintComponent(currentGraphics);
			
			Graphics2D mainGraphics = (Graphics2D) currentGraphics;
			
			for(int index = 0; index < graphSource.length; index ++)
				{
					int height = graphSource[index];
					int width = this.getWidth()/graphSource.length;
					int xPos = width * index;
					int yPos = 0;
					
					int red = (int) (Math.random() * 256);
					int green = (int) (Math.random() * 256);
					int blue = (int) (Math.random() * 256);
					int transp = (int) (Math.random() * 256);

					mainGraphics.setColor(new Color(red, green, blue, transp));
					
					mainGraphics.fill(new Rectangle(xPos, yPos, width, height));
				}
			}
	}