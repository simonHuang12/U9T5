import java.net.StandardSocketOptions;
import java.util.ArrayList;

public class Cabaret {
    private ArrayList<Performer> performers;
    private String name;

    public Cabaret(String name){
        performers = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Performer> getPerformers() {
        return performers;
    }

    public boolean addPerformer(Performer performer){
        if (!performers.contains(performer)){
            performers.add(performer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer performer){
        if (performers.contains(performer)){
            performers.remove(performer);
            return true;
        }
        return false;
    }

    public double averagePerformerAge(){
        double sum = 0;
        for (Performer performer: performers){
            sum += performer.getAge();
        }
        return sum/performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age){
        ArrayList<Performer> overAge = new ArrayList<>();
        for (Performer performer : performers){
            if (performer.getAge() >= age){
                overAge.add(performer);
            }
        }
        return overAge;
    }

    public void groupRehearsal(){
        for (Performer performer: performers){
            System.out.println("REHEARSAL CALL! "+ performer.getName());

            if (performer instanceof Comedian temp){
                temp.rehearse(false);
            }else {
                performer.rehearse();
            }
        }
    }

    public void cabaretShow(){
        for (Performer performer: performers){
            System.out.println("Welcome to the cabaret! Next act up..." + performer.getName());
            if (performer instanceof Dancer temp){
                temp.pirouette(2);
            }
            performer.perform();
        }
    }
}
