package in.resumuff.core.service;

import in.resumuff.core.entity.Tag;
import in.resumuff.core.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {
    
    @Autowired
    private TagRepository repository;
    
    public Optional<Tag> createTag(Tag tag){
        return Optional.of(repository.save(tag));
    }
    
    public Optional<Tag> getTag(long id){
        return repository.findById(id);
    }
    
}
