package com.example;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class Hello extends AbstractHandler {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    server.setHandler(new Hello());
    server.start();
    server.join();
  }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");

        // read environment variable
        String demoWord = System.getenv("DEMO_WORD");

        // write out response
        response.getWriter().println("Hello " + demoWord + " from San Francisco!");

        // write to logs
        Logger.getAnonymousLogger()
                .info("Log " + demoWord + " at " + System.currentTimeMillis());

        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
    }
}
