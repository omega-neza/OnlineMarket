package com.project.market.repository;

import com.project.market.model.SignUpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpForm, Long> {
        SignUpForm findByEmailAndPassword(String email, String password);

       Optional<SignUpForm> findById(Long id);
    }


