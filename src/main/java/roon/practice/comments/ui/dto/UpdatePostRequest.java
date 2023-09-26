package roon.practice.comments.ui.dto;

public record UpdatePostRequest(String forumId, String id, String authorId, String title, String contents)  {

}
