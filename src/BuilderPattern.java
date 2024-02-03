public class BuilderPattern {

    private Integer id;
    private String name;
    private String city;

    public static BuilderPattern Builder() {
        return new BuilderPattern();
    }

    public BuilderPattern withId(int id) {
        this.id = id;
        return this;
    }

    public BuilderPattern withName(String name) {
        this.name = name;
        return this;
    }

    public BuilderPattern withCity(String city) {
        this.city = city;
        return this;
    }

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public static void main(String[] args) {
        BuilderPattern bp1 = BuilderPattern.Builder().withId(7).withCity("Bhopal").withName("Devansh");
        BuilderPattern bp2 = BuilderPattern.Builder().withId(7).withCity("Bhopal").withName("Bunny");
        System.out.println(bp1);
        System.out.println(bp2);
        System.out.println(bp1);

    }
}
