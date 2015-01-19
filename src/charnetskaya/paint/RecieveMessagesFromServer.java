package charnetskaya.paint;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import charnetskaya.paint.Message.PaintMessage;
import charnetskaya.paint.Message.PaintMessageFactory;

public class RecieveMessagesFromServer extends Thread {

	private final Canvas canvas;
	private boolean connected;
	private final PaintMessageFactory paintFactory;
	private Socket socket;
	private final RightPanel panel;

	public RecieveMessagesFromServer(Canvas canvas, RightPanel panel, boolean connected) throws UnknownHostException,
			IOException {
		this.canvas = canvas;
		this.connected = connected;
		this.paintFactory = new PaintMessageFactory(canvas);
		this.panel = panel;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public boolean isConnected() {
		return connected;
	}

	public PaintMessageFactory getPaintFactory() {
		return paintFactory;
	}

	@Override
	public void run() {
		if (connected) {
			super.run();

			try {
				// schwimmer's computer IP - 192.168.117.107
				socket = new Socket("localhost", 3773);
				final PrintWriter writer = new PrintWriter(socket.getOutputStream());
				// System.out.println(panel);
				panel.setNetwordModule(new OnlineNetworkModule(writer));
				final InputStream in = socket.getInputStream();
				final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String message;
				// System.out.println("here");
				while (true) {
					while ((message = reader.readLine()) != null && connected) {
						System.out.println("recieved message " + message);
						if (!"".equals(message)) {
							final PaintMessage msg = paintFactory.getMessage(message);
							if (message != null) {
								try {
									System.out.print("IS ACTIVE LAYER ");
									System.out.println(canvas.getImages().get(canvas.getActiveLayer()) == null);
									msg.apply((Graphics2D) canvas.getImages().get(canvas.getActiveLayer())
											.getGraphics());
								} catch (final Exception e) {
									e.printStackTrace();
								}
								canvas.repaint();
							}
						}
					}
				}
			} catch (final Exception e) {
				e.printStackTrace();
				System.out.println("EXCEPTION!!!!!!!!!!!!!!!!");
			}

		}

	}
}
