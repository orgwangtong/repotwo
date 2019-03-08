package com.aaa.ssm.util;

import redis.clients.jedis.Jedis;

public class TestRedisConnect {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.179.20",6379);
        System.out.println(jedis.ping());
        System.out.println(SerializeUtil.serialize("userList"));
    }
}
