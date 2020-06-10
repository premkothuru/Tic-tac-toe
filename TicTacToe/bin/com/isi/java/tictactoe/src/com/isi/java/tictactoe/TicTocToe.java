package com.isi.java.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



//import jdk.jfr.internal.test.WhiteBox;


public class TicTocToe extends JFrame
{
	
	
	//private Adapter adapter;
	
    private static JButton[][] buttons;
    private static JButton reSet;
    private static JTextArea playerTurn;
	
    private static JPanel contentPane;
    private static JPanel gamePanel;
    private static JPanel messagePanel;
    private static JPanel resetPanel;
	int bordSizeGlobal;
	int count=0;

	public TicTocToe(int boardSize)
	{
		// TODO Auto-generated constructor stub
		super("TicTocToe");
		this.buttons=new JButton[boardSize][boardSize];
		this.reSet=new JButton("Reset");
		
		//this.playerTurn=new JTextArea().setBackground(Color.white);
		bordSizeGlobal = boardSize;
		createPanels(boardSize,boardSize);
		createComponents(boardSize);
		addCompomemtsToPanels();
		setActionListenersToButtons(boardSize);
		isWin();
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();//auto window size according to the elements
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	private void createPanels(int dimension1,int dimension2)
	{
		// TODO Auto-generated method stub
		contentPane=(JPanel) getContentPane();
		gamePanel=new JPanel();
		messagePanel=new JPanel();
		resetPanel=new JPanel();
		
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		GridLayout gridLayout=new GridLayout(dimension1, dimension2);
		gamePanel.setLayout(new GridLayout(dimension1, dimension2));
		//gamePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		//gamePanel.setLayout(new BoxLayout(gamePanel,BoxLayout.Y_AXIS));
	//	gridLayout.get
		
		messagePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		messagePanel.setLayout(new BoxLayout(messagePanel,BoxLayout.Y_AXIS));
		
		
		resetPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		resetPanel.setLayout(new BoxLayout(resetPanel,BoxLayout.Y_AXIS));
	//	contentPane.add(reSet,BorderLayout.SOUTH);

	}
	public  void createComponents(int dimension)
	{
		// TODO Auto-generated method stub
		
		
		for(int row = 0; row<dimension ;row++) {
	        for(int column = 0; column<dimension ;column++)
	        {
	            buttons[row][column] = new JButton();
	            buttons[row][column].setPreferredSize(new Dimension(75,75));
	            buttons[row][column].setText("");
	            buttons[row][column].setName(row+":"+column);
	            gamePanel.add(buttons[row][column]);
	            
		    }
		}
		setVisible(true);

	}
	public void addCompomemtsToPanels() 
	{
		
		//messagePanel.add(playerTurn);
		resetPanel.add(reSet);
		
		contentPane.add(gamePanel);
		contentPane.add(messagePanel);
		contentPane.add(resetPanel);
		
	}
	public void setActionListenersToButtons(int boardSize)
	{
		reSet.addActionListener((ActionEvent e) ->
		{

			for(int row = 0; row<boardSize ;row++)
			{
		        for(int column = 0; column<boardSize ;column++)
		        {
		            
		            
		            buttons[row][column].setText("");
		            
		            
			    }
			}

		});
		for(int i=0;i<boardSize;i++) 
		{
			for(int j=0;j<boardSize;j++) 
			{
				buttons[i][j].addActionListener((ActionEvent e) -> 
				{
					try {
					//	checkWinCodition(boardSize,buttons);
						count=count+1;
						JButton button=(JButton)e.getSource();
						System.out.println("value is "+button.getName());
						String row=button.getName();
						String[] coordinates =row.split(":");
						int row1=Integer.parseInt(coordinates[0]);
						int collun=Integer.parseInt(coordinates[1]);
					while(button.getText()=="") 
					{
					if(count%2!=0) {
						button.setText("X");
					}
					else {
						button.setText("O");
					}
						
						System.out.println("row : "+row1+"  collumn :"+collun);
					}
					}
					catch (Exception e1) 
					{
						// TODO: handle exception
					}
					
				});
			}
		}
	}
	public boolean isWin()
	{
		String arr[] = {};
		for(int i=0;i<bordSizeGlobal;i++) 
		{
			for(int j=0;j<bordSizeGlobal;j++) 
			{
				
				arr[i]=buttons[i][j].getText();
			}
			if(arr[0]==arr[1] && arr[1]==arr[2]) 
			{
				System.out.println("game over");
				
			}
		}
		return false;
	}
	public void checkWinCodition(int boardSize,JButton[][] buttons) 
		if(boardSize==3) 
		{
			if(buttons[0][0].getText()== 
			
		}
		else if(boardSize==4) {
			
		}
		else {
			
		}
		
		
	}

/*private void compTurn(int count)
{ 
 int randomMove=count;
 Random num = new Random();
 randomMove = num.nextInt(randomMove)+1;

  while(gameWon ==false)
   {
    for(int i = 0; i < 3; i++)                      //Create grid of buttons for tic tac toe game
     {
      for(int j = 0; j < 3; j++) 
       {                 
        if(buttons[i][j].isEnabled()==true)
         {
            randomMove--;

          if(randomMove==0 )
           {
             buttons[i][j].setText("O");
             buttons[i][j].setEnabled(false);
             moveCounter--;
             checkWin(i, j);
           }
          } 

         }
       }
     }
 */
	
	
	
}
