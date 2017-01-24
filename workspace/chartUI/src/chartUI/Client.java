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
 * ����������н���
 * ���շ��������͹�������Ϣ
 * ��������������Ϣ
 * @author xiebi
 *
 */
public class Client extends JFrame
{
	private Socket s;
	String name;
	JPanel jp1,jp2;
	JTextArea jta;//�����ı�
	JTextField jtf;//�����ı���������������
	JScrollPane jsp;//������
	
	public Client(Socket s, String name)
	{
		//������ʾ����
		jp1=new JPanel();
		jta=new JTextArea(20,30);//�У���
		jsp=new JScrollPane(jta);//jta�����˹������Ĺ���
		
		jp1.add(jsp);
		//����������������jtf��������
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
		new GetThread().start();//������ȡ������������Ϣ���߳�
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
			
			//�������������Ϣ
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
	
//���շ��������͵���Ϣ
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


