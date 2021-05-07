package com.cyu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyu.model.Comment;
import com.cyu.model.InnerComment;
import com.cyu.repository.InnerCommentRepository;

@Service
public class InnerCommentService {
	
	@Autowired
	InnerCommentRepository innerCommentRepository;
	
	public InnerComment createInnerComment(InnerComment comment) {
		return innerCommentRepository.save(comment);
	}
	
	public List<InnerComment> getInnerCommentByCommentId(int commentId) {
		return innerCommentRepository.getCommentsByCommentId(commentId);
		
	}
	

	public List<InnerComment> getCommentsByUserId(int userId) {
		return innerCommentRepository.getCommentsByUserId(userId);
		
	}
	
	public InnerComment deleteInnerCommentById(int innerCommentId) {
		InnerComment comment=innerCommentRepository.findById(innerCommentId).get();
		innerCommentRepository.deleteById(innerCommentId);
		 return comment;
	}
	
	
	public InnerComment updateInnerCommentText(int innerCommentId, String newText) {
		InnerComment innerComment=innerCommentRepository.findById(innerCommentId).get();
		innerComment.setText(newText);
		innerCommentRepository.save(innerComment);
		return innerComment;
	}
	
	

}
