package roon.practice.comments.infra;

import java.util.UUID;

public class IdGenerator {
	public static String id(){
		return UUID.randomUUID().toString().substring(0,6);
	}
}
