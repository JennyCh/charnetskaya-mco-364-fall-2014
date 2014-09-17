package charnetskaya.practiceNetworks;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerHost extends JFrame {
	private JTextArea area = new JTextArea();

	public static void main(String[] args) throws IOException {

		new ServerHost();
	}

	public ServerHost() throws IOException {
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(area), BorderLayout.CENTER);
		this.setTitle("Server");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
ServerSocket server = new ServerSocket(8000);
			area.append("Server started at " + new Date() + '\n');
		try {
			
			Socket socket = server.accept();
			
			HandleAClient task = new HandleAClient(socket);
			new Thread(task).start();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	class HandleAClient implements Runnable {
		private Socket socket;
		
		public HandleAClient(Socket socket){
			this.socket = socket;
		}
		
		public void run (){
			try{
				DataInputStream in = new DataInputStream(socket.getInputStream());
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				
				while (true){
					double radius = in.readDouble();
					double a = radius * radius * Math.PI;
					
					out.writeDouble(a);
					
					area.append("radius recieved " + radius + " \n");
					area.append("Area Found: " + a + "\n");
				}
			}catch (IOException e){
				System.err.print(e);
			}
		}
	}

}
