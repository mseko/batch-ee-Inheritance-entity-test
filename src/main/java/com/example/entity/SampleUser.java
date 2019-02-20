package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 疎通確認用のEntityクラス。
 */
@Entity
@Table(name = "SAMPLE_USER")
public class SampleUser extends SampleSuperUser implements Serializable {

    public Integer userIdToInteger(){
        return Integer.valueOf(this.getUserId());
    }
}
