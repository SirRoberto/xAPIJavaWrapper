package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;

import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.RedirectRecord;

@Value
@EqualsAndHashCode(callSuper = true)
public class LoginResponse extends BaseResponse {

    RedirectRecord redirect;

    public LoginResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject redirectJson = super.getRedirectJson();
        if (redirectJson != null) {
            redirect = new RedirectRecord();
            redirect.setFieldsFromJSONObject(redirectJson);
        } else {
            redirect = null;
        }
    }

    public boolean isRedirectSet() {
        return this.redirect != null;
    }
}