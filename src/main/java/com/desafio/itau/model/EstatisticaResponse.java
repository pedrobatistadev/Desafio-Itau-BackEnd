package com.desafio.itau.model;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class EstatisticaResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private long count;

    @NotNull
    private Double sum;

    @NotNull
    private Double avg;

    @NotNull
    private Double min;

    @NotNull
    private Double max;

    public EstatisticaResponse() {
    }

    public EstatisticaResponse(long count, Double sum, Double avg, Double min, Double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EstatisticaResponse that)) return false;
        return Objects.equals(count, that.count) && Objects.equals(sum, that.sum) && Objects.equals(avg, that.avg) && Objects.equals(min, that.min) && Objects.equals(max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, sum, avg, min, max);
    }
}


