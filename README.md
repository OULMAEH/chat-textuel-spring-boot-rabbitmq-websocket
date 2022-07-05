# README #

This README have steps are necessary to get your application up and running.

### Introduction ###

in this repositoy we are using RabbitMQ broker and webSocket 

to use this two we need to

### Install RabbitMQ ###

* for macOs using Homebrew run this command :

	brew install rabbitmq

it will install RabbitMQ and erlang at the same time 

* for Windows it requires 64 bit :
first we need to instal erlang 

	https://github.com/erlang/otp/releases/download/OTP-24.0/otp_win64_24.0.exe

* then install RabbitMQ version 3.8.16 :

	https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.16/rabbitmq-server-3.8.16.exe
	
* tutorial from youtube for installing rabbitMQ
	
	https://www.youtube.com/watch?v=TYgrkA5CxdE

> for more informations visit the website [click here ](https://www.rabbitmq.com/download.html)

### Plugins to be activated in RabbitMQ ###

* We need few command to enable some plugins we need in our developpement

The RabbitMQ management plugin provides an API for management and monitoring of RabbitMQ to access to the management of RabbitMQ in localhost we need to enable this plugin
#####all this command run in sbin folder 
######C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.16\sbin>

	rabbitmq-plugins enable rabbitmq_management

##### management localhost

	http://localhost:15672/

to use the Stomp protocole between Rabbit and WebSocket we need to enable this plugin

	rabbitmq-plugins enable rabbitmq_stomp

### how to run server Rabbit? ###

#####Windows

* in sbin folder or search 'rabbitMq command Prompt (sbin dir)' and run this :

	rabbitmq-server

#####MacOs

* macOs :

	brew services start rabbitmq