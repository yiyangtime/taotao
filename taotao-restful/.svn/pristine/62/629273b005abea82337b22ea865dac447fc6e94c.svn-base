package com.taotao.jedis;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	/**
	 * 测试单机版
	 */
	@Test
	public void testJedisSingle() {
		//创建一个jedis对象
		Jedis jedis=new Jedis("192.168.0.128", 6379);
		//调用jedis对象方法
		jedis.set("hello", "aaaaaaaaaaaaaaaa");
		String string=jedis.get("hello");
		System.out.println(string);
		//关闭jedis
		jedis.close();
	}
	
	/**
	 * 使用连接池
	 */
	@Test
	public void testJedisPool() {
		//创建Jedis连接池
		JedisPool pool=new JedisPool("192.168.0.128", 6379);
		//从连接池中获取jedis对象
		Jedis jedis=pool.getResource();
		String string=jedis.get("hello");
		System.out.println(string);
		//关闭jedis
		jedis.close();
		//关闭jedis连接池
		pool.close();
	}
	
	/**
	 * 集群版测试
	 * @throws Exception 
	 */
	@Test
	public void testJedisCluster() throws Exception {
		//设置集群节点
		HashSet<HostAndPort> nodes=new HashSet<>();
		nodes.add(new HostAndPort("192.168.0.128", 7001));
		nodes.add(new HostAndPort("192.168.0.128", 7002));
		nodes.add(new HostAndPort("192.168.0.128", 7003));
		nodes.add(new HostAndPort("192.168.0.128", 7004));
		nodes.add(new HostAndPort("192.168.0.128", 7005));
		nodes.add(new HostAndPort("192.168.0.128", 7006));
		//将节点添加到jedis集群对象
		JedisCluster cluster=new JedisCluster(nodes);
		//添加值
		cluster.set("key1", "1000");
		//获取值
		String string=cluster.get("key1");
		System.out.println(string);
		//关闭集群对象
		cluster.close();
	}
	
	/**
	 * Spring整合jedis单机版测试
	 */
	@SuppressWarnings("resource")
	@Test
	public void testSpringJedisSingle() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisPool pool=(JedisPool) applicationContext.getBean("redisClient");
		Jedis jedis=pool.getResource();
		String string=jedis.get("hello");
		System.out.println(string);
		jedis.close();
		pool.close();
	}
	
	/**
	 * Spring整合jedis集群版测试
	 * @throws Exception 
	 */
	@SuppressWarnings("resource")
	@Test
	public void testSpringJedisCluster() throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisCluster cluster=(JedisCluster) applicationContext.getBean("redisClient");
		String string=cluster.get("key1");
		System.out.println(string);
		cluster.close();
	}
}
