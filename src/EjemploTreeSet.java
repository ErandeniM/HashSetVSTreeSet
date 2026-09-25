import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        Set<String> tecnologias = new TreeSet<>();

        tecnologias.add("Java");
        tecnologias.add("Python");
        tecnologias.add("JavaScript");
        tecnologias.add("Java");
        tecnologias.add("SQL");
        tecnologias.add("Git");
        tecnologias.add("Docker");

        for (String tecnologia : tecnologias) {
            System.out.println(tecnologia);
        }
    }
}