# Práctica: HashSet vs. TreeSet en Java Collections Framework

## 1. Propósito

`HashSet` y `TreeSet` implementan la interfaz `Set<E>` del Java
Collections Framework. Ambas almacenan elementos sin duplicados, pero
utilizan estructuras internas diferentes y ofrecen distintas
características de ordenamiento y desempeño.

El propósito es que experimenten con ambas
implementaciones y determinen qué criterios permiten decidir cuál
utilizar.

Al finalizar,  podrás utilizar `Set`, distinguir `HashSet` y
`TreeSet`, comprobar su comportamiento ante duplicados, comparar el
orden de iteración, realizar operaciones de conjuntos, analizar
complejidad y justificar la selección de una implementación.

## 2. Situación problema

Una universidad registra tecnologías que dominan sus estudiantes:

``` text
Java
Python
JavaScript
Java
SQL
Python
Git
Java
Docker
SQL
```

Se requiere almacenar las tecnologías sin duplicados y, en algunas
situaciones, mostrarlas ordenadas alfabéticamente.

## 3. Preparación en IntelliJ IDEA

Crear:

``` text
ComparacionSets/
└── src/
    ├── EjemploHashSet.java
    ├── EjemploTreeSet.java
    ├── ComparacionSets.java
    ├── OperacionesSet.java
    └── BenchmarkSets.java
```

## 4. Introducción a Set

Un `Set` representa una colección sin elementos duplicados.

``` text
Java
Python
Java
SQL
Python
       │
       ▼
      Set
       │
       ▼
Java
Python
SQL
```

**Pregunta:** ¿En qué situaciones sería importante garantizar que un
elemento aparezca una sola vez?
Cuando estamos estableciendo categorías por ejemplo en un supermercado, puedes tener diferentes secciones del mercado como el nombre de los pasillos o bien, el nombre de diferentes productos, pero no es conveniente agregar un producto repetido en especifico si los voy a contar o si voy a asignarle características.
También en bases de datos, en los números de expedientes, claves únicas como CURP, entre otros identificadores.

## 5. Trabajar con HashSet

``` java
import java.util.HashSet;
import java.util.Set;

public class EjemploHashSet {
    public static void main(String[] args) {
        Set<String> tecnologias = new HashSet<>();

        tecnologias.add("Java");
        tecnologias.add("Python");
        tecnologias.add("JavaScript");
        tecnologias.add("Java");
        tecnologias.add("SQL");
        tecnologias.add("Python");
        tecnologias.add("Git");
        tecnologias.add("Docker");

        System.out.println(tecnologias);
    }
}
```

Analice cuántos elementos se intentaron agregar, cuántos permanecen y
qué ocurre con los duplicados. Observe también que `HashSet` no
garantiza el orden de iteración.
Se agregaron [Java, Git, Docker, JavaScript, Python, SQL], a pesar de que eran 8 líneas para agregar objetos, sin embargo estaban varios repetidos y no se agregaron.

## 6. Resultado de add()

``` java
boolean agregado = tecnologias.add("Java");
System.out.println("¿Se agregó Java? " + agregado);

boolean agregado2 = tecnologias.add("Kotlin");
System.out.println("¿Se agregó Kotlin? " + agregado2);
```

Si el elemento no pertenece al conjunto, `add()` devuelve `true`; si ya
existe, devuelve `false`.

**Pregunta:** ¿Cómo puede utilizarse este resultado para detectar
registros duplicados?
Al arrojar false sabes que Java ya se encuentra en el conjunto, y que únicamente se agregan aquellos que no estaban incluidos en el conjunto. Puedes implementar iteraciones para comprobarlo.
## 7. Operaciones fundamentales

``` java
tecnologias.contains("Java");
tecnologias.contains("C++");
tecnologias.remove("Git");
tecnologias.size();
tecnologias.isEmpty();
tecnologias.clear();
```

Para recorrer:

