package exoContacts.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "mySQLdb.GROUPE")
public class GroupEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
    private long idGroup;
    private String name;
	
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy="groups")
    private List<ContactEntity> contacts;
	
	public GroupEntity (){}
	
	public GroupEntity (String name)
	{
		this.name=name;
	}
    
    public long getId() {return idGroup;}
    
    public void setId(long l) {idGroup = l;}
    
    public String getName() {return name; }
    
    public List<ContactEntity> getListContacts() {return contacts; }
	    
    public void setName(String nom) {name = nom; }
    	
	public void setListContacts(List<ContactEntity> newContacts) {contacts = newContacts; }
}

