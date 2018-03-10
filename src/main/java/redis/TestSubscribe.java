package redis;

import redis.clients.jedis.Jedis;

public class TestSubscribe extends Thread {

	private RedisMsgPubSubListener redisMsgPubSubListener;
	public TestSubscribe()
	{
		
	}
	public TestSubscribe(RedisMsgPubSubListener redisMsgPubSubListener)
	{
		this.redisMsgPubSubListener = redisMsgPubSubListener;
	}
	@Override
	public void run() {
		Jedis jedis = new Jedis("119.23.75.180",6379);
		jedis.auth("1234");
		jedis.subscribe(redisMsgPubSubListener, "redisChat");
	}
}
