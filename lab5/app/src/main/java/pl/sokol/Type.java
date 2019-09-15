package pl.sokol;

public class Type {
    private String name;
    private String description;

    public static final Type[] TYPES = {
            new Type("Backend","Lista języków:\n" +
                    "-Python\n" +
                    "-Java\n" +
                    "-PHP\n" +
                    "-C#\n" +
                    "-Node.Js\n"),
            new Type("Frontend","Lista języków:\n" +
                    "-Angular\n" +
                    "-React\n" +
                    "-HTML\n" +
                    "-CSS\n" +
                    "-JavaScript\n"),
    };

    public Type(String name, String description){
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
