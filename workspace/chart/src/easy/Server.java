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
			System.out.println("���������");
			server = new ServerSocket(1995);
			while(true)
			{
				System.out.println("���ڵȴ���"+clientCount+"���ͻ�������...");
				s=server.accept();
				System.out.println("�ͻ���������");
				clientCount++;
				OutputStreamWriter out=
						new OutputStreamWriter(s.getOutputStream());
				out.write("��ϵͳ��Ϣ����ӭ����\n");
				out.flush();
				//out.close();
				//System.out.println("����˹ر�");				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
