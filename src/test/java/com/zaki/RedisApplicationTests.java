package com.zaki;

import com.zaki.config.RedisConfig;
import com.zaki.domain.Pruduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	private RedisConnectionFactory redisFactory;
	@Autowired
	RedisTemplate<String, Object> template;

	@Test
	public void contextLoads() {
		Pruduct prud  = new Pruduct(1, "洗发水", "100ml");
		Pruduct prud2  = new Pruduct(2, "洗面奶", "200ml");
		//依次从尾部添加元素
		template.opsForList().rightPush("pruduct",prud);
		template.opsForList().rightPush("pruduct",prud2);
		List<Object> prodList = template.opsForList().range("pruduct",0,template.opsForList().size("pruduct")-1);
		for(Object obj:prodList){
			System.out.println((Pruduct)obj);
		}
		System.out.println("产品数量:"+template.opsForList().size("pruduct"));
	}

}
