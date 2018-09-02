import Obstrackes.Obstracle;
import animals.Participant;

public class Course {
    private Obstracle[] obstracles;

    public Course(Obstracle[] obstracles) {
        this.obstracles = obstracles;
    }

    public void doIt(Team team) {
        System.out.println("Команда " + team.getTeamName() + " стартует...");
        for(Participant a: team.getMembers()) {
            for(Obstracle o: obstracles){
                o.doIt(a);
                if(!a.isOnDistance()){
                    break;
                }
            }
        }
    }
}
