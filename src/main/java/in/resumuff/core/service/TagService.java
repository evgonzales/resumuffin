package in.resumuff.core.service;

import in.resumuff.core.entity.Tag;
import in.resumuff.core.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    
    @Autowired
    private TagRepository repository;
    
    public Optional<Tag> createTag(Tag tag){
        Optional<Tag> existing = getTag(tag.getId());
        if(existing.isPresent())
            return existing;

        if((existing = getTagByText(tag.getText())).isPresent())
            return existing;

        try {
            tag = repository.save(tag);
        } catch (PersistenceException exc){
            repository.deleteById(tag.getId());
        }
        return Optional.of(tag);
    }
    
    public Optional<Tag> getTag(long id){
        return repository.findById(id);
    }

    public Optional<Tag> getTagByText(String text){
        return repository.findByText(text);
    }

    public Iterable<Tag> getAllTags(){
        return repository.findAll();
    }

    public boolean validTags(int[] tags){
        for(int id : tags){
            if(!getTag(id).isPresent())
                return false;
        }
        return true;
    }
    
}
