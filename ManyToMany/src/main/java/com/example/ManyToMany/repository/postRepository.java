package com.example.ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ManyToMany.model.Post;
@Repository
public interface postRepository extends JpaRepository<Post, Long> {

}
