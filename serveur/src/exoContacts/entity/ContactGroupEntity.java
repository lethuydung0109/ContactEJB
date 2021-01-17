package exoContacts.entity;

import javax.persistence.*;
import java.util.*;

@Embeddable
@Table(name = "mySQLdb.CONTACTGROUP")
public class ContactGroupEntity {

	@Column(name="idContact")
    private long idContact;
	@Column(name="idGroup")
    private long idGroup;
	
	public ContactGroupEntity (){}

	public ContactGroupEntity (long group, long contact)
	{
		this.idContact=contact;
		this.idGroup=group;
	}
            
    public long getContact() {return idContact;}
    
    public long getGroup() {return idGroup; }
        
    public void setContact(long c) {idContact = c; }
    
    public void setGroup(long g) {idGroup = g; }
}

