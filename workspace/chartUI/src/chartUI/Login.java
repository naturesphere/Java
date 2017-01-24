package chartUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * 
 * @author xiebi
 *
 */
public class Login extends JFrame implements ActionListener
{
	public static void main(String[] args) 
	{
		new Login();
	}
	
	JLabel label=new JLabel("请输入用户名：");
	JTextField jtf=new JTextField(30);

	public Login()
	{
		this.setLayout(new FlowLayout());
		this.add(label);
		this.add(jtf);
		this.pack();
		this.setVisible(true);
		jtf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		Socket s=null;
		try {
			s = new Socket("127.0.0.1",1995);
		} catch (UnknownHostException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());
			osw.write(jtf.getText()+'\n');
			osw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//创建聊天窗口
		new Client(s,jtf.getText());
		//登录窗口关闭
		this.dispose();		
	}
}
