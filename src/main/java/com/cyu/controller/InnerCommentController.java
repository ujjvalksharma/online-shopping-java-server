package com.cyu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyu.model.Comment;
import com.cyu.model.InnerComment;
import com.cyu.service.InnerCommentService;

@RestController
@CrossOrigin(origins = "*")
public class InnerCommentController {

	@Autowired
	InnerCommentService innerCommentService;
	
	@PostMapping("/innercomment")
	public InnerComment addInnerComment(@RequestBody InnerComment innerComment) {
		System.out.println(innerComment);
		return innerCommentService.createInnerComment(innerComment);
	}
	
	
	@GetMapping("innercomment/{commentId}")
	public List<InnerComment> getInnerCommentByCommentId(@PathVariable(name = "commentId") int commentId) {
		return innerCommentService.getInnerCommentByCommentId(commentId);
	}
	
	@GetMapping("user/{userId}/innercomment")
	public List<InnerComment> getCommentsByUserId(@PathVariable(name = "userId") int userId) {
		return innerCommentService.getCommentsByUserId(userId);
	}
	
	@DeleteMapping("innercomment/{innercomment}")
	public InnerComment deleteInnerCommentById(@PathVariable(name = "innercomment") int innercomment) {
		return innerCommentService.deleteInnerCommentById(innercomment);
	}
	
	@PutMapping("innercomment/{innercommentId}/text/{text}")
	public InnerComment updateCommentText(@PathVariable(name = "innercommentId") int innercommentId,@PathVariable(name = "text") String text) {
		return innerCommentService.updateInnerCommentText(innercommentId,text);
	}
	
}
