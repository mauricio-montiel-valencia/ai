/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programation2_homework.Mapeo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author Mauricio10
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "TEAM_REGISTER")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "TeamRegister.findAll", query = "SELECT t FROM TeamRegister t"),
    @javax.persistence.NamedQuery(name = "TeamRegister.findByTeamRegisterid", query = "SELECT t FROM TeamRegister t WHERE t.teamRegisterid = :teamRegisterid")})
public class TeamRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TEAM_REGISTERID")
    private BigDecimal teamRegisterid;
    @javax.persistence.OneToMany(mappedBy = "teamRegisterid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GeneralInformationTeam> generalInformationTeamCollection;
    @javax.persistence.OneToMany(mappedBy = "teamRegisterid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<Positions> positionsCollection;
    @javax.persistence.OneToMany(mappedBy = "teamRegisterid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GlobalRanking> globalRankingCollection;
    @javax.persistence.JoinColumn(name = "TEAM_INSCRIPTIONID", referencedColumnName = "TEAM_INSCRIPTIONID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TeamInscription teamInscriptionid;
    @javax.persistence.OneToMany(mappedBy = "teamRegisterid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GeneralStadistics> generalStadisticsCollection;
    @javax.persistence.OneToMany(mappedBy = "teamRegisterid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<TournamentStadistics> tournamentStadisticsCollection;
    @javax.persistence.OneToMany(mappedBy = "teamRegisterid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<WinnerCertification> winnerCertificationCollection;

    public TeamRegister() {
    }

    public TeamRegister(BigDecimal teamRegisterid) {
        this.teamRegisterid = teamRegisterid;
    }

    public BigDecimal getTeamRegisterid() {
        return teamRegisterid;
    }

    public void setTeamRegisterid(BigDecimal teamRegisterid) {
        this.teamRegisterid = teamRegisterid;
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

    public Collection<GlobalRanking> getGlobalRankingCollection() {
        return globalRankingCollection;
    }

    public void setGlobalRankingCollection(Collection<GlobalRanking> globalRankingCollection) {
        this.globalRankingCollection = globalRankingCollection;
    }

    public TeamInscription getTeamInscriptionid() {
        return teamInscriptionid;
    }

    public void setTeamInscriptionid(TeamInscription teamInscriptionid) {
        this.teamInscriptionid = teamInscriptionid;
    }

    public Collection<GeneralStadistics> getGeneralStadisticsCollection() {
        return generalStadisticsCollection;
    }

    public void setGeneralStadisticsCollection(Collection<GeneralStadistics> generalStadisticsCollection) {
        this.generalStadisticsCollection = generalStadisticsCollection;
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
        hash += (teamRegisterid != null ? teamRegisterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamRegister)) {
            return false;
        }
        TeamRegister other = (TeamRegister) object;
        if ((this.teamRegisterid == null && other.teamRegisterid != null) || (this.teamRegisterid != null && !this.teamRegisterid.equals(other.teamRegisterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.TeamRegister[ teamRegisterid=" + teamRegisterid + " ]";
    }
    
}
