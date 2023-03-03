package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.HoursRecord;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TradingHoursResponse extends BaseResponse {

    private final List<String> symbols = new LinkedList<String>();
    private final List<List<HoursRecord>> quotes = new LinkedList<List<HoursRecord>>();
    private final List<List<HoursRecord>> trading = new LinkedList<List<HoursRecord>>();

    public TradingHoursResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray aHR = (JSONArray) this.getReturnData();
        for (Object o : aHR) {
            JSONObject ob = (JSONObject) o;
            String symbol = (String) ob.get("symbol");
            symbols.add(symbol);

            List<HoursRecord> quotesList = new LinkedList<HoursRecord>();
            JSONArray qHR = (JSONArray) ob.get("quotes");
            Iterator<Object> it2 = qHR.iterator();
            while (it2.hasNext()) {
                JSONObject e = (JSONObject) it2.next();
                HoursRecord rec = new HoursRecord();
                rec.setFieldsFromJSONObject(e);
                quotesList.add(rec);
            }
            quotes.add(quotesList);

            List<HoursRecord> tradingList = new LinkedList<HoursRecord>();
            JSONArray tHR = (JSONArray) ob.get("trading");
            it2 = tHR.iterator();
            while (it2.hasNext()) {
                JSONObject e = (JSONObject) it2.next();
                HoursRecord rec = new HoursRecord();
                rec.setFieldsFromJSONObject(e);
                tradingList.add(rec);
            }
            trading.add(tradingList);
        }
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public List<List<HoursRecord>> getQuotes() {
        return quotes;
    }

    public List<List<HoursRecord>> getTrading() {
        return trading;
    }

    @Override
    public String toString() {
        return "TradingHoursResponse [symbols=" + symbols + ", quotes="
                + quotes + ", trading=" + trading + "]";
    }
}