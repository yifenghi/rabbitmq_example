package com.palmap.examples.rabbitmq;

import java.io.IOException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 
 * ��������дһ���࣬���������ߺ�������ͳһΪ EndPoint���͵Ķ��С� �����������߻��������ߣ� ���Ӷ��еĴ��붼��һ���ģ���������ͨ��һЩ��
 * 
 * @author lifeng
 * 
 */
public abstract class EndPoint {
	protected Channel channel;
	protected Connection connection;
	protected String endPointName;
	//protected String name

	public EndPoint(String endpointName) throws IOException {
		this.endPointName = endpointName;

		// Create a connection factory
		ConnectionFactory factory = new ConnectionFactory();

		// hostname of your rabbitmq server
		//factory.setHost("192.168.0.102");
		factory.setHost("192.168.0.202");
		// getting a connection
		connection = factory.newConnection();

		// creating a channel
		channel = connection.createChannel();

		// declaring a queue for this channel. If queue does not exist,
		// it will be created on the server.
		channel.queueDeclare(endpointName, false, false, false, null);
	}

	/**
	 * �ر�channel��connection�����Ǳ��룬��Ϊ�������Զ����õġ�
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		this.channel.close();
		this.connection.close();
	}
}
