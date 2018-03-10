package redis;

import redis.clients.jedis.JedisPubSub;
/**
 * 监听类
 * @author lxy
   @version
		1.0,2017年12月16日 下午10:07:55
 *
 */
public class RedisMsgPubSubListener extends JedisPubSub {
	private String data = null;
	
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void onMessage(String channel, String message) {
		data = message;
		System.out.println("channel "+channel+"receive message: "+message);
	}
	
	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		System.out.println("channel "+channel+"is been subscribed"+subscribedChannels);
	}
	
	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		System.out.println("channel:"+channel+"is been unsubscribed:"+subscribedChannels);
	}

}
