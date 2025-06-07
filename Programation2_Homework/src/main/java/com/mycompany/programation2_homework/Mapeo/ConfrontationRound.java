/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programation2_homework.Mapeo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author Mauricio10
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "CONFRONTATION_ROUND")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "ConfrontationRound.findAll", query = "SELECT c FROM ConfrontationRound c"),
    @javax.persistence.NamedQuery(name = "ConfrontationRound.findByConfrontationRoundid", query = "SELECT c FROM ConfrontationRound c WHERE c.confrontationRoundid = :confrontationRoundid"),
    @javax.persistence.NamedQuery(name = "ConfrontationRound.findByKeyRound", query = "SELECT c FROM ConfrontationRound c WHERE c.keyRound = :keyRound")})
public class ConfrontationRound implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "CONFRONTATION_ROUNDID")
    private BigDecimal confrontationRoundid;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "KEY_ROUND")
    private BigInteger keyRound;
    @javax.persistence.OneToMany(mappedBy = "confrontationRoundid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GeneralInformationTeam> generalInformationTeamCollection;
    @javax.persistence.OneToMany(mappedBy = "confrontationRoundid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<Confrontations> confrontationsCollection;
    @javax.persistence.JoinColumn(name = "TOURNAMENTID", referencedColumnName = "TOURNAMENTID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private Tournament tournamentid;

    public ConfrontationRound() {
    }

    public ConfrontationRound(BigDecimal confrontationRoundid) {
        this.confrontationRoundid = confrontationRoundid;
    }

    public ConfrontationRound(BigDecimal confrontationRoundid, BigInteger keyRound) {
        this.confrontationRoundid = confrontationRoundid;
        this.keyRound = keyRound;
    }

    public BigDecimal getConfrontationRoundid() {
        return confrontationRoundid;
    }

    public void setConfrontationRoundid(BigDecimal confrontationRoundid) {
        this.confrontationRoundid = confrontationRoundid;
    }

    public BigInteger getKeyRound() {
        return keyRound;
    }

    public void setKeyRound(BigInteger keyRound) {
        this.keyRound = keyRound;
    }

    public Collection<GeneralInformationTeam> getGeneralInformationTeamCollection() {
        return generalInformationTeamCollection;
    }

    public void setGeneralInformationTeamCollection(Collection<GeneralInformationTeam> generalInformationTeamCollection) {
        this.generalInformationTeamCollection = generalInformationTeamCollection;
    }

    public Collection<Confrontations> getConfrontationsCollection() {
        return confrontationsCollection;
    }

    public void setConfrontationsCollection(Collection<Confrontations> confrontationsCollection) {
        this.confrontationsCollection = confrontationsCollection;
    }

    public Tournament getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Tournament tournamentid) {
        this.tournamentid = tournamentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (confrontationRoundid != null ? confrontationRoundid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfrontationRound)) {
            return false;
        }
        ConfrontationRound other = (ConfrontationRound) object;
        if ((this.confrontationRoundid == null && other.confrontationRoundid != null) || (this.confrontationRoundid != null && !this.confrontationRoundid.equals(other.confrontationRoundid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.ConfrontationRound[ confrontationRoundid=" + confrontationRoundid + " ]";
    }
    
}
