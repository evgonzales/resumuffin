package in.resumuff.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "rm_resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BIGINT")
    private long id;
    
    @Column(name = "uid", columnDefinition = "BIGINT")
    private long uid;
    
    @Column(name = "data", columnDefinition = "BYTEA")
    private byte[] data;
    
    @Column(name = "isImage", columnDefinition = "BOOLEAN")
    private boolean isImage;
    
    @Column(name = "tags", columnDefinition = "INTEGER[]")
    private int[] tagIds;
    
    public Resume(long uid, byte[] data, boolean isImage, int[] tagIds){
        this.uid = uid;
        this.data = data;
        this.isImage = isImage;
        this.tagIds = tagIds;
    }
    
    public long getId(){
        return id;
    }
    
    public long getOwner(){
        return uid;
    }
    
    public boolean isImage(){
        return isImage;
    }
    
    public byte[] getData(){
        return data;
    }
    
    public int[] getTags(){
        return tagIds;
    }
    
}
