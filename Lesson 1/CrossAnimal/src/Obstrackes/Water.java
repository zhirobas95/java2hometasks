package Obstrackes;

import animals.Animal;
import animals.Participant;

public class Water extends Obstracle {
    private int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participant a) {
        a.swim(distance);

    }


}
