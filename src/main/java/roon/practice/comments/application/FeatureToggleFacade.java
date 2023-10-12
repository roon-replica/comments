package roon.practice.comments.application;

import org.springframework.stereotype.Service;
import roon.practice.comments.domain.Tag;

@Service
public class FeatureToggleFacade {
	private FeatureToggle featureToggle;

	public FeatureToggleFacade(FeatureToggle featureToggle){
		this.featureToggle = featureToggle;
	}

	public void validateTagName(Tag tag){
		if (featureToggle.shouldValidateTagNameLength()) {
			tag.validateTagNameLength();
		}
		if (featureToggle.shouldValidateBannedWords()) {
			tag.validateTagNameWords();
		}
	}

	// facade for other domain's feature toggles
}
