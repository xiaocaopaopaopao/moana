package lab.io.rush.dao.impl;

import lab.io.rush.dao.RedisGeneratorDao;
import lab.io.rush.dao.TicketDao;
import lab.io.rush.model.Ticket;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

public class TicketDaoImpl extends RedisGeneratorDao<String, Ticket> implements
		TicketDao {

	@Override
	public boolean addNumOfLastTickets2Cache(final Ticket ticket) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(String.valueOf(ticket.getId()));
				byte[] value = serializer.serialize(String.valueOf(ticket.getNumber()));
				connection.setNX(key, value);
				return true;
			}
		}, false, true);
		return result;
	}

	@Override
	public Integer getNumOfLastTicketsFromDB(int id) {
		System.out.println("DB");
		return 777;
	}

	@Override
	public Integer getNumOfLastTicketsFromCache(final int id) {
		Integer result = redisTemplate.execute(new RedisCallback<Integer>() {
			public Integer doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(String.valueOf(id));
				byte[] value = connection.get(key);
				if (value == null) {
					return -1;
				}
				return Integer.valueOf(serializer.deserialize(value));
			}
		});
		System.out.println("»º´æ");
		return result;
	}

	@Override
	public boolean updateNumOfLastTickets2Cache(final Ticket ticket) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(String.valueOf(ticket.getId()));
				byte[] value = serializer.serialize(String.valueOf(ticket.getNumber()));
				connection.set(key, value);
				return true;
			}
		});
		return result;
	}

	@Override
	public boolean syncFromDB2Cache() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean syncFromCache2DB() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buyTicket(Integer num) {
		// TODO Auto-generated method stub
		return false;
	}

}
