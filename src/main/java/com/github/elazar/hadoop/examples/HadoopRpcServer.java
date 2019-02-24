package com.github.elazar.hadoop.examples;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolInfo;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HadoopRpcServer {

  //  @ProtocolInfo(protocolName = "ping", protocolVersion = 1)
    public static interface PingProtocol  {
        String ping();
    }

    public static class Ping implements PingProtocol {
        public String ping() {
            System.out.println("Server: ");
            return "pong pong pong hive";
        }
    }

    public static InetSocketAddress addr = new InetSocketAddress("localhost", 5121);

    public static RPC.Server server() throws IOException {
        final RPC.Server server = new RPC.Builder(new Configuration()).
                setBindAddress(addr.getHostName()).
                setPort(addr.getPort()).
                setInstance(new HadoopRpcServer.Ping()).
                setProtocol(HadoopRpcServer.PingProtocol.class).
                build();
        server.start();
        return server;
    }

    public static void main(String[] args) throws IOException {

        server();

    }

}
