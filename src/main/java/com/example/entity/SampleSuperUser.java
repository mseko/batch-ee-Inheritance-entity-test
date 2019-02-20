package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

public class SampleSuperUser {

    /** ユーザID。 */
    @Getter(onMethod_ = {
            @Id,
            @Column(name = "USER_ID",
                    length = 20,
                    nullable = false,
                    unique = true)})
    @Setter
    private String userId;

    /** 姓。 */
    @Getter(onMethod_ = {
            @Column(name = "FAMILY_NAME",
                    length = 20,
                    nullable = false,
                    unique = false)})
    @Setter
    private String familyName;

    /** 名。 */
    @Getter(onMethod_ = {
            @Column(name = "FIRST_NAME",
                    length = 20,
                    nullable = false,
                    unique = false)})
    @Setter
    private String firstName;

}
