package com.ml.wallet.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WALLET")
public class Wallet implements Serializable {

	private static final long serialVersionUID = 3043009784052678287L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ID_WALLET_SEQ")
	private Long id;

	@Builder.Default
	private BigDecimal balance = BigDecimal.ZERO;

	@Builder.Default
	private Long product = 0L;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "wallet")
	private User user;

}
