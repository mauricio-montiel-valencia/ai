/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programation2_homework.Mapeo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Mauricio10
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "GLOBAL_RANKING")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "GlobalRanking.findAll", query = "SELECT g FROM GlobalRanking g"),
    @javax.persistence.NamedQuery(name = "GlobalRanking.findByGlobalRankingid", query = "SELECT g FROM GlobalRanking g WHERE g.globalRankingid = :globalRankingid"),
    @javax.persistence.NamedQuery(name = "GlobalRanking.findByPositionsRanking", query = "SELECT g FROM GlobalRanking g WHERE g.positionsRanking = :positionsRanking")})
public class GlobalRanking implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "GLOBAL_RANKINGID")
    private BigDecimal globalRankingid;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "POSITIONS_RANKING")
    private BigInteger positionsRanking;
    @javax.persistence.JoinColumn(name = "GENERAL_STATSID", referencedColumnName = "GENERAL_STATSID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private GeneralStadistics generalStatsid;
    @javax.persistence.JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TeamRegister teamRegisterid;

    public GlobalRanking() {
    }

    public GlobalRanking(BigDecimal globalRankingid) {
        this.globalRankingid = globalRankingid;
    }

    public GlobalRanking(BigDecimal globalRankingid, BigInteger positionsRanking) {
        this.globalRankingid = globalRankingid;
        this.positionsRanking = positionsRanking;
    }

    public BigDecimal getGlobalRankingid() {
        return globalRankingid;
    }

    public void setGlobalRankingid(BigDecimal globalRankingid) {
        this.globalRankingid = globalRankingid;
    }

    public BigInteger getPositionsRanking() {
        return positionsRanking;
    }

    public void setPositionsRanking(BigInteger positionsRanking) {
        this.positionsRanking = positionsRanking;
    }

    public GeneralStadistics getGeneralStatsid() {
        return generalStatsid;
    }

    public void setGeneralStatsid(GeneralStadistics generalStatsid) {
        this.generalStatsid = generalStatsid;
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
        hash += (globalRankingid != null ? globalRankingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobalRanking)) {
            return false;
        }
        GlobalRanking other = (GlobalRanking) object;
        if ((this.globalRankingid == null && other.globalRankingid != null) || (this.globalRankingid != null && !this.globalRankingid.equals(other.globalRankingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.GlobalRanking[ globalRankingid=" + globalRankingid + " ]";
    }
    
}
