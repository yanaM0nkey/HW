package dz19;

public class Main {

    public static void main(String[] args) {
        StuffCollection<String> stuff = new StuffCollection<>();
        stuff.addDirector("jrhgfhsb");

        stuff.add("A", "dagvhak");
        stuff.add("B", "bbb");
        stuff.add("B", "ccc");

        String director = stuff.getDirector();
        System.out.println("director: " + director);
        String inf = stuff.getString();
        System.out.println(inf);
        stuff.remove("B", "bbb");
        //stuff.remove("C", "ns");
        //stuff.remove("A", "snk");
        stuff.remove("B", "ccc");
        stuff.remove("B", "sknd");
        int size = stuff.getSize("B");
        System.out.println("size: " + size);
        inf = stuff.getString();
        System.out.println(inf);
    }
}
