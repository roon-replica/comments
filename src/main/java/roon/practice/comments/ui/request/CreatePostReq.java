package roon.practice.comments.ui.request;

import java.util.List;

public record CreatePostReq(String categoryId, String authorId, String title, String contents, List<String> tagIds) {

}
