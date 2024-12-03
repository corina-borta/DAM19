package org.scrum.restaurant.pattern;

import java.util.Collection;

public interface EntityRepository<T> {

    // Repository query implementation
    T getById(Object id);

    // QBExample
    boolean contains(T entitySample);

    Collection<T> getAll(T entitySample);

    T get(T entitySample);

    Collection<T> toCollection();

    T[] toArray();

    // Repository transaction implementation

    T add(T entity);

    Collection<T> addAll(Collection<T> entities);

    boolean remove(T entity);

    boolean removeAll(Collection<T> entities);

    // Others
    int size();

    T refresh(T entity);
}
