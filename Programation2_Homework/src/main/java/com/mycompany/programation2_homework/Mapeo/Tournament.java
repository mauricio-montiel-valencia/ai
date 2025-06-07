/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programation2_homework.Mapeo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Mauricio10
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "TOURNAMENT")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Tournament.findAll", query = "SELECT t FROM Tournament t"),
    @javax.persistence.NamedQuery(name = "Tournament.findByTournamentid", query = "SELECT t FROM Tournament t WHERE t.tournamentid = :tournamentid"),
    @javax.persistence.NamedQuery(name = "Tournament.findBySporttype", query = "SELECT t FROM Tournament t WHERE t.sporttype = :sporttype"),
    @javax.persistence.NamedQuery(name = "Tournament.findByTeamsAmount", query = "SELECT t FROM Tournament t WHERE t.teamsAmount = :teamsAmount"),
    @javax.persistence.NamedQuery(name = "Tournament.findByMatchTime", query = "SELECT t FROM Tournament t WHERE t.matchTime = :matchTime")})
public class Tournament implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TOURNAMENTID")
    private BigDecimal tournamentid;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "SPORTTYPE")
    private String sporttype;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TEAMS_AMOUNT")
    private BigInteger teamsAmount;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "MATCH_TIME")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date matchTime;
    @javax.persistence.OneToMany(mappedBy = "tournamentid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GeneralInformationTeam> generalInformationTeamCollection;
    @javax.persistence.OneToMany(mappedBy = "tournamentid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<Positions> positionsCollection;
    @javax.persistence.JoinColumn(name = "TEAM_INSCRIPTIONID", referencedColumnName = "TEAM_INSCRIPTIONID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TeamInscription teamInscriptionid;
    @javax.persistence.OneToMany(mappedBy = "tournamentid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<Confrontations> confrontationsCollection;
    @javax.persistence.OneToMany(mappedBy = "tournamentid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<ConfrontationRound> confrontationRoundCollection;
    @javax.persistence.OneToMany(mappedBy = "tournamentid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<TournamentStadistics> tournamentStadisticsCollection;
    @javax.persistence.OneToMany(mappedBy = "tournamentid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<WinnerCertification> winnerCertificationCollection;

    public Tournament() {
    }

    public Tournament(BigDecimal tournamentid) {
        this.tournamentid = tournamentid;
    }

    public Tournament(BigDecimal tournamentid, String sporttype, BigInteger teamsAmount, Date matchTime) {
        this.tournamentid = tournamentid;
        this.sporttype = sporttype;
        this.teamsAmount = teamsAmount;
        this.matchTime = matchTime;
    }

    public BigDecimal getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(BigDecimal tournamentid) {
        this.tournamentid = tournamentid;
    }

    public String getSporttype() {
        return sporttype;
    }

    public void setSporttype(String sporttype) {
        this.sporttype = sporttype;
    }

    public BigInteger getTeamsAmount() {
        return teamsAmount;
    }

    public void setTeamsAmount(BigInteger teamsAmount) {
        this.teamsAmount = teamsAmount;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public Collection<GeneralInformationTeam> getGeneralInformationTeamCollection() {
        return generalInformationTeamCollection;
    }

    public void setGeneralInformationTeamCollection(Collection<GeneralInformationTeam> generalInformationTeamCollection) {
        this.generalInformationTeamCollection = generalInformationTeamCollection;
    }

    public Collection<Positions> getPositionsCollection() {
        return positionsCollection;
    }

    public void setPositionsCollection(Collection<Positions> positionsCollection) {
        this.positionsCollection = positionsCollection;
    }

    public TeamInscription getTeamInscriptionid() {
        return teamInscriptionid;
    }

    public void setTeamInscriptionid(TeamInscription teamInscriptionid) {
        this.teamInscriptionid = teamInscriptionid;
    }

    public Collection<Confrontations> getConfrontationsCollection() {
        return confrontationsCollection;
    }

    public void setConfrontationsCollection(Collection<Confrontations> confrontationsCollection) {
        this.confrontationsCollection = confrontationsCollection;
    }

    public Collection<ConfrontationRound> getConfrontationRoundCollection() {
        return confrontationRoundCollection;
    }

    public void setConfrontationRoundCollection(Collection<ConfrontationRound> confrontationRoundCollection) {
        this.confrontationRoundCollection = confrontationRoundCollection;
    }

    public Collection<TournamentStadistics> getTournamentStadisticsCollection() {
        return tournamentStadisticsCollection;
    }

    public void setTournamentStadisticsCollection(Collection<TournamentStadistics> tournamentStadisticsCollection) {
        this.tournamentStadisticsCollection = tournamentStadisticsCollection;
    }

    public Collection<WinnerCertification> getWinnerCertificationCollection() {
        return winnerCertificationCollection;
    }

    public void setWinnerCertificationCollection(Collection<WinnerCertification> winnerCertificationCollection) {
        this.winnerCertificationCollection = winnerCertificationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tournamentid != null ? tournamentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournament)) {
            return false;
        }
        Tournament other = (Tournament) object;
        if ((this.tournamentid == null && other.tournamentid != null) || (this.tournamentid != null && !this.tournamentid.equals(other.tournamentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.Tournament[ tournamentid=" + tournamentid + " ]";
    }
    
}
