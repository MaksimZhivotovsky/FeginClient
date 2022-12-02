package com.exempl.max.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exempl.max.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
