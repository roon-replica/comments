package roon.practice.comments.ui.dto;

import java.util.List;

public record CreatePostRequest(String forumId, String authorId, String title, String contents, List<String> tagIds) {

}
