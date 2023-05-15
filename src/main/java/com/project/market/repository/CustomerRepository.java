package com.project.market.repository;

import com.project.market.model.SignUpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<SignUpForm, Long> {

}

