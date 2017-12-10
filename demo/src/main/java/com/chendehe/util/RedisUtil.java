package com.chendehe.util;

import com.chendehe.config.RedisConfig;
import io.codis.jodis.JedisResourcePool;
import io.codis.jodis.RoundRobinJedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * <p>redis.conf 设置 protected-mode no .</p>
 * <p>用 src/redis-server redis.conf 启动.</p>
 */
@Component
public final class RedisUtil {
  private RedisUtil() {
  }

  private static Jedis jedis;

  @Autowired
  private void init(RedisConfig config) {
    jedis = new Jedis(config.getHost(), config.getPort());
  }

  public static String set(String key, String value) {
    return jedis.set(key, value);
  }

  public static String get(String key) {
    return jedis.get(key);
  }

//  public static void main(String[] args) {
//    JedisResourcePool jedisPool = RoundRobinJedisPool.create()
//        .curatorClient("zkserver:2181", 30000).zkProxyDir("/jodis/xxx").build();
//    try (Jedis jedis = jedisPool.getResource()) {
//      jedis.set("foo", "bar");
//      String value = jedis.get("foo");
//      System.out.println(value);
//    }
//  }

}
