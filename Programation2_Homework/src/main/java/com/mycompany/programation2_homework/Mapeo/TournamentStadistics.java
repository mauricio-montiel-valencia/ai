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
@javax.persistence.Table(name = "TOURNAMENT_STADISTICS")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "TournamentStadistics.findAll", query = "SELECT t FROM TournamentStadistics t"),
    @javax.persistence.NamedQuery(name = "TournamentStadistics.findByTournamentStatsid", query = "SELECT t FROM TournamentStadistics t WHERE t.tournamentStatsid = :tournamentStatsid"),
    @javax.persistence.NamedQuery(name = "TournamentStadistics.findByTournamentWins", query = "SELECT t FROM TournamentStadistics t WHERE t.tournamentWins = :tournamentWins")})
public class TournamentStadistics implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TOURNAMENT_STATSID")
    private BigDecimal tournamentStatsid;
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "TOURNAMENT_WINS")
    private BigInteger tournamentWins;
    @javax.persistence.OneToMany(mappedBy = "tournamentStatsid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<GeneralInformationTeam> generalInformationTeamCollection;
    @javax.persistence.JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TeamRegister teamRegisterid;
    @javax.persistence.JoinColumn(name = "TOURNAMENTID", referencedColumnName = "TOURNAMENTID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private Tournament tournamentid;
    @javax.persistence.OneToMany(mappedBy = "tournamentStatsid", fetch = javax.persistence.FetchType.EAGER)
    private Collection<WinnerCertification> winnerCertificationCollection;

    public TournamentStadistics() {
    }

    public TournamentStadistics(BigDecimal tournamentStatsid) {
        this.tournamentStatsid = tournamentStatsid;
    }

    public TournamentStadistics(BigDecimal tournamentStatsid, BigInteger tournamentWins) {
        this.tournamentStatsid = tournamentStatsid;
        this.tournamentWins = tournamentWins;
    }

    public BigDecimal getTournamentStatsid() {
        return tournamentStatsid;
    }

    public void setTournamentStatsid(BigDecimal tournamentStatsid) {
        this.tournamentStatsid = tournamentStatsid;
    }

    public BigInteger getTournamentWins() {
        return tournamentWins;
    }

    public void setTournamentWins(BigInteger tournamentWins) {
        this.tournamentWins = tournamentWins;
    }

    public Collection<GeneralInformationTeam> getGeneralInformationTeamCollection() {
        return generalInformationTeamCollection;
    }

    public void setGeneralInformationTeamCollection(Collection<GeneralInformationTeam> generalInformationTeamCollection) {
        this.generalInformationTeamCollection = generalInformationTeamCollection;
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

    public Collection<WinnerCertification> getWinnerCertificationCollection() {
        return winnerCertificationCollection;
    }

    public void setWinnerCertificationCollection(Collection<WinnerCertification> winnerCertificationCollection) {
        this.winnerCertificationCollection = winnerCertificationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tournamentStatsid != null ? tournamentStatsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TournamentStadistics)) {
            return false;
        }
        TournamentStadistics other = (TournamentStadistics) object;
        if ((this.tournamentStatsid == null && other.tournamentStatsid != null) || (this.tournamentStatsid != null && !this.tournamentStatsid.equals(other.tournamentStatsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.TournamentStadistics[ tournamentStatsid=" + tournamentStatsid + " ]";
    }
    
}
