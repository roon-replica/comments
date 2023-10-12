package roon.practice.comments.application;

public interface FeatureToggle {
	boolean shouldValidateTagNameLength();
	boolean shouldValidateBannedWords();

}
