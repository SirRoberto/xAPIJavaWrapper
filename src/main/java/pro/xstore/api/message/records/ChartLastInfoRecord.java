package pro.xstore.api.message.records;

import org.json.JSONObject;
import pro.xstore.api.message.codes.PERIOD_CODE;

public class ChartLastInfoRecord {

    private final String symbol;
    private final PERIOD_CODE period;
    private final long start;

    public ChartLastInfoRecord(String symbol, PERIOD_CODE period, long start) {
        this.symbol = symbol;
        this.period = period;
        this.start = start;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        obj.put("symbol", symbol);
        obj.put("period", period.getCode());
        obj.put("start", start);
        return obj;
    }

    @Override
    public String toString() {
        return "ChartLastInfoRecord{" + "symbol=" + symbol + ", period=" + period + ", start=" + start + '}';
    }
}
