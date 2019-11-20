package in.resumuff.core.endpoints;

import in.resumuff.core.entity.Resume;
import in.resumuff.core.entity.action.UploadResume;
import in.resumuff.core.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    
    @PostMapping("/resume/upload")
    public ResponseEntity<Resume> uploadResume(HttpSession session, UploadResume request){
//        Long uid = (Long)session.getAttribute("uid");
//        if(uid == null)
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        
        Optional<Resume> storedResume = resumeService.storeResume(0, request.file, request.tags);
        if(storedResume.isPresent()){
            return ResponseEntity.ok(storedResume.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/resume/get/{id}")
    public ResponseEntity<Resume> getResume(@PathVariable long id){
        return ResponseEntity.of(resumeService.getResume(id));
    }

}
