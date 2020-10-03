package com.bezkoder.springjwt.entities;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class Audit<U> {
    @Column(name = "CREATE_AT", nullable = false, updatable = false)
    @CreatedDate
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    @Column(name = "UPDATE_AT")
    @LastModifiedDate
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;

    @CreatedBy
    @Column(name = "CREATE_BY", nullable = false, updatable = false)
    private U createdBy;

    @LastModifiedBy
    private U lastModifiedBy;


}
