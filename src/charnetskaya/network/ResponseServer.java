package charnetskaya.network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int clientNum = 0;
		ServerSocket serverSocket = new ServerSocket(8000);
		Socket socket = null;
		while (true) {
			socket = serverSocket.accept();
			new HandleClient(socket, clientNum++).run();
		}
	}

	static class HandleClient implements Runnable {
		Socket socket;
		int counter;

		public HandleClient(Socket socket, int counter) {
			this.socket = socket;
			this.counter = counter;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {				
				OutputStream out = socket.getOutputStream();
				String response = "<h2>" + counter + "</h2>";
				out.write("HTTP/1.1 200 OK\n".getBytes());
				out.write("Content-Type: text/html; charset=utf-8\n".getBytes());
				out.write(("Content-Length: " + response.length() + "\n\n").getBytes());
				out.write(response.getBytes());
				out.flush();
				out.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}

	}

}
