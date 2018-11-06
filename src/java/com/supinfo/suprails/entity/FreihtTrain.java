package com.supinfo.suprails.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue("FreihtTrain")
public class FreihtTrain extends Train {

    private Integer weightQuantity;

    public Integer getWeightQuantity() {
        return weightQuantity;
    }

    public void setWeightQuantity(Integer weightQuantity) {
        this.weightQuantity = weightQuantity;
    }
}
