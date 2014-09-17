package sendingObjects;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class StudentClient extends JFrame {
	
	private JTextField name = new JTextField(20);
	private JTextField street = new JTextField(20);
	private JTextField city = new JTextField(20);
	private JTextField state = new JTextField(20);
	private JTextField zip = new JTextField(20);

	private JButton submit = new JButton ("Submit");
	
	
	
	
	String host = "localhost";
	
	public StudentClient(){
		this.setLayout(new FlowLayout());
		this.add(name);
		this.add(street);
		this.add(city);
		this.add(state);
		this.add(zip);
		
		this.add(submit);
		this.submit.addActionListener(new ButtonListener());
		this.setTitle("Client");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 300);
		
		this.setVisible(true);
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			try{
				Socket socket = new Socket(host, 8000);
				ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
				
				String nam = name.getText().trim();
				String str = street.getText().trim();
				String cit = city.getText().trim();
				String sta = state.getText().trim();
				String zi = zip.getText().trim();
				
				StudentAddress address = new StudentAddress (nam, str, cit, sta, zi);
			}catch(IOException ex){
				System.err.println(ex);
			}
		}
	}
	
	public static void main (String [] args){
		new StudentClient();
	}
}
