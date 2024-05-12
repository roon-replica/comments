package roon.practice.comments.ui.response;

import java.time.Instant;

public record TagRes(String id,
					 String name,
					 Instant createdAt,
					 Instant updatedAt
) {

}
