package com.example.demo.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lthung
 */
@Entity
@Table(name = "persistent_logins", catalog = "rangdongdev", schema = "")
@NamedQueries({
    @NamedQuery(name = "PersistentLogins.findAll", query = "SELECT p FROM PersistentLogins p"),
    @NamedQuery(name = "PersistentLogins.findByAccountname", query = "SELECT p FROM PersistentLogins p WHERE p.accountname = :accountname"),
    @NamedQuery(name = "PersistentLogins.findBySeries", query = "SELECT p FROM PersistentLogins p WHERE p.series = :series"),
    @NamedQuery(name = "PersistentLogins.findByToken", query = "SELECT p FROM PersistentLogins p WHERE p.token = :token"),
    @NamedQuery(name = "PersistentLogins.findByLastAccount", query = "SELECT p FROM PersistentLogins p WHERE p.lastAccount = :lastAccount")})
public class PersistentLogins implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "accountname")
    private String accountname;
    @Id
    @Basic(optional = false)
    @Column(name = "series")
    private String series;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "last_account")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccount;

    public PersistentLogins() {
    }

    public PersistentLogins(String series) {
        this.series = series;
    }

    public PersistentLogins(String series, String accountname, String token, Date lastAccount) {
        this.series = series;
        this.accountname = accountname;
        this.token = token;
        this.lastAccount = lastAccount;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLastAccount() {
        return lastAccount;
    }

    public void setLastAccount(Date lastAccount) {
        this.lastAccount = lastAccount;
    }

}
