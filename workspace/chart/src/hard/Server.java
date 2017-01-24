package hard;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 
 * @author xiebi
 *服务端
 *功能：接受客户端发来的消息，然后发送给所有在线的客户端
 */
public class Server 
{
	public static ArrayList<Socket> sockets=new ArrayList<Socket>();
	public static ArrayList<String> names=new ArrayList<String>();
	public static void main(String[] args) {
		try {
			names.add("小明");
			names.add("小红");
			names.add("小军");
			names.add("小李");
			names.add("小赵");
			System.out.println("服务器启动");
			ServerSocket server=new ServerSocket(1995);
			int count=0;
			while(true)
			{
				System.out.println("等待客户端连接");
				Socket s = server.accept();//等待客户端连接
				sockets.add(s);
				System.out.println("客户端已连接，目前在线人数"+sockets.size());
				new ServerThread(s,names.get(count++)).start();//服务器为每一个线程开启线程
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
	private String name;
	
	public ServerThread(Socket s, String name)
	{
		this.s=s;
		this.name=name;
	}
	
	public void run()
	{
		try {
			BufferedReader br=new BufferedReader
					(new InputStreamReader(s.getInputStream()));
			while(true)
			{
				String content=br.readLine();
				System.out.println(this.name+":"+content);
				for(Socket socket:Server.sockets)
				{
					OutputStreamWriter osw = 
							new OutputStreamWriter(socket.getOutputStream());
					osw.write(this.name+":"+content+'\n');
					osw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

