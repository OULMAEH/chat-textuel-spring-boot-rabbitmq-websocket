package com.chat.rabbitmq;

import org.springframework.stereotype.Component;

/**
 * @Author yassi
 * @Project: chat
 * @Created 25-06-2021
 *
 */
@Component
public class Rabbit{
	
		//@Value("${spring.rabbitmq.host}")
		private String host;
		
		//@Value("${spring.rabbitmq.port}")
		private int port;
		
		//@Value("${spring.rabbitmq.username}")
		private String user;
		
		//@Value("${spring.rabbitmq.password}")
		private String pass;
		
		//@Value("${spring.rabbitmq.exchange}")
		private String exchange ;
	
		//@Value("${spring.rabbitmq.queue}")
		private String queue="clientQueue";
	
		//@Value("${spring.rabbitmq.routingKey}")
		private String routingKey;

		/**
		 * 
		 */
		public Rabbit() {
			super();
		}

		/**
		 * @param host
		 * @param port
		 * @param user
		 * @param pass
		 * @param exchange
		 * @param queue
		 * @param routingKey
		 */
		public Rabbit(String host, int port, String user, String pass, String exchange, String queue,
				String routingKey) {
			super();
			this.host = host;
			this.port = port;
			this.user = user;
			this.pass = pass;
			this.exchange = exchange;
			this.queue = queue;
			this.routingKey = routingKey;
		}

		/**
		 * @return the host
		 */
		public String getHost() {
			return host;
		}

		/**
		 * @param host the host to set
		 */
		public void setHost(String host) {
			this.host = host;
		}

		/**
		 * @return the port
		 */
		public int getPort() {
			return port;
		}

		/**
		 * @param port the port to set
		 */
		public void setPort(int port) {
			this.port = port;
		}

		/**
		 * @return the user
		 */
		public String getUser() {
			return user;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(String user) {
			this.user = user;
		}

		/**
		 * @return the pass
		 */
		public String getPass() {
			return pass;
		}

		/**
		 * @param pass the pass to set
		 */
		public void setPass(String pass) {
			this.pass = pass;
		}

		/**
		 * @return the exchange
		 */
		public String getExchange() {
			return exchange;
		}

		/**
		 * @param exchange the exchange to set
		 */
		public void setExchange(String exchange) {
			this.exchange = exchange;
		}

		/**
		 * @return the queue
		 */
		public String getQueue() {
			return queue;
		}

		/**
		 * @param queue the queue to set
		 */
		public void setQueue(String queue) {
			this.queue = queue;
		}

		/**
		 * @return the routingKey
		 */
		public String getRoutingKey() {
			return routingKey;
		}

		/**
		 * @param routingKey the routingKey to set
		 */
		public void setRoutingKey(String routingKey) {
			this.routingKey = routingKey;
		}

	}

