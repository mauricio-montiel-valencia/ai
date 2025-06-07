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
@javax.persistence.Table(name = "GENERAL_INFORMATION_TEAM")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "GeneralInformationTeam.findAll", query = "SELECT g FROM GeneralInformationTeam g"),
    @javax.persistence.NamedQuery(name = "GeneralInformationTeam.findByGeneralInformationTeamid", query = "SELECT g FROM GeneralInformationTeam g WHERE g.generalInformationTeamid = :generalInformationTeamid"),
    @javax.persistence.NamedQuery(name = "GeneralInformationTeam.findByTournamentsParticipated", query = "SELECT g FROM GeneralInformationTeam g WHERE g.tournamentsParticipated = :tournamentsParticipated"),
    @javax.persistence.NamedQuery(name = "GeneralInformationTeam.findByTeams", query = "SELECT g FROM GeneralInformationTeam g WHERE g.teams = :teams")})
public class GeneralInformationTeam implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "GENERAL_INFORMATION_TEAMID")
    private BigDecimal generalInformationTeamid;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TOURNAMENTS_PARTICIPATED")
    private BigInteger tournamentsParticipated;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TEAMS")
    private String teams;
    @javax.persistence.JoinColumn(name = "CONFRONTATION_ROUNDID", referencedColumnName = "CONFRONTATION_ROUNDID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private ConfrontationRound confrontationRoundid;
    @javax.persistence.JoinColumn(name = "GENERAL_STATSID", referencedColumnName = "GENERAL_STATSID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private GeneralStadistics generalStatsid;
    @javax.persistence.JoinColumn(name = "POSITIONSID", referencedColumnName = "POSITIONSID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private Positions positionsid;
    @javax.persistence.JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TeamRegister teamRegisterid;
    @javax.persistence.JoinColumn(name = "TOURNAMENTID", referencedColumnName = "TOURNAMENTID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private Tournament tournamentid;
    @javax.persistence.JoinColumn(name = "TOURNAMENT_STATSID", referencedColumnName = "TOURNAMENT_STATSID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TournamentStadistics tournamentStatsid;

    public GeneralInformationTeam() {
    }

    public GeneralInformationTeam(BigDecimal generalInformationTeamid) {
        this.generalInformationTeamid = generalInformationTeamid;
    }

    public GeneralInformationTeam(BigDecimal generalInformationTeamid, BigInteger tournamentsParticipated, String teams) {
        this.generalInformationTeamid = generalInformationTeamid;
        this.tournamentsParticipated = tournamentsParticipated;
        this.teams = teams;
    }

    public BigDecimal getGeneralInformationTeamid() {
        return generalInformationTeamid;
    }

    public void setGeneralInformationTeamid(BigDecimal generalInformationTeamid) {
        this.generalInformationTeamid = generalInformationTeamid;
    }

    public BigInteger getTournamentsParticipated() {
        return tournamentsParticipated;
    }

    public void setTournamentsParticipated(BigInteger tournamentsParticipated) {
        this.tournamentsParticipated = tournamentsParticipated;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public ConfrontationRound getConfrontationRoundid() {
        return confrontationRoundid;
    }

    public void setConfrontationRoundid(ConfrontationRound confrontationRoundid) {
        this.confrontationRoundid = confrontationRoundid;
    }

    public GeneralStadistics getGeneralStatsid() {
        return generalStatsid;
    }

    public void setGeneralStatsid(GeneralStadistics generalStatsid) {
        this.generalStatsid = generalStatsid;
    }

    public Positions getPositionsid() {
        return positionsid;
    }

    public void setPositionsid(Positions positionsid) {
        this.positionsid = positionsid;
    }

    public TeamRegister getTeamRegisterid() {
        return teamRegisterid;
    }

    public void setTeamRegisterid(TeamRegister teamRegisterid) {
        this.teamRegisterid = teamRegisterid;
    }

    public Tournament getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Tournament tournamentid) {
        this.tournamentid = tournamentid;
    }

    public TournamentStadistics getTournamentStatsid() {
        return tournamentStatsid;
    }

    public void setTournamentStatsid(TournamentStadistics tournamentStatsid) {
        this.tournamentStatsid = tournamentStatsid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalInformationTeamid != null ? generalInformationTeamid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralInformationTeam)) {
            return false;
        }
        GeneralInformationTeam other = (GeneralInformationTeam) object;
        if ((this.generalInformationTeamid == null && other.generalInformationTeamid != null) || (this.generalInformationTeamid != null && !this.generalInformationTeamid.equals(other.generalInformationTeamid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.GeneralInformationTeam[ generalInformationTeamid=" + generalInformationTeamid + " ]";
    }
    
}