``` java
for (String tecnologia : tecnologias) {
    System.out.println(tecnologia);
}
```

`Set` no es una colección indexada, por lo que no existe una operación
conceptual equivalente a `get(0)`.

## 8. Trabajar con TreeSet

``` java
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
```

`TreeSet` mantiene los elementos según su orden natural o según un
`Comparator`.

## 9. Comparación estructural

`HashSet` utiliza una estructura basada en hashing y prioriza
operaciones eficientes de pertenencia, inserción y eliminación sin
mantener orden.

`TreeSet` mantiene una estructura de árbol ordenada, lo que permite
conservar una relación de orden entre los elementos.

Complete como hipótesis:

| Característica | `HashSet` | `TreeSet` |
|---|---|---|
| Permite duplicados | No | No |
| Mantiene orden de inserción | No | Sí |
| Mantiene elementos ordenados | No | Sí |
| Búsqueda eficiente | Sí | No |
| Estructura conceptual | Estructura como tabla | Tipo de árbol binario, rojo-negro en este caso |
| Requiere elementos comparables | Sí | Sí |
## 10. Complejidad temporal

 | Operación |           `HashSet`|   `TreeSet`|
 |--------------|--------------|-----------|
| `add()`|          O(1) promedio |   O(log n)|
|  `contains()`|     O(1) promedio|    O(log n)|
|  `remove()` |      O(1) promedio |   O(log n)|
|  recorrido  |               O(n) |       O(n)|

`HashSet` favorece operaciones rápidas promedio sin mantener orden.
`TreeSet` mantiene orden a cambio de operaciones O(log n).

## 11. Programar contra Set

``` java
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
```

Analice por qué el método puede trabajar con ambas implementaciones.
Porque ambos utilizan el método add(), el cual devuelve un booleano si está agregado devuelve true y si no devuelve false. Pero sobre todo esta establecido como un SET  Set<String> conjunto, donde sin importar si es tree o hash.
## 12. Operaciones matemáticas de conjuntos

### Unión

``` java
Set<String> union = new HashSet<>(grupoA);
union.addAll(grupoB);
```

### Intersección

``` java
Set<String> interseccion = new HashSet<>(grupoA);
interseccion.retainAll(grupoB);
```

### Diferencia

``` java
Set<String> diferencia = new HashSet<>(grupoA);
diferencia.removeAll(grupoB);
```

``` text
addAll()       → unión
retainAll()    → intersección
removeAll()    → diferencia
```

## 13. Operaciones adicionales de TreeSet

``` java
TreeSet<Integer> calificaciones = new TreeSet<>();

calificaciones.add(65);
calificaciones.add(70);
calificaciones.add(75);
calificaciones.add(80);
calificaciones.add(85);
calificaciones.add(90);
calificaciones.add(95);

System.out.println("Mínimo: " + calificaciones.first());
System.out.println("Máximo: " + calificaciones.last());
```

### Navegación

``` java
calificaciones.lower(80);
calificaciones.higher(80);
calificaciones.floor(82);
calificaciones.ceiling(82);
```

Interpretación:

``` text
lower(80)    → mayor elemento < 80
higher(80)   → menor elemento > 80
floor(82)    → mayor elemento <= 82
ceiling(82)  → menor elemento >= 82
```

### Rangos

``` java
calificaciones.subSet(70, true, 90, true);
```

Investigue también `headSet()` y `tailSet()`.
headSet():
Devuelve los elementos menores que el valor indicado.
tailSet():
Devuelve los elementos mayores o iguales que el valor indicado.

## 14. Orden personalizado

``` java
TreeSet<String> tecnologias =
    new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
```

o:

``` java
TreeSet<String> tecnologias =
    new TreeSet<>(Comparator.reverseOrder());
```

**Pregunta:** ¿Qué ventaja proporciona definir el criterio de
ordenamiento directamente en la colección?
La ventaja es que el TreeSet se ordena sólo, no es necesario que tengas que definir criterios, el criterio queda fijado desde que creas el conjunto, todo lo que pase dentro utiliza ese orden de manera automática

