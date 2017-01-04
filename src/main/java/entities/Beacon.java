package entities;

/**
 * Created by cazala on 04/01/17.
 */
public class Beacon {
    private String name;
    private Position pos;

    public Beacon(String name, Position pos) {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }
}
