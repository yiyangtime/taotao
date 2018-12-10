package com.taotao.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.taotao.order.dao.JedisClient;
/**
 * 
 * 单机版dao    
 * @ProjectName:  [taotao-restful]   
 * @Package:      [com.taotao.restful.dao.impl]    
 * @ClassName:    [JedisClientSingle]     
 * @Description:  [一句话描述该类的功能]     
 * @Author:       [yiyan]     
 * @CreateDate:   [2017年9月23日 下午5:40:22]     
 * @UpdateUser:   [yiyan]     
 * @UpdateDate:   [2017年9月23日 下午5:40:22]     
 * @UpdateRemark: [说明本次修改内容]    
 * @Version:      [v1.0]   
 *
 */
public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool jedisPool;
	
	/**
	 * 取值
	 */
	@Override
	public String get(String key) {
		Jedis jedis=jedisPool.getResource();
		String string=jedis.get(key);
		jedis.close();
		return string;
	}

	/**
	 * 赋值
	 */
	@Override
	public String set(String key, String value) {
		Jedis jedis=jedisPool.getResource();
		String string=jedis.set(key, value);
		jedis.close();
		return string;
	}

	/**
	 * 散列类型取值
	 */
	@Override
	public String hget(String hkey, String key) {
		Jedis jedis=jedisPool.getResource();
		String string=jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	/**
	 * 散列类型赋值
	 */
	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis=jedisPool.getResource();
		long result=jedis.hset(hkey, key, value);
		jedis.close();
		return result;
	}

	/**
	 * incr递增1并返回递增后的结果
	 */
	@Override
	public long incr(String key) {
		Jedis jedis=jedisPool.getResource();
		long result=jedis.incr(key);
		jedis.close();
		return result;
	}

	/**
	 * redis中键的生存时间（expire）
	 */
	@Override
	public long expire(String key, int second) {
		Jedis jedis=jedisPool.getResource();
		long result=jedis.expire(key, second);
		jedis.close();
		return result;
	}

	/**
	 * ttl 查看键的剩余生存时间
	 */
	@Override
	public long ttl(String key) {
		Jedis jedis=jedisPool.getResource();
		long result=jedis.ttl(key);
		jedis.close();
		return result;
	}

	/**
	 * 删除
	 */
	@Override
	public long del(String key) {
		Jedis jedis=jedisPool.getResource();
		long result=jedis.del(key);
		return result;
	}

	/**
	 * 散列类型删除
	 */
	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis=jedisPool.getResource();
		long result=jedis.hdel(hkey, key);
		return result;
	}

}