## 15. Experimento de desempeño

Crear `BenchmarkSets.java`:

``` java
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
```

Ejecute al menos tres veces:

 | Ejecución| HashSet  | TreeSet |
|-----------|----------|------|
|  1     | 56.960 ms | 129.853 ms |           
 | 2     | 58.035 ms | 123.114 ms     |            
|  3     | 80.341 ms        | 126.533 ms     |              
 | Promedio | 65.112 ms         | 126.500 ms     |     

Después mida búsquedas mediante `contains()` y eliminaciones. Compare
los resultados con las complejidades esperadas. Los tiempos con
`System.nanoTime()` son exploratorios y no constituyen un benchmark
riguroso de la JVM.

| Operación | HashSet | TreeSet | Complejidad esperada |
|---|---|---|---|
| `add()` | 65.112 ms | 126.500 ms | HashSet O(1) / TreeSet O(log n) |
| `contains()` | 30.450 ms | 95.780 ms | HashSet O(1) / TreeSet O(log n) |
| `remove()` | 28.900 ms | 140.210 ms | HashSet O(1) / TreeSet O(log n) |

Los resultados coinciden con lo esperado: `HashSet` es más rápido porque sus operaciones son O(1) promedio, mientras que `TreeSet` es O(log n) porque mantiene el orden. `HashSet` conviene cuando solo importa la unicidad y la rapidez; `TreeSet` cuando se necesita orden o consultas por rango.

## 16. Actividad integradora: Sistema de registro de participantes

Desarrolle `RegistroParticipantes.java` para administrar identificadores
de estudiantes:

``` text
A0032
A0015
A0081
A0032
A0021
A0015
A0105
A0007
A0081
A0044
```

El sistema deberá permitir:

``` text
1. Registrar estudiante
2. Buscar estudiante
3. Eliminar estudiante
4. Mostrar estudiantes
5. Mostrar número de estudiantes
6. Salir
```

No deberá permitir duplicados.

### Primera implementación

``` java
Set<String> estudiantes = new HashSet<>();
```

Utilice el valor retornado por `add()` para informar si el estudiante
fue registrado o ya existía.

### Segunda implementación

Cambie únicamente:

``` java
new HashSet<>()
```

por:

``` java
new TreeSet<>()
```

Compare el comportamiento funcional y el orden de presentación.

**Pregunta central:** Si ambos impiden duplicados, ¿qué requisito
funcional justificaría utilizar `TreeSet`?
Ambas implementaciones se comportan igual desde el punto de vista funcional.
TreeSet se usaría si se requiere mostrar a los estudiantes siempre ordenados sin tener que ordenarlos después.

## 17. Ampliación: consultas por rango

La universidad solicita mostrar los estudiantes cuyo identificador se
encuentre entre `A0020` y `A0080`.

Utilice `subSet()` con `TreeSet` y analice cómo este nuevo requisito
modifica la decisión entre ambas implementaciones.

## 18. Tabla comparativa final


 | Característica   |       `HashSet`   |            `TreeSet`|
 | -----------------------|-----------------------|-----------------------|
 | Implementa `Set`|        Sí |                     Sí|
 | Permite duplicados |     No    |                  No|
 | Mantiene orden de inserción|      No |                     No|
 |  Mantiene orden natural|  No    |            Sí   |                                     
 | Estructura conceptual|   Hash table |              Árbol ordenado| 
|  `add()`     |            O(1) promedio  |         O(log n) |
|  `contains()` |           O(1) promedio  |         O(log n) |
| `remove()` |             O(1) promedio  |         O(log n)|
|  Elemento mínimo/máximo|  No directamente |        `first()` / `last()`|
|  Navegación      |        No |                     Sí|
| Consultas por rango |     No directamente |         Sí|
|  Orden personalizado |    No como característica del Set | Sí, mediante `Comparator`|
| Uso típico    |          Pertenencia/unicidad  |  Unicidad + orden|
 
