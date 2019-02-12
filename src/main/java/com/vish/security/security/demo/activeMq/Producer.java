package com.vish.security.security.demo.activeMq;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Producer {

	private static final Logger LOGGER = LogManager.getLogger(Producer.class);

	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;
	private Scanner in = new Scanner(System.in);

	public void create(String destinationName) throws JMSException {

		// create a Connection Factory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

		// create a Connection
		connection = connectionFactory.createConnection();

		// create a Session
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// create the Destination to which messages will be sent
		Destination destination = session.createQueue(destinationName);

		// create a Message Producer for sending messages
		messageProducer = session.createProducer(destination);
	}

	public void close() throws JMSException {
		connection.close();
	}

	public void sendName(String firstName, String lastName) throws JMSException {

		String text = firstName + " " + lastName;
		
		String input=in.nextLine();
		text=text.concat(" "+input);

		// create a JMS TextMessage
		Message textMessage = session.createTextMessage(text);

		// send the message to the queue destination
		messageProducer.send(textMessage);

		LOGGER.debug("producer sent message with text='{}'", text);
	}
}
