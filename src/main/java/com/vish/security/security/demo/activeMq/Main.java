package com.vish.security.security.demo.activeMq;

import javax.jms.JMSException;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Main {

	private static Producer producer;
	private static Consumer consumer;

	public static void main(String[] args) throws JMSException {
		
		producer = new Producer();
	    producer.create("helloworld.q");
	    System.out.println("created queue!!!");
	    producer.sendName("Vishal", "Londhe");
	    consumer = new Consumer();
	    consumer.create("helloworld.q");
	    System.out.println("consumed queue!!!");
	    ;
	    System.out.println("Hello "+consumer.getGreeting(1000));
		
	}
}
