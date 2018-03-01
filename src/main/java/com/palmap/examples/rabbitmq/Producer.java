package com.palmap.examples.rabbitmq;

import java.io.IOException;
import java.io.Serializable;
import org.apache.commons.lang3.SerializationUtils;

import com.rabbitmq.client.MessageProperties;

/**
 * 
 * ����������������������дһ����Ϣ������ʹ��Apace Commons Lang�ѿ����л���Java����ת���� byte ���顣commons
 * lang��maven�������£�
 * 
 * @author lifeng
 * 
 */
public class Producer extends EndPoint {
	  public Producer(String endPointName) throws IOException{
	        super(endPointName);
	    }
	 
	    public void sendMessage(Serializable object) throws IOException {
	        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
	    }
}
