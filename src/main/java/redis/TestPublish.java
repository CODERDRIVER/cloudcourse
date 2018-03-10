package redis;

import redis.clients.jedis.Jedis;

public class TestPublish extends Thread{
	
	@Override
	public void run() {
		Jedis jedis = new Jedis("119.23.75.180",6379);
		jedis.auth("1234");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jedis.publish("redisChat", "Redis is a great caching technique");
		System.out.println(TestMain.redisMsgPubSubListener.getData());
		jedis.publish("redisChat", "build your dream");
		
		jedis.publish("redisChat", "over");
	}

}
