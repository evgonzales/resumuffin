package in.resumuff.core.repository;

import in.resumuff.core.entity.Resume;
import in.resumuff.core.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {}
