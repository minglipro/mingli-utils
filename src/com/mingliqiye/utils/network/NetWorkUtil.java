package com.mingliqiye.utils.network;

public class NetWorkUtil {

    public static void main(String[] args) {
        System.out.println(NetworkEndpoint.of("127.0.0.1", 25565));
        System.out.println(NetworkEndpoint.of("127.0.0.1:25565"));
        System.out.println(NetworkEndpoint.of("127.0.0.1:25565"));
    }
}
