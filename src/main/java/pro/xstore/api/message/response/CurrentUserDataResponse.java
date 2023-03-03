package pro.xstore.api.message.response;

import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

public class CurrentUserDataResponse extends BaseResponse {

    private final String currency;
    @Deprecated
    private final int leverage;
    private final String group;
    private final double leverageMultiplier;
    private final int companyUnit;
    private final String spreadType;
    private final boolean ibAccount;

    public CurrentUserDataResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.currency = (String) ob.get("currency");
        this.spreadType = (String) ob.get("spreadType");
        this.leverage = ((Long) ob.get("leverage")).intValue();
        this.group = (String) ob.get("group");
        this.leverageMultiplier = Double.parseDouble(ob.get("leverageMultiplier").toString());
        this.companyUnit = ((Long) ob.get("companyUnit")).intValue();
        this.ibAccount = (Boolean) ob.get("ibAccount");
    }

    public String getCurrency() {
        return currency;
    }

    public String getGroup() {
        return group;
    }

    public double getLeverageMultiplier() {
        return leverageMultiplier;
    }

    public boolean isIbAccount() {
        return ibAccount;
    }

    @Deprecated
    public int getLeverage() {
        return leverage;
    }

    public int getCompanyUnit() {
        return companyUnit;
    }

    public String getSpreadType() {
        return spreadType;
    }

    @Override
    public String toString() {
        return "CurrentUserDataResponse [currency=" + currency + ", group="
                + group + ", leverageMultiplier=" + leverageMultiplier
                + ", ibAccount=" + ibAccount + ", companyUnit=" + companyUnit + ", spreadType=" + spreadType
                + "]";
    }
}