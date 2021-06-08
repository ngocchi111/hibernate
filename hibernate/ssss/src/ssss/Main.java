package ssss;

import com.sun.jdi.connect.spi.Connection;

public class Main {
	public static void main(String[] args) {
	connectData d= new connectData();
	Connection c = d.getConnection();
    if (c == null) {
        System.out.println("something wrong");
    } else {
        System.out.println("ok");
    }
}
}