import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pathfinding { 

	//create a 2d array of chars
    static char[][] grid = { { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' },
            				   { 'w', 'w', ' ', ' ', 'w', ' ', 'w', 'w', 'w', 'w', ' ', ' ', 'w' },
            				   { 'f', ' ', ' ', 'w', 'w', ' ', 'w', ' ', 'w', 'w', ' ', 'w', 'w' },
            				   { 'w', 'w', ' ', ' ', ' ', ' ', 'w', ' ', ' ', ' ', ' ', ' ', 'w' },
            				   { 'w', 'w', 'w', ' ', 'w', 'w', 'w', 'w', 'w', ' ', 'w', 'w', 'w' },
            				   { 'w', 'w', 'w', ' ', 'w', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'w' },
            				   { 'w', ' ', ' ', ' ', ' ', 'w', 'w', 'w', ' ', 'w', 'w', 'w', 'w' },
            				   { 'w', 'w', ' ', 'w', ' ', ' ', ' ', ' ', ' ', 'w', ' ', 'w', 'w' },
            				   { 'w', ' ', 'w', ' ', ' ', 'w', 'w', 'w', ' ', ' ', ' ', ' ', 'w' },
            				   { 'w', ' ', 'w', 'w', ' ', 'w', 'w', ' ', 'w', ' ', 'w', ' ', 'w' },
            				   { 'w', ' ', ' ', ' ', ' ', 'w', 'w', ' ', ' ', ' ', 'w', 'w', 'w' },
            				   { 'w', ' ', 'w', 'w', 'w', ' ', 'w', ' ', 'w', ' ', ' ', 'w', 'w' },
            				   { 'w', ' ', ' ', ' ', ' ', ' ', 'w', ' ', 'w', 'w', ' ', ' ', 'w' },
            				   { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 's', 'w' }, };

    public static void main(String[] args) throws InterruptedException {
        Pathfinding maze = new Pathfinding();
        maze.startWindow();

        int i=0,j = 0;
        int maxX = grid.length;
        int maxY = grid[0].length;
        
        //find the starting point of the grid
        for(int k = 0; k < grid.length; k++) 
        {
        	for(int l = 0; l < grid[k].length; l++) 
            {
        		if(grid[k][l] == 's')
        		{
        			i = k;
        			j = l;
        		}
            }
        }
        
        //helps give the gui time to load the labels
        Thread.sleep(200);
        while(grid[i][j] != 'f') 
        {
        	//purely for the user
        	Thread.sleep(23);
        		
        	
        	if(i+1 < maxX) 
        	{
        		if(grid[i+1][j] == 'f') 
        		{
        			grid[i+1][j]='s';
        			maze.updateWindow();
        			break;
        		}
        		else if(grid[i+1][j] == ' ') 
        		{
        			grid[i+1][j]='p';
        			i+=1;
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	
        	if(j+1 <= maxY) 
        	{
        		if(grid[i][j+1] == 'f') 
        		{
        			grid[i][j+1]='s';
        	
        			
        			maze.updateWindow();
        			break;
        		}
        		else if(grid[i][j+1] == ' ') 
        		{
        			grid[i][j+1]='p';
        			j+=1;
        			
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	if(i-1 >= 0) 
        	{
        		if(grid[i-1][j] == 'f') 
        		{
        			grid[i-1][j]='s';
        			
        			maze.updateWindow();
        			break;
        		}
        		else if(grid[i-1][j] == ' ') 
        		{
        			grid[i-1][j]='p';
        			i-=1;
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	if(j-1 >= 0) 
        	{
        		if(grid[i][j-1] == 'f') 
        		{
        			grid[i][j-1]='s';
        			
        			
        			maze.updateWindow();
        			break;
        		}
        		else if(grid[i][j-1] == ' ') 
        		{
        			grid[i][j-1]='p';
        			j-=1;
        			
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	//if there is no new path to go down then it marks the current spot as dead and starts to trace back to another viable route
        	grid[i][j]='d';
        	maze.updateWindow();
        	//
        	if(i+1 < maxX) 
        	{
        		if(grid[i+1][j] == 'p') 
        		{
        			grid[i][j]='d';
        			i+=1;
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	
        	if(j+1 <= maxY) 
        	{
        		if(grid[i][j+1] == 'p') 
        		{
        			grid[i][j]='d';
        			j+=1;
        			
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	if(i-1 >= 0) 
        	{
        		if(grid[i-1][j] == 'p') 
        		{
        			grid[i][j]='d';
        			i-=1;
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	if(j-1 >= 0) 
        	{
        		if(grid[i][j-1] == 'p') 
        		{
        			grid[i][j]='d';
        			j-=1;
        			
        			maze.updateWindow();
        			continue;
        		}
        		
        	}
        	//
        	
        }
        
    }
    JFrame mainFrame = new JFrame("Maze DFS");
    
    
    //this starts the gui and sets up all of its features
    private void startWindow() {

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(grid.length, grid[0].length));
    
        mainFrame.setLocationRelativeTo(null);

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                JLabel label = makeLabel(grid[row][col]);
                mainFrame.add(label);
            }
        }
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
    //update is called whenever the window has outdated information displayed on it
    private void updateWindow() {
    	 mainFrame.getContentPane().removeAll();
    	
          for (int row = 0; row < grid.length; row++) {
              for (int col = 0; col < grid[0].length; col++) {
                  JLabel label = makeLabel(grid[row][col]);
                  mainFrame.add(label);
              }
          }
          mainFrame.pack();
          mainFrame.setVisible(true);
      }
    
    //creates a label with a given color
    private JLabel makeLabel(char c) {

        JLabel label= new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(40, 40));
        switch(c) {
            case 'w':
                label.setBackground(Color.BLACK);
                break;
                
            case ' ':
            	label.setBackground(Color.WHITE);
            	//label.setText("Bruh");
                break;
                
                
            case 's':
            	label.setBackground(Color.cyan);
                break;   
                
            case 'f':
            	label.setBackground(Color.DARK_GRAY);
                break;     
            
            case 'p':
            	label.setBackground(Color.green);
            	break;
          
            case 'd':
            	label.setBackground(Color.red);
            	break;

        }
        label.setOpaque(true);
        //label.setBorder(BorderFactory.createLineBorder(Color.orange, 3));
        label.setBorder(BorderFactory.createBevelBorder(10));
        return label;
    }
}