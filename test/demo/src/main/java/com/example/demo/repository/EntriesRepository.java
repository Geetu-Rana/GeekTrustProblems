package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Entries;

public interface EntriesRepository extends JpaRepository<Entries, Integer> {

}
