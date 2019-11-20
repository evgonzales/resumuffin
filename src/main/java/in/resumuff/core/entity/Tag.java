package in.resumuff.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "rm_tags")
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BIGINT")
    private long id;
    
    private String text;
    
    public Tag(String text){
        this.text = text;
    }
    
    public long getId(){
        return id;
    }
    
    public String getText(){
        return text;
    }
    
}
