package com.example.ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManyToMany.model.Tag;

public interface tagRepository extends JpaRepository<Tag, Long> {

}
