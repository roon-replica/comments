package roon.practice.comments.ui.response;

import java.time.Instant;

public record CategoryRes(String id, String title, int postCount, Instant createdAt) {

}
