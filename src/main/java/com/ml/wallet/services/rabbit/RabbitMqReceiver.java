package com.ml.wallet.services.rabbit;

import com.ml.wallet.dtos.OrderDTO;
import com.ml.wallet.services.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {

	@Autowired
	private WalletService walletService;

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

	}

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receivedMessage(OrderDTO order) {
		log.debug("RabbitMqReceiver.receivedMessage - Input - order: {}", order);

		walletService.orderFinished(order.getTypeOrder(), order.getPrice(), order.getQuantity(), order.getWalletID());

		log.debug("RabbitMqReceiver.receivedMessage - End");
	}

}
