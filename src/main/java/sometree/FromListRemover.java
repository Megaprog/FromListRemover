package sometree;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FromListRemover {
    private FromListRemover() {}

    public static <T> List<T> removeNRepeatedInARow(List<T> list, int n) {
        if (n < 2) {
            throw new IllegalArgumentException("N must be greater or equal 2");
        }

        T repeatedElement = null;
        int repeatedIndex = -1;
        int repeatedCount = 1;
        int i = 0;

        while (i < list.size()) {
            if (repeatedIndex < 0 || !Objects.equals(repeatedElement, list.get(i))) {
                repeatedIndex = i;
                repeatedElement = list.get(i);
                repeatedCount = 1;
                i++;
            }
            else {
                repeatedCount++;
                if (repeatedCount >= n) {
                    for (int j = repeatedIndex; j <= i; j++) {
                        list.remove(repeatedIndex);
                    }
                    i = repeatedIndex;
                }
                else {
                    i++;
                }
            }
        }

        return list;
    }

    public static <T> List<T> removeNRepeated(List<T> list, int n) {
        if (n < 2) {
            throw new IllegalArgumentException("N must be greater or equal 2");
        }

        final List<T> repeatedNumbers = list.parallelStream().distinct()
                .filter(number -> list.parallelStream().filter(element -> element.equals(number)).count() >= n).collect(Collectors.toList());

        list.removeAll(repeatedNumbers);

        return list;
    }
}
