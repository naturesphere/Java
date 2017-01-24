import com.it18zhang.a.A;
import com.it18zhang.java.PackageDemo;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		PackageDemo.sayHello("hello");
		Object obj = new Object();
		System.out.println(obj.getClass());
	}

}
