package gagliano.felipe.guitarras;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface GuitarrasRepository extends MongoRepository<Guitarra, String> {

    @Query( "{title : ?0 }")
    Optional<Guitarra> findByTitle(String title);
}
