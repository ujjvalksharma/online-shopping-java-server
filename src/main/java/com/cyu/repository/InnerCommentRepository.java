package com.cyu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cyu.model.InnerComment;

public interface InnerCommentRepository extends JpaRepository<InnerComment, Integer> {

	@Query(  value = "select * from inner_comment where comment_id=?1",
			  nativeQuery = true)
	public List<InnerComment> getCommentsByCommentId(int commentId);
	
	@Query(  value = "select * from inner_comment where user_id=?1",
			  nativeQuery = true)
	public List<InnerComment> getCommentsByUserId(int userId);
	
	
}
