package pro.xstore.api.message.records;

import org.json.JSONObject;

import java.math.BigDecimal;

public class TickRecord implements BaseResponseRecord {

    private BigDecimal ask;
    private BigDecimal bid;
    private Long askVolume;
    private Long bidVolume;
    private BigDecimal high;
    private BigDecimal low;
    private String symbol;
    private Double timestamp;
    private int level;
    private BigDecimal spreadRaw;
    private BigDecimal spreadTable;

    @Override
    public void setFieldsFromJSONObject(JSONObject ob) {
        this.ask = ob.getBigDecimal("ask");
        this.bid = ob.getBigDecimal("bid");
        this.askVolume = ob.has("askVolume") ? ob.getLong("askVolume") : null;
        if (askVolume == null) {
            this.askVolume = 0L;
        }
        this.bidVolume = ob.has("bidVolume") ? ob.getLong("bidVolume") : null;
        if (bidVolume == null) {
            this.bidVolume = 0L;
        }

        this.high = ob.getBigDecimal("high");

        this.low = ob.getBigDecimal("low");

        this.symbol = ob.getString("symbol");

        this.timestamp = ob.getDouble("timestamp");

        this.level = ob.getInt("level");

        this.spreadRaw = ob.getBigDecimal("spreadRaw");
        this.spreadTable = ob.getBigDecimal("spreadTable");
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public Long getAskVolume() {
        return askVolume;
    }

    public BigDecimal getSpreadRaw() {
        return spreadRaw;
    }

    public BigDecimal getSpreadTable() {
        return spreadTable;
    }

    public Long getBidVolume() {
        return bidVolume;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public String getSymbol() {
        return symbol;
    }

    public Long getTimestamp() {
        return timestamp.longValue();
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "TickRecord [ask=" + ask + ", bid=" + bid + ", askVolume="
                + askVolume + ", bidVolume=" + bidVolume + ", high=" + high
                + ", low=" + low + ", symbol=" + symbol + ", timestamp="
                + timestamp + ", level=" + level + ", spreadRaw=" + spreadRaw
                + ", spreadTable=" + spreadTable + "]";
    }

}