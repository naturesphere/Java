package hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client 
{
	public static void main(String[] args) 
	{
		try {
			System.out.println("客户端启动");
			Socket s=new Socket("127.0.0.1", 1995);
			new SendThread(s).start();
			new GetThread(s).start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SendThread extends Thread
{
	private  Socket s;
	public SendThread(Socket s)
	{
		this.s=s;
	}
	public void run()
	{
		try {
			OutputStreamWriter osw=new 
					OutputStreamWriter( s.getOutputStream());
			BufferedReader br=new 
				BufferedReader(new InputStreamReader(System.in));	
			while(true)
			{
				String content=br.readLine();
				osw.write(content+"\n");
				//System.out.println("键盘输入："+content);
				osw.flush();				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

//接受消息的线程
class GetThread extends Thread
{
	private Socket s;
	public GetThread(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		try {				

				BufferedReader br =	new BufferedReader(
							    new InputStreamReader(
								s.getInputStream()));
				while(true)
				{
					String content = br.readLine();
					System.out.println(content);
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}