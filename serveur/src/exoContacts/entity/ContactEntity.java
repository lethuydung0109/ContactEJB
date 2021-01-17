package exoContacts.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "mySQLdb.CONTACT")
public class ContactEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idContact;
    private String firstName;
    private String lastName;
    private String email;
	private String phone;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="contactgroup",joinColumns=@JoinColumn(name="idContact"), 
	inverseJoinColumns=@JoinColumn(name="idGroup"))
	private Set<GroupEntity> groups=new HashSet<>();
	
	public ContactEntity (){}
	public ContactEntity (String firstName, String lastName,String email, String phone)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.phone=phone;
	}
    
    public long getId() {return idContact;}
    
    public void setId(long l) {idContact = l;}
    
    public String getEmail() {return email;}
    
    public String getFirstName() {return firstName; }
    
    public String getLastName() {return lastName; }
	
	public String getPhone() {return phone; }
    
    public void setEmail(String mail) {email = mail; }
    
    public void setFirstName(String prenom) {firstName = prenom; }
    
    public void setLastName(String nom) {lastName = nom; }
	
	public void setPhone(String num) {phone = num; }

	public Set<GroupEntity> getGroups() {
		return groups;
	}

	public void setGroups(Set<GroupEntity> groups) {
		this.groups = groups;
	}
}

