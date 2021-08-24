package com.shareup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shareup.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

}
