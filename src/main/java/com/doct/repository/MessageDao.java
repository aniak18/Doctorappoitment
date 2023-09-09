package com.doct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doct.entity.Message;

public interface MessageDao extends JpaRepository<Message, Integer> {

}
