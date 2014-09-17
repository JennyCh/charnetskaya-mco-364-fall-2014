package charnetskaya.practiceNetworks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientHost extends JFrame {
	
	public static void main (String [] args){
		new ClientHost();
	}

	private JTextField textF = new JTextField();
	private JTextArea area = new JTextArea();
	
	private DataInputStream in;
	private DataOutputStream out;
	
	public ClientHost(){
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("Enter Radius "), BorderLayout.WEST);
		p.add(textF, BorderLayout.CENTER);
		textF.setHorizontalAlignment(JTextField.RIGHT);
		
		setLayout(new BorderLayout());
		add(p, BorderLayout.NORTH);
		add(new JScrollPane(area), BorderLayout.CENTER);
		
		textF.addActionListener(new TextFieldListener());
		
		this.setTitle("Client");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		try{
			Socket socket = new Socket("127.0.0.1", 8000);
			in = new DataInputStream(socket.getInputStream());
			
			out = new DataOutputStream(socket.getOutputStream());
		}catch(IOException e){
			area.append(e.toString() + "\n");
		}
	}
	
	private class TextFieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
				double radius = Double.parseDouble(textF.getText().trim());
				out.writeDouble(radius);
				out.flush();
				
				double a = in.readDouble();
				
			area.append("Radius is " + radius + "\n");
			area.append("Area recieved from the server is " + a + "\n");
			
			}catch(IOException e){
				System.err.println(e);
			}
			
		}
		
	}
}
