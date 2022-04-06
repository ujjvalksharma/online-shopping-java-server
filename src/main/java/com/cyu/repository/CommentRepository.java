package com.cyu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cyu.model.Comment;
import com.cyu.model.Person;

@Repository : this means that CommentRepository is A repository is a mechanism for encapsulating storage, 
                   retrieval, and search behavior which emulates a collection of objects.
	      JpaRepository is a JPA (Java Persistence API) specific extension of Repository. 
	     It contains the full API of CrudRepository and PagingAndSortingRepository.
			   
			                                 <database_object_class,primary_key>
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	  @Query(  value = "select * from Comment where prod_id=?1",
			  nativeQuery = true) // to write query
	  public List<Comment> getCommentsByProductId(int productId); 
	  
	  @Query(  value = "select * from Comment where user_id=?1",
			  nativeQuery = true)
	  public List<Comment> getCommentsByUserId(int userId);
	  
	  
	  public Comment findByValue(String value); //immbeded method query
	  
}
