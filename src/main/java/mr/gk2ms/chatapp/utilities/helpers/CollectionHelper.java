package mr.gk2ms.chatapp.utilities.helpers;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;


public abstract class CollectionHelper {
	public static <T> Optional<T> firstWhere(Collection<T> list, Predicate<T> predicate) {
		for (T item : list) {
			if (predicate.test(item))
				return Optional.of(item);
		}
		return Optional.empty();
	}

	// public static <T> containsPreciselyAll(Collection<T>, )

}
