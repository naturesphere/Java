package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		Socket socket=null;
		try {
			System.out.println("客户端启动");
			socket=new Socket("127.0.0.1", 1995);
			InputStreamReader in=
					new InputStreamReader(socket.getInputStream());
			BufferedReader br=new BufferedReader(in);
			String str=null;
			while((str=br.readLine())!=null)
				System.out.println(str);
			br.close();
				socket.close();
				System.out.println("客户端关闭");			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
