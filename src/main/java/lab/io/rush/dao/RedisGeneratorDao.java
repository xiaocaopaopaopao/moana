package lab.io.rush.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public abstract class RedisGeneratorDao<K extends Serializable, V extends Serializable> {
	  @Autowired
	  protected RedisTemplate<K,V> redisTemplate ;
	  
	  public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) { 
	    this.redisTemplate = redisTemplate; 
	  } 
	     
	  /**
	   * ªÒ»° RedisSerializer
	   */ 
	  protected RedisSerializer<String> getRedisSerializer() { 
	    return redisTemplate.getStringSerializer(); 
	  }
}
