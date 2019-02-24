package com.github.elazar.hadoop.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HadoopRpcClient {

    public static InetSocketAddress addr = new InetSocketAddress("localhost", 5121);


    public static void client() throws IOException {
        final HadoopRpcServer.PingProtocol proxy = RPC.getProxy(HadoopRpcServer.PingProtocol.class, RPC.getProtocolVersion(HadoopRpcServer.PingProtocol.class),
                addr, new Configuration());
        System.out.println("Client: ping hi " + proxy.ping());
    }

    public static void main(String[] args ) throws IOException {

        client();

    }
}
















