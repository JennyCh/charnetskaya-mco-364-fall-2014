package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;

public class NetworkListener implements ActionListener {
	private final Canvas canvas;
	private boolean connected;
	private RecieveMessagesFromServer reciever;
	private final RightPanel rightPanel;

	public NetworkListener(Canvas canvas, RightPanel rightPanel) {
		this.canvas = canvas;
		this.connected = false;
		this.rightPanel = rightPanel;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		final JButton button = (JButton) event.getSource();
		if (connected) {
			try {
				disconnect(button);
			} catch (final UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				connect(button);
			} catch (final UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void connect(JButton networkButton) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		connected = true;

		this.reciever = new RecieveMessagesFromServer(canvas, rightPanel, true);
		reciever.start();
		networkButton.setText("Connected");

	}

	private void disconnect(JButton networkButton) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		connected = false;
		reciever.setConnected(false);
		rightPanel.setNetwordModule(new LoopBackNetworkModule(canvas));
		networkButton.setText("Disconnect");

	}

}
