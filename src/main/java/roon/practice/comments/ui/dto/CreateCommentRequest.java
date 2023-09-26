package roon.practice.comments.ui.dto;

public record CreateCommentRequest(String authorId, String postId, String contents, String parentId) {

}
