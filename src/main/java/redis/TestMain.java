package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestMain {

	private static Jedis jedis = new Jedis("119.23.75.180",6379);
	public static RedisMsgPubSubListener redisMsgPubSubListener = new RedisMsgPubSubListener();
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread2 = new TestSubscribe(redisMsgPubSubListener);
		Thread thread1 = new TestPublish();
		thread2.start();
		thread1.start();
	}

}
