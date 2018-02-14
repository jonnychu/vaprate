package cn.nextop.myapplication.vap.model.bean;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jonny on 2018/2/11.
 */
public class Data {
    private Side side;
    private BigDecimal position, price;
    public enum Side {Buy, Sell};

    /**
     *
     */
    public Data(BigDecimal position, BigDecimal price, Side side) {
        this.side = side;
        this.price = price;
        this.position = position;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPosition() {
        return position;
    }

    public void setPosition(BigDecimal position) {
        this.position = position;
    }
}
