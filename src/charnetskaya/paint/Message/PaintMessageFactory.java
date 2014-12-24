package charnetskaya.paint.Message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PaintMessageFactory {
	
	private Socket socket;
	private OutputStream out;
	public Socket getSocket() {
		return socket;
	}

	public OutputStream getOut() {
		return out;
	}

	public PaintMessageFactory() throws UnknownHostException, IOException{

		/*
		 * 3773 192.168.177.107
		 * 
		 * 192.168.177.152
		 */
		
			socket = new Socket("192.168.117.107", 3773);
			// once connection is made, send it back to the UI
			

			out = socket.getOutputStream();
			
			
		
	}

	public PaintMessage getMessage(String paintMessage) {

		final Scanner s = new Scanner(paintMessage);
		PaintMessage message = null;
		switch (MessageType.valueOf(s.next())) {
		case LINE:
			message = new LineMessage(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
			break;
		case SHAPE:
			message = new ShapeMessage(ShapeType.valueOf(s.next()), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(),
					s.nextInt(), s.nextInt(), Boolean.valueOf(s.next()));
			break;
		case CLEAR:
			message = new ClearMessage();
			break;
		case BUCKET_FILL:
			message = new BucketFillMessage(s.nextInt(), s.nextInt(), s.nextInt());
			break;
		}
		return message;
	}
}
