import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BenchmarkSets {
    private static final int N = 1_000_000;

    public static void main(String[] args) {
        probar("HashSet", new HashSet<>());
        probar("TreeSet", new TreeSet<>());
    }

    private static void probar(String nombre, Set<Integer> conjunto) {
        long inicio = System.nanoTime();

        for (int i = 0; i < N; i++) {
            conjunto.add(i);
        }

        long fin = System.nanoTime();

        System.out.printf(
                "%s - inserción: %.3f ms%n",
                nombre,
                (fin - inicio) / 1_000_000.0
        );
    }
}