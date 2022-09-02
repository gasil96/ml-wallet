package com.ml.wallet.services.rabbit;

import com.ml.wallet.constants.TypeOrder;
import com.ml.wallet.dtos.OrderDTO;
import com.ml.wallet.services.WalletService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RabbitMqReceiverTest {

	private static final Long ID = 1L;
	private static final BigDecimal PRICE = BigDecimal.TEN;
	private static final Long QUANTITY = 100L;
	private final OrderDTO ORDER_MOCK = builderOrderDTO();

	@InjectMocks
	private RabbitMqReceiver rabbitMqReceiver;

	@Mock
	private WalletService walletService;

	@Test
	public void receivedMessageWithSuccess() {
		rabbitMqReceiver.receivedMessage(ORDER_MOCK);

		verify(walletService).orderFinished(ORDER_MOCK.getTypeOrder(), ORDER_MOCK.getPrice(),
				ORDER_MOCK.getQuantity(), ORDER_MOCK.getWalletID());
	}

	private OrderDTO builderOrderDTO() {
		return OrderDTO.builder()
				.walletID(ID)
				.price(PRICE)
				.quantity(QUANTITY)
				.typeOrder(TypeOrder.BUY)
				.build();
	}

}
