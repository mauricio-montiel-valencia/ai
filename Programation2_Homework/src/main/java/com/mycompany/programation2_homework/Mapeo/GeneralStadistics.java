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
@javax.persistence.Table(name = "GENERAL_STADISTICS")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "GeneralStadistics.findAll", query = "SELECT g FROM GeneralStadistics g"),
    @javax.persistence.NamedQuery(name = "GeneralStadistics.findByGeneralStatsid", query = "SELECT g FROM GeneralStadistics g WHERE g.generalStatsid = :generalStatsid"),
    @javax.persistence.NamedQuery(name = "GeneralStadistics.findByGeneralWins", query = "SELECT g FROM GeneralStadistics g WHERE g.generalWins = :generalWins")})
public class GeneralStadistics implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "GENERAL_STATSID")
    private BigDecimal generalStatsid;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "GENERAL_WINS")
    private BigInteger generalWins;
    @javax.persistence.OneToMany(mappedBy = "generalStatsid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GeneralInformationTeam> generalInformationTeamCollection;
    @javax.persistence.OneToMany(mappedBy = "generalStatsid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GlobalRanking> globalRankingCollection;
    @javax.persistence.JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TeamRegister teamRegisterid;

    public GeneralStadistics() {
    }

    public GeneralStadistics(BigDecimal generalStatsid) {
        this.generalStatsid = generalStatsid;
    }

    public GeneralStadistics(BigDecimal generalStatsid, BigInteger generalWins) {
        this.generalStatsid = generalStatsid;
        this.generalWins = generalWins;
    }

    public BigDecimal getGeneralStatsid() {
        return generalStatsid;
    }

    public void setGeneralStatsid(BigDecimal generalStatsid) {
        this.generalStatsid = generalStatsid;
    }

    public BigInteger getGeneralWins() {
        return generalWins;
    }

    public void setGeneralWins(BigInteger generalWins) {
        this.generalWins = generalWins;
    }

    public Collection<GeneralInformationTeam> getGeneralInformationTeamCollection() {
        return generalInformationTeamCollection;
    }

    public void setGeneralInformationTeamCollection(Collection<GeneralInformationTeam> generalInformationTeamCollection) {
        this.generalInformationTeamCollection = generalInformationTeamCollection;
    }

    public Collection<GlobalRanking> getGlobalRankingCollection() {
        return globalRankingCollection;
    }

    public void setGlobalRankingCollection(Collection<GlobalRanking> globalRankingCollection) {
        this.globalRankingCollection = globalRankingCollection;
    }

    public TeamRegister getTeamRegisterid() {
        return teamRegisterid;
    }

    public void setTeamRegisterid(TeamRegister teamRegisterid) {
        this.teamRegisterid = teamRegisterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalStatsid != null ? generalStatsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralStadistics)) {
            return false;
        }
        GeneralStadistics other = (GeneralStadistics) object;
        if ((this.generalStatsid == null && other.generalStatsid != null) || (this.generalStatsid != null && !this.generalStatsid.equals(other.generalStatsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.GeneralStadistics[ generalStatsid=" + generalStatsid + " ]";
    }
    
}
