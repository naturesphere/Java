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
 *�����
 *���ܣ����ܿͻ��˷�������Ϣ��Ȼ���͸��������ߵĿͻ���
 */
public class Server 
{
	public static ArrayList<Socket> sockets=new ArrayList<Socket>();

	public static void main(String[] args) {
		try {
			System.out.println("����������");
			ServerSocket server=new ServerSocket(1995);
			while(true)
			{
				System.out.println("�ȴ��ͻ�������");
				Socket s = server.accept();//�ȴ��ͻ�������
				sockets.add(s);
				System.out.println("�ͻ��������ӣ�Ŀǰ��������"+sockets.size());
				new ServerThread(s).start();//������Ϊÿһ��socket�����߳�
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
			
			//��õ�¼���û�������Ȼ������еĿͻ��˷��ͻ�ӭXXX��¼
			String username = br.readLine();
			for(Socket socket:Server.sockets)
			{
				OutputStreamWriter osw=
						new OutputStreamWriter(socket.getOutputStream());
				osw.write("[ϵͳ��Ϣ]��ӭ"+username+"��¼\n");
				System.out.println("[ϵͳ��Ϣ]��ӭ"+username+"��¼\n");
				osw.flush();
			}
			//����������Ϣ��Ȼ��ת�������еĿͻ���
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

