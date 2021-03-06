package charnetskaya.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;

public class SocketHandler extends Thread {

	private Socket socket;
	private Queue<String> messages;

	public SocketHandler(Socket socket, Queue<String> messages) {
		this.socket = socket;
		this.messages = messages;
	}

	public void run() {
		InputStream in;
		try {
			in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;

			while ((line = reader.readLine()) != null) {
				// write to all the clients
				messages.add(line);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
