package com.palmap.examples.rabbitmq;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 
 * ������Ĳ������У�������һ���������̣߳�Ȼ��ʼ������������Ϣ����Щ��Ϣ�ᱻ������ȡ�ߡ�
 * 
 * @author lifeng
 * 
 */
public class Main {
	public Main() throws Exception {

		QueueConsumer consumer = new QueueConsumer("palmap");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		Producer producer = new Producer("palmap");

		for (int i = 0; i < 1000000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number " + i + " sent.");
		}
	}

	/**
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
		new Main();
	}
}
