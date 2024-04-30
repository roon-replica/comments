package roon.practice.comments.ui.request;

import java.util.List;

public record UpdatePostReq(String categoryId, String id, String authorId, String title, String contents, List<String> tagIds)  {

}
