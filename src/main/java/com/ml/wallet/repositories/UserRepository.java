package com.ml.wallet.repositories;

import com.ml.wallet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
