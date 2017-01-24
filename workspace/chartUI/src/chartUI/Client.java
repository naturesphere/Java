package chartUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 与服务器进行交互
 * 接收服务器发送过来的消息
 * 给服务器发送消息
 * @author xiebi
 *
 */
public class Client extends JFrame
{
	private Socket s;
	String name;
	JPanel jp1,jp2;
	JTextArea jta;//多行文本
	JTextField jtf;//单行文本，用了输入内容
	JScrollPane jsp;//滚动条
	
	public Client(Socket s, String name)
	{
		//用了显示内容
		jp1=new JPanel();
		jta=new JTextArea(20,30);//行，列
		jsp=new JScrollPane(jta);//jta具有了滚动条的功能
		
		jp1.add(jsp);
		//用来放置输入内容jtf组件的面板
		jp2=new JPanel();
		jtf=new JTextField(30);
		jp2.add(jtf);
		
		this.s=s;
		this.setLayout(new BorderLayout());
		this.setTitle(name);
		this.add(BorderLayout.CENTER,jp1);
		this.add(BorderLayout.SOUTH,jp2);
		this.pack();
		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		jtf.addActionListener(new MyListener());
		new GetThread().start();//启动读取服务器发送信息的线程
	}
		
	class MyListener implements ActionListener
	{
		boolean isblank=true;
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
//			if(isblank)
//			{
//				jta.setText(jta.getText()+jtf.getText());
//				isblank=false;
//			}
//			else
//				jta.setText(jta.getText()+"\n"+jtf.getText());
//			jtf.setText("");
			
			//向服务器发送消息
			String content=jtf.getText();
			try {
				OutputStreamWriter osw = new OutputStreamWriter( s.getOutputStream());
				osw.write(content+"\n");
				osw.flush();
				jtf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
//接收服务器发送的消息
	class GetThread extends Thread
	{
		public void run()
		{
			try {
				BufferedReader br=new BufferedReader(
						new InputStreamReader( s.getInputStream()));
				while(true)
				{
					String content=br.readLine();
					jta.setText(jta.getText()+content+'\n');
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


