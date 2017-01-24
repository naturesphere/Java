package javatest;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author xiebi
 * 自己实现的计算器
 * 流程上计算命令符(+*-/)会滞后一位，因此command和result的初始值很重要command="=",result=0
 * isPoint标识的引入是为了解决多次输入小数点都显示的问题
 */
public class Calculator 
{
	public static void main(String[] args) 
	{
		new CalculatorFrame();
		System.out.println("Good Job !");
	}	
}

class CalculatorFrame extends JFrame
{
	public CalculatorFrame()
	{
		this.setTitle("Calculator");
		CalculatorPanel cp=new CalculatorPanel();
		this.add(cp);
		this.pack();
		this.addWindowListener
		(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
		this.setVisible(true);
	}
}

class CalculatorPanel extends JPanel
{
	JLabel display=null;
	JPanel panel=null;
	double result;
	String command;	//存放命令
	boolean start;
	boolean isPointed=false;
	
	public CalculatorPanel()
	{
		this.setLayout(new BorderLayout());
		result=0;
		command="=";
		start=true;
		display=new JLabel();
		display.setText("0");
		this.add(BorderLayout.NORTH, display);
		
		panel=new JPanel();
		panel.setLayout(new GridLayout(4,4));
		CalculatorAction1 c1=new CalculatorAction1();
		CalculatorAction2 c2=new CalculatorAction2();
		addButton("7",c1);
		addButton("8",c1);
		addButton("9",c1);
		addButton("+",c2);
		
		addButton("4",c1);
		addButton("5",c1);
		addButton("6",c1);
		addButton("-",c2);
		
		addButton("1",c1);
		addButton("2",c1);
		addButton("3",c1);
		addButton("*",c2);
		
		addButton("0",c1);
		addButton(".",c1);
		addButton("=",c2);
		addButton("/",c2);
		
		this.add(BorderLayout.CENTER,panel);
	}
	
	private void addButton(String s,ActionListener al)
	{
		JButton button=new JButton(s);
		button.addActionListener(al);
		panel.add(button);
	}
	
	//数字监听器
	class CalculatorAction1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			String input=e.getActionCommand();
			if(start)
			{
				display.setText("");
				start=false;
			}
			
			if(!isPointed||(isPointed&&input!="."))
			{
				display.setText(display.getText()+input);
				if(input==".")
					isPointed=true;
			}
		}
		
	}
	
	//命令监听器
	class CalculatorAction2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String c=e.getActionCommand();
			if(start)
			{
				command=c;
			}
			else
			{
				switch(command)
				{
				case "+":
					result+=Double.parseDouble(display.getText());
					break;
				case "-":
					result-=Double.parseDouble(display.getText());
					break;
				case "*":
					result*=Double.parseDouble(display.getText());
					break;
				case "/":
					result/=Double.parseDouble(display.getText());
					break;
				case "=":
					result=Double.parseDouble(display.getText());
					break;
				default:
					break;
				}
				display.setText(""+result);
				command=c;
				start=true;
				isPointed=false;
			}
		}
		
	}
}
