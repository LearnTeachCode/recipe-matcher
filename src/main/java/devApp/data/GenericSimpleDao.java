package devApp.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface GenericSimpleDao<E> {

    /**
     * Save and return hockey skater entity.
     * @param element entity to save and return.
     * @return saved object.
     */
    E save(E element);

    /**
     * Load the entity by its id.
     * @param key id to look for.
     * @return an entity with given database key, null if not found.
     */
    E get(Number key);

    /**
     * Load all entities from the database, will never be null, could be an empty list.
     * @return all entities from database, could be empty in case of an error.
     */
    List<E> getAll();

    /**
     * Delete an entity by its database id.
     * @param key id to look for.
     */
    void delete(Number key);
}
