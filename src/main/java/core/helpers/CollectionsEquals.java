package core.helpers;

import java.util.Collection;

public class CollectionsEquals {
    public static <E> boolean equals(Collection<E> a, Collection<E> b) {
        // If the size is not the same
        if (a.size() != b.size())
            return false;

        // If there are any elements in A that are not in B
        else if (a.parallelStream().filter(elementA -> !b.contains(elementA)).count() > 0)
            return false;

        // If there are any elements in B that are not in A
        else if (b.parallelStream().filter(elementB -> !a.contains(elementB)).count() > 0)
            return false;

        // If the list match completely
        else
            return true;
    }
}