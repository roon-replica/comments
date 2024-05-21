package roon.practice.comments.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.domain.PostRepository;
import roon.practice.comments.domain.comment.Comment;
import roon.practice.comments.domain.comment.CommentRepository;
import roon.practice.comments.infra.IdGenerator;
import roon.practice.comments.ui.request.CreateCommentReq;
import roon.practice.comments.ui.request.UpdateCommentReq;
import roon.practice.comments.ui.response.CommentRes;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	public String create(CreateCommentReq request) {
		var post = postRepository.findById(request.postId())
				.orElseThrow(() -> new DocumentNotFoundException(request.postId()));

		var comment = new Comment(IdGenerator.id(), request.postId(), request.authorId(), request.contents(), request.parentId());
		var id = commentRepository.save(comment).getId();
		post.increaseReplyCount();
		postRepository.save(post);
		return id;
	}

	public String update(UpdateCommentReq request) {
		postRepository.findById(request.postId())
				.orElseThrow(() -> new DocumentNotFoundException(request.postId()));

		var comment = commentRepository.findById(request.id())
				.orElseThrow(() -> new DocumentNotFoundException(request.id()));

		comment.update(request.contents());
		return commentRepository.save(comment).getId();
	}

	public String delete(String id) {
		var comment = commentRepository.findById(id)
				.orElseThrow(() -> new DocumentNotFoundException(id));

		var post = postRepository.findById(comment.getPostId())
				.orElseThrow(() -> new DocumentNotFoundException(comment.getPostId()));

		commentRepository.delete(comment);
		post.decreaseReplyCount();
		postRepository.save(post);
		return id;
	}

	public Page<CommentRes> findByPage(int pageNumber, int pageSize) {
		var pageable = PageRequest.of(pageNumber, pageSize);
		return commentRepository.findAll(pageable)
				.map(CommentRes::from);
	}

	public CommentRes findById(String id) {
		var comment = commentRepository.findById(id)
				.orElseThrow(() -> new DocumentNotFoundException(id));

		return CommentRes.from(comment);
	}
}
