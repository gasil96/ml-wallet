package com.ml.wallet.services;

import com.ml.wallet.constants.TypeOrder;
import com.ml.wallet.dtos.WalletDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface WalletService {

	void create(WalletDTO walletDTO);

	Page<WalletDTO> listAll(Pageable pageable);
	
	void orderFinished(TypeOrder type, BigDecimal orderPrice, Long orderQuantity, Long walletId);
	
}
