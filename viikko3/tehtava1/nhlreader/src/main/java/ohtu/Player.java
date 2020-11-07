
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;
    private int penalties;
    private String birthday;       

    public void setTeam(String team) {
        this.team = team;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPenalties() {
        return penalties;
    }

    public String getBirthday() {
        return birthday;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%-20s %s  %2d + %2d = %2d", name, team, goals, assists, goals + assists);
    }

    @Override
    public int compareTo(Player t) {
        return t.getAssists() + t.getGoals() - this.assists - this.goals;
    }
}
