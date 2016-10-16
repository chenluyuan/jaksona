package com.jaksona.app.cache;

import com.jaksona.app.config.CacheConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.charset.Charset;

/**
 * @author jaksona
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CacheConfig.class})
public class RedisCacheTest {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void testAdd() {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set("test".getBytes(Charset.forName("UTF-8")), "testValue".getBytes(Charset.forName("UTF-8")), Expiration.seconds(100), RedisStringCommands.SetOption.UPSERT);
				return null;
			}
		});
	}
}
