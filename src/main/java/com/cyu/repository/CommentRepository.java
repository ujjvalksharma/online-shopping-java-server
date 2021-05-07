package com.cyu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cyu.model.Comment;
import com.cyu.model.Person;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	  @Query(  value = "select * from Comment where prod_id=?1",
			  nativeQuery = true)
	  public List<Comment> getCommentsByProductId(int productId); 
	  
	  @Query(  value = "select * from Comment where user_id=?1",
			  nativeQuery = true)
	  public List<Comment> getCommentsByUserId(int userId);
	  
}
