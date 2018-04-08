package com.example.jpa.jpaonetomanydemo.repository;

import com.example.jpa.jpaonetomanydemo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
}
