package roon.practice.comments.ui.request;

public record CreateCommentReq(String authorId, String postId, String contents, String parentId) {

}
