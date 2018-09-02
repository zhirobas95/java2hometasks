package animals;

public class Animal implements Participant {
    String type;
    String name;

    int maxRunDist;
    int maxJumpDist;
    int maxSwimDist;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDist, int maxJumpDist, int maxSwimDist) {
        this.type = type;
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.maxJumpDist = maxJumpDist;
        this.maxSwimDist = maxSwimDist;
        this.onDistance = true;
    }

    public void run(int distance){
        if(distance <= maxRunDist){
            System.out.println(type + " " + name + " успешно справился с кроссом.");

        }else {
            System.out.println(type + " " + name + " не добежал.");
            onDistance = false;
        }

    }

    public void jump(int distance){
        if(distance <= maxJumpDist){
            System.out.println(type + " " + name + " успешно перепрыгнул.");

        }else {
            System.out.println(type + " " + name + " не допрыгнул.");
            onDistance = false;
        }

    }
    public void swim(int distance){
        if(maxSwimDist == 0){
            System.out.println(type + " " + name + " не умеет плавать");
            onDistance = false;
            return;
        }


        if(distance <= maxSwimDist){
            System.out.println(type + " " + name + " успешно проплыл");

        }else {
            System.out.println(type + " " + name + " не доплыл.");
            onDistance = false;
        }

    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type+ " " + name);
    }

}
