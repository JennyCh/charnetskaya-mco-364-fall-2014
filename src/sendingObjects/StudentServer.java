package sendingObjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {

	private ObjectOutputStream out;
	private ObjectInputStream in;

	public static void main(String[] args) {
		new StudentServer();
	}

	public StudentServer() {
		try {
			ServerSocket server = new ServerSocket(8000);
			System.out.println("Server started...");

			out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Jenny\\Desktop\\student.txt", true));

			while (true) {
				Socket socket = server.accept();
				in = new ObjectInputStream(socket.getInputStream());
				Object object = in.readObject();

				out.writeObject(object);
				System.out.println("new student object stored");

			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				in.close();
				out.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
