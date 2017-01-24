package chartUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author xiebi
 *服务端
 *功能：接受客户端发来的消息，然后发送给所有在线的客户端
 */
public class Server 
{
	public static ArrayList<Socket> sockets=new ArrayList<Socket>();

	public static void main(String[] args) {
		try {
			System.out.println("服务器启动");
			ServerSocket server=new ServerSocket(1995);
			while(true)
			{
				System.out.println("等待客户端连接");
				Socket s = server.accept();//等待客户端连接
				sockets.add(s);
				System.out.println("客户端已连接，目前在线人数"+sockets.size());
				new ServerThread(s).start();//服务器为每一个socket开启线程
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


class ServerThread extends Thread
{
	private Socket s;
	
	public ServerThread(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		try {
			BufferedReader br=new BufferedReader
					(new InputStreamReader(s.getInputStream()));
			
			//获得登录的用户姓名，然后给所有的客户端发送欢迎XXX登录
			String username = br.readLine();
			for(Socket socket:Server.sockets)
			{
				OutputStreamWriter osw=
						new OutputStreamWriter(socket.getOutputStream());
				osw.write("[系统消息]欢迎"+username+"登录\n");
				System.out.println("[系统消息]欢迎"+username+"登录\n");
				osw.flush();
			}
			//接收聊天信息，然后转发给所有的客户端
			while(true)
			{
				String content=br.readLine();
				System.out.println(username+":"+content);
				for(Socket socket:Server.sockets)
				{
					OutputStreamWriter osw = 
							new OutputStreamWriter(socket.getOutputStream());
					osw.write(username+":"+content+'\n');
					osw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

