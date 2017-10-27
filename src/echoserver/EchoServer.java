package echoserver;
import java.net.*;
import java.io.*;

public class EchoServer {
  public static void main(String[] args) {
    try {
      //open socket
      ServerSocket sock = new ServerSocket(6013);
      //initialize byte var
      byte b;
      while (true) {
        //acknowledge and accept connection
        System.out.println("Got a request!");
        Socket client = sock.accept();
        
	//initialize streams 
	OutputStream output = client.getOutputStream();
	InputStream input = client.getInputStream();
        //store num of bytes read
	int i = input.read();

	//loop until end of bytes read
     	while (i != -1) {
		//cast and write byte to client
        	b = (byte)i;
        	output.write(b);
		//check for more input
        	i = input.read();
	}
      	
	//close streams
      	output.flush();
        client.close();
	input.close();
	output.close();

      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}
