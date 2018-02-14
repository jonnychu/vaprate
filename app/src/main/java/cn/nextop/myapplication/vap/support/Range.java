package cn.nextop.myapplication.vap.support;

/**
 * Created by jonny on 2018/2/9.
 */

public class Range {
    //
    final private float lower;
    final private float upper;

    /**
     *
     */
    public Range(float start, float end) {
        this.lower = start; this.upper = end;
    }

    /**
     *
     */
    public float getLower() { return lower; }
    public float getUpper() { return upper; }

    /**
     *
     */
    public boolean inRange(final float value) {
        if (lower <= upper) return value >= lower && value <= upper;
        else return value >= upper && value <= lower;
    }

    /**
     *
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Range)) return false;
        final Range other = (Range) obj;
        return other.lower == lower && other.upper == upper;
    }

    @Override
    public String toString() { return "lower=" + lower + ", upper=" + upper; }
}
