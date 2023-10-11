package roon.practice.comments.ui.dto;

import java.util.List;

public record UpdatePostRequest(String forumId, String id, String authorId, String title, String contents, List<String> tagIds)  {

}
