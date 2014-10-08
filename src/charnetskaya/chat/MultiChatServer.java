package charnetskaya.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MultiChatServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket serverSocket = new ServerSocket(9097);
		List<Socket> sockets = new ArrayList<Socket>();
		BlockingQueue<String> messages = new LinkedBlockingQueue <String>();
		MessageSender sender = new MessageSender(sockets, messages);
		sender.start();
		while (true) {
			Socket socket = serverSocket.accept();
			sockets.add(socket);
			SocketHandler handler = new SocketHandler(socket, messages);
			handler.start();
		}
	}

}
