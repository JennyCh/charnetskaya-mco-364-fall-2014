package charentskaya.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class JettyServer extends AbstractHandler {
	
	public static void main (String [] args) throws Exception{
		
		Server server = new Server(1891);
		server.start();
		
		
	}

	@Override
	public void handle(String arg0, Request arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
