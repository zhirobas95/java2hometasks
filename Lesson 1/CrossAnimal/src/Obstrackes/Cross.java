package Obstrackes;

import animals.Participant;

public class Cross extends Obstracle {
    private int lenght;

    public Cross(int lenght) {
        this.lenght = lenght;
    }


    @Override
    public void doIt(Participant a) {
        a.run(lenght);
    }
}
