package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.vti.entity.RegistrationUserToken;

public interface IRegistrationUserTokenRepository
		extends JpaRepository<RegistrationUserToken, Short>, JpaSpecificationExecutor<RegistrationUserToken> {

}
