package com.cyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyu.model.Comment;
import com.cyu.repository.CommentRepository;

@Service : is basically @compoenent, but it is strictly/specifially used to write business logic 
            such as taling to dao or repositrty to get object and return to controller
public class CommentService {
	
	@Autowired : to get singleton object of that class used dependecy injection
	CommentRepository commentRepository;
	
	public List<Comment> getCommentsByProdId(int prodId) {
		List<Comment> comments= commentRepository.getCommentsByProductId(prodId);
		
		return comments;
	}
	public List<Comment> getCommentsByUserId(int userId) {
		List<Comment> comments= commentRepository.getCommentsByUserId(userId);
		
		return comments;
	}
	
	public Comment createComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}

	public List<Comment> findAllComments(){
		return commentRepository.findAll();
	}
	
	public Comment deleteCommentById(int commentId) {
		Comment comment=commentRepository.findById(commentId).get();
		 commentRepository.deleteById(commentId);
		 return comment;
	}
	
	public Comment updateCommentText(int commentId, String newText) {
		Comment comment=commentRepository.findById(commentId).get();
		comment.setText(newText);
		commentRepository.save(comment);
		return comment;
	}
	
	
}
