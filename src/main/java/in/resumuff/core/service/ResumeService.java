package in.resumuff.core.service;

import in.resumuff.core.entity.Resume;
import in.resumuff.core.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repository;
    
    public Optional<Resume> storeResume(long uid, MultipartFile file, int[] tags){
        String contentType = file.getContentType();
        if(contentType == null)
            return Optional.empty();
        
        try {
            Resume resume = new Resume(uid, file.getBytes(), contentType.startsWith("image/"), tags);
            return Optional.of(repository.save(resume));
        } catch (IOException exc){
            exc.printStackTrace();
        }
        
        return Optional.empty();
    }
    
    public Optional<Resume> getResume(long id){
        return repository.findById(id);
    }
    

}
