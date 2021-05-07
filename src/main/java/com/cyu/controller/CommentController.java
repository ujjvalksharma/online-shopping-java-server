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
import com.cyu.service.CommentService;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/comment")
	public Comment addComment(@RequestBody Comment comment) {
		return commentService.createComment(comment);
	}
	
	@GetMapping("/comment")
	public List<Comment> getComments() {
		return commentService.findAllComments();
	}
	
	@GetMapping("comment/{prodId}")
	public List<Comment> getCommentsByProdId(@PathVariable(name = "prodId") int prodId) {
		return commentService.getCommentsByProdId(prodId);
	}

	@GetMapping("user/{userId}/comment")
	public List<Comment> getCommentsByUserId(@PathVariable(name = "userId") int userId) {
		return commentService.getCommentsByUserId(userId);
	}
	
	@DeleteMapping("comment/{commentId}")
	public Comment deleteCommentById(@PathVariable(name = "commentId") int commentId) {
		return commentService.deleteCommentById(commentId);
	}
	
	@PutMapping("comment/{commentId}/text/{text}")
	public Comment updateCommentText(@PathVariable(name = "commentId") int commentId,@PathVariable(name = "text") String text) {
		return commentService.updateCommentText(commentId,text);
	}
	

}
