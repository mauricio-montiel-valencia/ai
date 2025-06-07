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
@javax.persistence.Table(name = "WINNER_CERTIFICATION")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "WinnerCertification.findAll", query = "SELECT w FROM WinnerCertification w"),
    @javax.persistence.NamedQuery(name = "WinnerCertification.findByWinnerCertificationid", query = "SELECT w FROM WinnerCertification w WHERE w.winnerCertificationid = :winnerCertificationid")})
public class WinnerCertification implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "WINNER_CERTIFICATIONID")
    private BigDecimal winnerCertificationid;
    @javax.persistence.JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TeamRegister teamRegisterid;
    @javax.persistence.JoinColumn(name = "TOURNAMENTID", referencedColumnName = "TOURNAMENTID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private Tournament tournamentid;
    @javax.persistence.JoinColumn(name = "TOURNAMENT_STATSID", referencedColumnName = "TOURNAMENT_STATSID")
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
    private TournamentStadistics tournamentStatsid;

    public WinnerCertification() {
    }

    public WinnerCertification(BigDecimal winnerCertificationid) {
        this.winnerCertificationid = winnerCertificationid;
    }

    public BigDecimal getWinnerCertificationid() {
        return winnerCertificationid;
    }

    public void setWinnerCertificationid(BigDecimal winnerCertificationid) {
        this.winnerCertificationid = winnerCertificationid;
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
        hash += (winnerCertificationid != null ? winnerCertificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WinnerCertification)) {
            return false;
        }
        WinnerCertification other = (WinnerCertification) object;
        if ((this.winnerCertificationid == null && other.winnerCertificationid != null) || (this.winnerCertificationid != null && !this.winnerCertificationid.equals(other.winnerCertificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.programation2_homework.Mapeo.WinnerCertification[ winnerCertificationid=" + winnerCertificationid + " ]";
    }
    
}
