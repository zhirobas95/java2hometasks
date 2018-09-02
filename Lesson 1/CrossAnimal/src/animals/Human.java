package animals;

public class Human implements Participant{
    String name;
    int maxRunDit;
    int maxJumpDist;
    int maxSwimDist;

    boolean active;

    public Human(String name) {
        this.name = name;
        this.maxRunDit = 1000;
        this.maxJumpDist = 2500;
        this.maxSwimDist = 1000;
        this.active = true;
    }

    public void run(int distance){
        if(distance <= maxRunDit){
            System.out.println(name + " Успешно справился с кроссом");

        }else {
            System.out.println(name + " Не справилось");
            active = false;
        }

    }

    public void jump(int distance){
        if(distance <= maxJumpDist){
            System.out.println(name + " Успешно справился с кроссом");

        }else {
            System.out.println(name + " Не справилось");
            active = false;
        }

    }
    public void swim(int distance){
        if(distance <= maxJumpDist){
            System.out.println(name + " Успешно справился с кроссом");

        }else {
            System.out.println(name + " Не справилось");
            active = false;
        }

    }

    @Override
    public boolean isOnDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name + " " + active);
    }

}
