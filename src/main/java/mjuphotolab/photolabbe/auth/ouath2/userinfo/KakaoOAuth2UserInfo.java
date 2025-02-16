package mjuphotolab.photolabbe.auth.ouath2.userinfo;

import java.util.Map;

public class KakaoOAuth2UserInfo extends OAuth2UserInfo {

	private String email;

	public KakaoOAuth2UserInfo(final Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getId() {
		return String.valueOf(attributes.get("id"));
	}

	@Override
	public String getNickname() {
		Map<String, Object> account = (Map<String, Object>)attributes.get("kakao_account");
		Map<String, Object> profile = (Map<String, Object>)account.get("profile");

		if (account == null || profile == null) {
			return null;
		}
		return (String)profile.get("nickname");
	}

	@Override
	public String getEmail() {
		Map<String, Object> account = (Map<String, Object>)attributes.get("kakao_account");
		return (String)account.get("email");
	}

	@Override
	public String getImageUrl() {
		Map<String, Object> account = (Map<String, Object>)attributes.get("kakao_account");
		Map<String, Object> profile = (Map<String, Object>)account.get("profile");

		if (account == null || profile == null) {
			return null;
		}

		return (String)profile.get("thumbnail_image_url");
	}
}
