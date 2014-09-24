package charnetskaya.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerChat extends JFrame {

	private JTextField field;
	private JTextArea area;
	private JPanel panel;
	private JButton send;

	public ServerChat() {
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());
		field = new JTextField();

		area = new JTextArea();
		area.setEditable(false);
		area.setBackground(Color.getHSBColor(255, 255, 12));

		send = new JButton("Send");
		send.setBackground(Color.getHSBColor(255, 255, 204));
		send.setForeground(Color.getHSBColor(255, 10, 255));
		// this.field.setColumns(40);

		this.add(new JScrollPane(area), BorderLayout.CENTER);
		this.panel.add(field, BorderLayout.CENTER);
		this.panel.add(send, BorderLayout.EAST);
		this.add(panel, BorderLayout.SOUTH);

		this.setTitle("Chat Room");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		try {
			area.setText("Server started \n");
			ServerSocket server = new ServerSocket(8080);
			Socket socket = server.accept();
			area.setText("Client connected");

			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());

			while (true) {
				String recievedInfo = in.toString();

				area.setText(area.getText() + " \n" + recievedInfo);
			}
		} catch (IOException e) {
			System.err.print(e);
		}

	}

	public static void main(String[] args) {
		new ServerChat();
	}
}
