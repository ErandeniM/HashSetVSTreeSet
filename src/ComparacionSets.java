import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ComparacionSets {
    public static void main(String[] args) {
        probarSet("HashSet", new HashSet<>());
        probarSet("TreeSet", new TreeSet<>());

    }

    private static void probarSet(String nombre, Set<String> conjunto) {
        conjunto.add("Python");
        conjunto.add("Java");
        conjunto.add("SQL");
        conjunto.add("Docker");
        conjunto.add("Java");
        conjunto.add("Git");

        System.out.println(nombre);
        System.out.println(conjunto);
        System.out.println("Contiene Java: " + conjunto.contains("Java"));
        System.out.println("Tamaño: " + conjunto.size());
    }
}