package com.example.messagingrabbitmq;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	RestTemplate restTemplate;

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
		/*String result = restTemplate.getForObject("https://www.google.fr", String.class);
		System.out.println(result);*/

		httpRequest();
		System.out.println("Hello google");
		
		latch.countDown();
	}


	public void httpRequest() {
		String result = restTemplate.getForObject("https://www.google.fr", String.class);
		System.out.println(result);
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
