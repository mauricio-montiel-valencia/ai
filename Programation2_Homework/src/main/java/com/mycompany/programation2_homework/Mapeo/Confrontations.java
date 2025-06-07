/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programation2_homework.Mapeo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Mauricio10
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "CONFRONTATIONS")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Confrontations.findAll", query = "SELECT c FROM Confrontations c"),
    @javax.persistence.NamedQuery(name = "Confrontations.findByConfrontations", query = "SELECT c FROM Confrontations c WHERE c.confrontations = :confrontations"),
    @javax.persistence.NamedQuery(name = "Confrontations.findByTeamsByConfrontation", query = "SELECT c FROM Confrontations c WHERE c.teamsByConfrontation = :teamsByConfrontation")})
public class Confrontations implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "CONFRONTATIONS")
    private BigDecimal confrontations;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TEAMS_BY_CONFRONTATION")
    private String teamsByConfrontation;
    @javax.persistence.JoinColumn(name = "CONFRONTATION_ROUNDID", referencedColumnName = "CONFRONTATION_ROUNDID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private ConfrontationRound confrontationRoundid;
    @javax.persistence.JoinColumn(name = "TOURNAMENTID", referencedColumnName = "TOURNAMENTID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private Tournament tournamentid;

    public Confrontations() {
    }

    public Confrontations(BigDecimal confrontations) {
        this.confrontations = confrontations;
    }

    public Confrontations(BigDecimal confrontations, String teamsByConfrontation) {
        this.confrontations = confrontations;
        this.teamsByConfrontation = teamsByConfrontation;
    }

    public BigDecimal getConfrontations() {
        return confrontations;
    }

    public void setConfrontations(BigDecimal confrontations) {
        this.confrontations = confrontations;
    }

    public String getTeamsByConfrontation() {
        return teamsByConfrontation;
    }

    public void setTeamsByConfrontation(String teamsByConfrontation) {
        this.teamsByConfrontation = teamsByConfrontation;
    }

    public ConfrontationRound getConfrontationRoundid() {
        return confrontationRoundid;
    }

    public void setConfrontationRoundid(ConfrontationRound confrontationRoundid) {
        this.confrontationRoundid = confrontationRoundid;
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
        hash += (confrontations != null ? confrontations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Confrontations)) {
            return false;
        }
        Confrontations other = (Confrontations) object;
        if ((this.confrontations == null && other.confrontations != null) || (this.confrontations != null && !this.confrontations.equals(other.confrontations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.Confrontations[ confrontations=" + confrontations + " ]";
    }
    
}
