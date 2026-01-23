package com.example.cajeroservice.Repository;

import com.example.cajeroservice.JPA.DenominacionJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenominacionRepository extends JpaRepository<DenominacionJPA, Integer> {

}