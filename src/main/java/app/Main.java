package app;


import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

    public static void main(String[] args) {
        Server server = new Server();
        SelectChannelConnector scc = new SelectChannelConnector();
        String port = System.getenv("PORT");
        scc.setPort(Integer.parseInt(port));
        server.setConnectors(new Connector[]{scc});

        WebAppContext context = new WebAppContext();
        context.setServer(server);
        context.setContextPath("/");
        context.setWar("src/main/webapp");

        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception exc) {
            exc.printStackTrace();
            System.exit(100);
        }
    }
}
