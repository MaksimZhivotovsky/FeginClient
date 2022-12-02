package com.exempl.max.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exempl.max.model.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

}
