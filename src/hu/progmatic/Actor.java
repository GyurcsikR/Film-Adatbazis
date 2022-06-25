package hu.progmatic;

public class Actor {
    private String name;

    public Actor() {
    }

    public Actor(String line){
        String[] parts = line.split(";");
        setName(parts[6]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        String[] names = name.split("/");
    }
}
