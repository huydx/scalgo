package algorithm.other;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


//simulate http bug
public class TestHttpConnection {
    public static void main(String[] args) throws Exception {
        startHttpd();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://localhost:8080/").openConnection();
        if (!(httpURLConnection instanceof sun.net.www.protocol.http.HttpURLConnection)) {
            throw new IllegalStateException("Well it should really be sun.net.www.protocol.http.HttpURLConnection. "
                    + "Check if no library registered it's impl using URL.setURLStreamHandlerFactory()");
        }
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.connect();
        System.out.println("Reading from stream...");
        httpURLConnection.getInputStream().read();
        System.out.println("Done");
    }
    public static void startHttpd() throws Exception {
        InetSocketAddress addr = new InetSocketAddress(8080);
        HttpServer server = HttpServer.create(addr, 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                System.out.println("------> Httpd got request. Request method was:" + httpExchange.getRequestMethod() + " Throwing timeout exception");
                if (true) {
                    throw new SocketTimeoutException();
                }
            }
        });
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("Open for business.");
    }
}