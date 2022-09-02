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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = -426453242145568482L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ID_USER_SEQ")
	private Long id;

	private String name;

	@NotNull
	@Email
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "WALLET_ID", referencedColumnName = "ID")
	private Wallet wallet;

}
