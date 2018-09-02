import animals.Participant;

public class Team {
    private String teamName;
    private Participant[] members;

    public Team(String teamName, Participant[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    public void showResults() {
        System.out.println("Участники команды " + teamName + ", прошедшие дистанцию:");
        for (int i = 0; i < members.length; i++) {
            if (members[i].isOnDistance()) {
                members[i].info();
            }
        }
    }

    public void showInfo() {
        System.out.println("Участники команды " + teamName + ":");
        for (int i = 0; i < members.length; i++) {
            members[i].info();
        }
    }

    public Participant[] getMembers() {
        return members;
    }

    public String getTeamName() {
        return teamName;
    }
}
