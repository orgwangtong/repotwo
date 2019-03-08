package com.aaa.ssm.util;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class TestRedisClusterConnect {
    public static void main(String[] args) {
        Set<HostAndPort> hps = new HashSet();
        hps.add(new HostAndPort("192.168.179.20",7001));
        hps.add(new HostAndPort("192.168.179.20",7002));
        hps.add(new HostAndPort("192.168.179.20",7003));
        hps.add(new HostAndPort("192.168.179.21",7004));
        hps.add(new HostAndPort("192.168.179.21",7005));
        hps.add(new HostAndPort("192.168.179.21",7006));
        JedisCluster jedisCluster = new JedisCluster(hps);
        jedisCluster.set("eee","555");
        String s = jedisCluster.get("eee");
        System.out.println(s);

    }
}
