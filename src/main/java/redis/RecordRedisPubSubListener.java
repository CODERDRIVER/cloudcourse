package redis;

import redis.clients.jedis.JedisPubSub;

import com.google.gson.Gson;

import data.Record;

public class RecordRedisPubSubListener extends JedisPubSub {
	
	private Record record;

	
	public Record getRecord() {
		return record;
	}


	public void setRecord(Record record) {
		this.record = record;
	}


	@Override
	public void onMessage(String channel, String message) {
		Gson gson = new Gson();
		record = gson.fromJson(message, Record.class);
	}
	
	
}
