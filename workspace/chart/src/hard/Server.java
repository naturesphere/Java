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
 *�����
 *���ܣ����ܿͻ��˷�������Ϣ��Ȼ���͸��������ߵĿͻ���
 */
public class Server 
{
	public static ArrayList<Socket> sockets=new ArrayList<Socket>();
	public static ArrayList<String> names=new ArrayList<String>();
	public static void main(String[] args) {
		try {
			names.add("С��");
			names.add("С��");
			names.add("С��");
			names.add("С��");
			names.add("С��");
			System.out.println("����������");
			ServerSocket server=new ServerSocket(1995);
			int count=0;
			while(true)
			{
				System.out.println("�ȴ��ͻ�������");
				Socket s = server.accept();//�ȴ��ͻ�������
				sockets.add(s);
				System.out.println("�ͻ��������ӣ�Ŀǰ��������"+sockets.size());
				new ServerThread(s,names.get(count++)).start();//������Ϊÿһ���߳̿����߳�
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

