package easy;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	
	public static void main(String[] args) 
	{
		ServerSocket server=null;
		Socket s=null;
		int clientCount=1;
		try {
			System.out.println("服务端启动");
			server = new ServerSocket(1995);
			while(true)
			{
				System.out.println("正在等待第"+clientCount+"个客户端连接...");
				s=server.accept();
				System.out.println("客户端连接了");
				clientCount++;
				OutputStreamWriter out=
						new OutputStreamWriter(s.getOutputStream());
				out.write("【系统消息】欢迎上线\n");
				out.flush();
				//out.close();
				//System.out.println("服务端关闭");				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
