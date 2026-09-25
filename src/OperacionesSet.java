import java.util.HashSet;
import java.util.Set;

public class OperacionesSet {
    public static void main(String[] args) {

        Set<String> lacteos = new HashSet<>();
        lacteos.add("Leche");
        lacteos.add("Queso");
        lacteos.add("Yogur");
        lacteos.add("Mantequilla");
        lacteos.add("Leche");

        Set<String> desayuno = new HashSet<>();
        desayuno.add("Cafe");
        desayuno.add("Leche");
        desayuno.add("Cereal");
        desayuno.add("Mermelada");
        desayuno.add("Yogur");

        System.out.println("Lacteos: " + lacteos);
        System.out.println("Desayuno: " + desayuno);
        System.out.println();

        // union
        Set<String> union = new HashSet<>(lacteos);
        union.addAll(desayuno);
        System.out.println("Union: " + union);

        // interseccion
        Set<String> interseccion = new HashSet<>(lacteos);
        interseccion.retainAll(desayuno);
        System.out.println("Interseccion: " + interseccion);

        // diferencia
        Set<String> diferencia = new HashSet<>(lacteos);
        diferencia.removeAll(desayuno);
        System.out.println("Diferencia: " + diferencia);
    }
}