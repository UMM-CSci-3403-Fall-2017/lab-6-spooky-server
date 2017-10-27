package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient {

  public static void main(String[] args) {
    try {
      //open socket
      Socket socket = new Socket("127.0.0.1", 6013);
      
      //initialize streams and byte var
      InputStream stdIn = System.in;
      OutputStream stdOut = System.out;
      InputStream serverIn = socket.getInputStream();
      OutputStream output = socket.getOutputStream();
      byte b;
      //store num of bytes read
      int i = stdIn.read();
      
      //loop until end of bytes read
      while (i != -1) {
	//cast and write byte to server
	b = (byte)i;
	output.write(b);
	//read, store, and print response byte
        b =(byte)serverIn.read();
	stdOut.write(b);
	//check for more input
	i = stdIn.read();
      }
      
      //close/flush streams
      output.flush();
      stdOut.flush();
      stdIn.close();
      stdOut.close();
      serverIn.close();
      output.close();
      socket.close();

    } catch (IOException ioe) {
      System.out.println("We caught an exception");
      System.err.println(ioe);
    }
  }
}