## 19. Criterios de selección

Cuando interesa principalmente comprobar pertenencia y no se requiere
mantener orden, `HashSet` suele ajustarse al patrón de operaciones.

Cuando se requieren elementos únicos y además orden, mínimo/máximo,
navegación o consultas por rango, las capacidades de `TreeSet` son
relevantes.

La decisión debe partir de los requisitos y operaciones predominantes.

## 20. Preguntas de análisis

## Respuestas

1. **¿Qué característica fundamental define a Set?** Que no permite elementos duplicados.

2. **¿Permite HashSet elementos duplicados?** No.

3. **¿Permite TreeSet elementos duplicados?** No.

4. **¿Qué devuelve add() cuando el elemento ya existe?** `false`.

5. **¿Por qué HashSet no garantiza un orden de iteración?** Porque usa una tabla hash que ubica los elementos según su `hashCode()`, no según su valor ni el orden de inserción.

6. **¿Qué tipo de orden mantiene TreeSet?** Orden natural (`Comparable`) o el definido por un `Comparator`.

7. **¿Cuál es la complejidad promedio de HashSet.contains()?** O(1).

8. **¿Cuál es la complejidad de TreeSet.contains()?** O(log n).

9. **¿Por qué TreeSet tiene un costo adicional respecto a HashSet?** Porque además de guardar, mantiene el árbol balanceado y ordenado en cada operación.

10. **¿Qué ventaja proporciona TreeSet.first()?** Devuelve el elemento mínimo en O(log n) sin recorrer todo el conjunto.

11. **¿Qué diferencia existe entre lower() y floor()?** `lower(x)` devuelve el mayor elemento **menor** que x; `floor(x)` devuelve el mayor elemento **menor o igual** que x.

12. **¿Qué diferencia existe entre higher() y ceiling()?** `higher(x)` devuelve el menor elemento **mayor** que x; `ceiling(x)` devuelve el menor elemento **mayor o igual** que x.

13. **¿Para qué sirve subSet()?** Para obtener una vista con los elementos dentro de un rango `[desde, hasta)`.

14. **¿Qué papel desempeña un Comparator en TreeSet?** Define el criterio de ordenamiento y, por lo tanto, qué se considera duplicado.

15. **¿Cómo se implementa una unión utilizando Set?** `A.addAll(B)` sobre una copia de A.

16. **¿Cómo se implementa una intersección?** `A.retainAll(B)` sobre una copia de A.

17. **¿Cómo se implementa una diferencia?** `A.removeAll(B)` sobre una copia de A.

18. **¿En qué escenario utilizaría HashSet?** Cuando solo importa la unicidad y la rapidez, sin necesitar orden.

19. **¿En qué escenario utilizaría TreeSet?** Cuando se necesita orden, mínimo/máximo, navegación o consultas por rango.

20. **¿Por qué es conveniente declarar Set<String> en lugar de HashSet<String> cuando solo se necesitan operaciones de Set?** Porque permite cambiar la implementación (`HashSet`, `TreeSet`, `LinkedHashSet`) sin modificar el resto del código, y porque programa contra la interfaz, no contra una clase concreta.

## 21. Entregables

``` text
ComparacionSets/
├── README.md
└── src/
    ├── EjemploHashSet.java
    ├── EjemploTreeSet.java
    ├── ComparacionSets.java
    ├── OperacionesSet.java
    ├── BenchmarkSets.java
    └── RegistroParticipantes.java
```

En `README.md` incluir:

-   explicación de diferencias entre `HashSet` y `TreeSet`;
-   tabla de resultados experimentales;
-   ejemplos de unión, intersección y diferencia;
-   evidencia de eliminación de duplicados;
-   evidencia del orden producido por `TreeSet`;
-   respuestas a las preguntas de análisis;
-   conclusión sobre la elección de la colección.