package roon.practice.comments.infra;


import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.util.UnleashConfig;
import org.springframework.stereotype.Component;
import roon.practice.comments.application.FeatureToggle;

@Component
public class UnleashService implements FeatureToggle {
	private final Unleash unleash;

	public UnleashService() {
		UnleashConfig config = UnleashConfig.builder()
				.appName("comments.java-app")
				.instanceId("instance-1")
				.environment("production")
				.unleashAPI("http://localhost:4242/api/")
				.customHttpHeader("Authorization", "*:production.dd5383043005ad5f4a8ae64cb9e93e0d63ce6b5b21d7b9ec6b71119c")
				.build();

		this.unleash = new DefaultUnleash(config);
	}

	public boolean shouldValidateTagNameLength() {
		return unleash.isEnabled("shouldValidateTagNameLength");
	}

	public boolean shouldValidateBannedWords() {
		return unleash.isEnabled("shouldValidateBannedWords");
	}
}
