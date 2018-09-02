import Obstrackes.Cross;
import Obstrackes.Obstracle;
import Obstrackes.Wall;
import animals.Cat;
import animals.Dog;
import animals.Participant;

public class Main {
    public static void main(String[] args) {
        Participant[] part = {new Cat("Barsik"),new Dog("Bobik")};
        Obstracle[] cross = {new Wall(80), new Cross(800)};


        for(Participant a: part){
            for(Obstracle o: cross){
                o.doIt(a);
                if(!a.isOnDistance()){
                    break;
                }
            }
        }
        for (Participant a : part) {
            a.info();
        }

    }
}
