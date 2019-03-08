package com.aaa.ssm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
@Component
public class JedisUtilImpl implements JedisUtil {
@Autowired
   /* private  JedisPool jedisPool;*/
    private JedisCluster jedisCluster;

    @Override
    public void putObject(Object key, Object value) {
        // TODO Auto-generated method stub
        //Jedis resource = jedisPool.getResource();
        jedisCluster.set(SerializeUtil.serialize(key.toString()),
                SerializeUtil.serialize(value));
        //resource.close();
    }
    @Override
    public Object removeObject(Object arg0) {
        // TODO Auto-generated method stub
        /*Jedis resource = jedisPool.getResource();*/
        Object expire = jedisCluster.expire(
                SerializeUtil.serialize(arg0.toString()), 0);
       /* resource.close();*/
        return expire;
    }
    @Override
    public Object getObject(Object arg0) {
        // TODO Auto-generated method stub
       /* Jedis resource = jedisPool.getResource();*/
        Object value = SerializeUtil.unserialize(jedisCluster.get(
                SerializeUtil.serialize(arg0.toString())));
        /*resource.close();*/
        return value;
    }
}
