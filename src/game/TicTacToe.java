package game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToe implements ActionListener{

	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JButton buttons[] = new JButton[9]; 
	JLabel text = new JLabel();
	boolean player1_turn;
 	Random random = new Random();
	TicTacToe()
	{
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		text.setBackground(new Color(233, 75, 60));
		text.setForeground(new Color(45, 41, 38));
		text.setFont(new Font("Ink Free",Font.BOLD,75));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("Tic Tac Toe");
		text.setOpaque(true);
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(Color.white);
		
		for(int i=0;i<9;i++)
		{
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,75));
			buttons[i].setFocusable(false);
			buttons[i].setBackground(new Color(45, 41, 38));
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(text);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
	}
	
	void firstTurn()
	{
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(random.nextInt(2)==0)
		{
			player1_turn=true;
			text.setText("X Turn");
		}
		else
		{
			player1_turn=false;
			text.setText("O Turn");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<9;i++)
		{
			if(e.getSource()==buttons[i])
			{
				if(player1_turn)
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						text.setText("O Turn");
						check();
					}
				}
				else
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						text.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	boolean win=false;
	private void check() {
		//x condition
		if(buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X")
		{
			XWins(0,1,2);
			win=true;
		}
		if(buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X")
		{
			XWins(3,4,5);
			win=true;
		}
		if(buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X")
		{
			XWins(6,7,8);
			win=true;
		}
		if(buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X")
		{
			XWins(0,3,6);
			win=true;
		}
		if(buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X")
		{
			XWins(1,4,7);
			win=true;
		}
		if(buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X")
		{
			XWins(2,5,8);
			win=true;
		}
		if(buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X")
		{
			XWins(0,4,8);
			win=true;
		}
		if(buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X")
		{
			XWins(0,4,8);
			win=true;
		}
		
		//o condition
		
		if(buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O")
		{
			OWins(0,1,2);
			win=true;
		}
		if(buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O")
		{
			OWins(3,4,5);
			win=true;
		}
		if(buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O")
		{
			OWins(6,7,8);
			win=true;
		}
		if(buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O")
		{
			OWins(0,3,6);
			win=true;
		}
		if(buttons[1].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O")
		{
			OWins(1,4,7);
			win=true;
		}
		if(buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O")
		{
			OWins(2,5,8);
			win=true;
		}
		if(buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O")
		{
			OWins(0,4,8);
			win=true;
		}
		if(buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O")
		{
			OWins(0,4,8);
			win=true;
		}
		else if(checkDraw()==9 && win==false)
		{
			text.setText("Draw");
		}
	}

	private int checkDraw() {
		// TODO Auto-generated method stub
		String str="";
		for(int i=0;i<9;i++)
		{
			str+=buttons[i].getText();
		}
		return str.length();
	}

	private void XWins(int i, int j, int k) {
		// TODO Auto-generated method stub
		buttons[i].setBackground(Color.GREEN);
		buttons[j].setBackground(Color.GREEN);
		buttons[k].setBackground(Color.GREEN);
		for(int i1=0;i1<9;i1++)
			buttons[i1].setEnabled(false);
		text.setText("X Wins");
	}

	private void OWins(int i, int j, int k) {
		// TODO Auto-generated method stub
		buttons[i].setBackground(Color.GREEN);
		buttons[j].setBackground(Color.GREEN);
		buttons[k].setBackground(Color.GREEN);
		for(int i1=0;i1<9;i1++)
			buttons[i1].setEnabled(false);
		text.setText("O Wins");
	}
	
}
