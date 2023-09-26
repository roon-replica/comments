package roon.practice.comments.ui.dto;

public record CreatePostRequest(String forumId, String authorId, String title, String contents) {

}
