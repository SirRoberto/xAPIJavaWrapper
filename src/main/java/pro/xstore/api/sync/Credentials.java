package pro.xstore.api.sync;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Credentials {

	String login;
	String password;
	String appName;
}