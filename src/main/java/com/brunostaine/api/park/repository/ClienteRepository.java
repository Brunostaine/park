package com.brunostaine.api.park.repository;

import com.brunostaine.api.park.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
