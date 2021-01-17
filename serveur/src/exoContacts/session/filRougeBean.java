package exoContacts.session;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;
import java.util.logging.Logger;
import exoContacts.entity.*;

@Stateless (mappedName="demo")
public class filRougeBean implements filRougeItf {
    @PersistenceContext(unitName="demoPU")
    private EntityManager em;
	
	private static Logger log = Logger.getLogger("filRougeBean.class");

	public void addContact(String nom, String prenom, String email, String phone)
	{
//		String sql = "INSERT INTO contact (firstName,lastName,email,phone) VALUES ('"+nom+"' ,'" +prenom+"', '"+email+"', '"+phone+"')";
//		log.info("******** INSERT REQ ******** : "+sql);
//
//		em.createNativeQuery(sql).executeUpdate();

		ContactEntity contact = new ContactEntity(prenom, nom, email, phone);
		em.persist(contact);
	}

	public void addGroup(String name)
	{
//		String sql = "INSERT INTO groupe (name) VALUES ('"+name+"')";
//		log.info("******** INSERT REQ ******** : "+sql);
//		em.createNativeQuery(sql).executeUpdate();
		GroupEntity group = new GroupEntity(name);
		em.persist(group);

	}
	
	public void addContactToGroup(long idContact, long idGroup)
	{
//		String sql = "INSERT INTO contactgroup (group,nameContact) VALUES ("+group+" ,"+nameContact+")";
//		log.info("******** INSERT REQ ******** : "+sql);
//		em.createNativeQuery(sql).executeUpdate();

		ContactEntity contact = em.find(ContactEntity.class, idContact);
		if(contact == null){
			throw new EntityNotFoundException("Cannot find contact for ID");
		}
		GroupEntity group = em.find(GroupEntity.class, idGroup);
		if(group == null){
			throw new EntityNotFoundException("Cannot find group for ID");
		}

		if(contact != null){
			Set<GroupEntity> groups = contact.getGroups();
			groups.add(group);
			contact.setGroups(groups);
			em.persist(contact)	;
		}
	}

//	public void addContactToGroup(ContactEntity contact, GroupEntity group){
//		Set<GroupEntity> groups = contact.getGroups();
//		groups.add(group);
//		contact.setGroups(groups);
//		em.persist(contact);
//	}
	public List<String> getLesNoms()
	{
		return em.createQuery("SELECT ce.lastName FROM ContactEntity ce").getResultList();
	}
	
	public List<String> getLesNumeros(String groupName)
	{
		List<ContactEntity> contacts = em.createQuery("SELECT contact FROM GroupEntity ge WHERE ge.name ='"+groupName+"'").getResultList();
		List<String> phones = new ArrayList<>();
		
		for (ContactEntity c : contacts) {
			phones.add(c.getPhone());
		}
		
		return phones;				
	}
	
	public List<String> getLesGroupes(){
		return em.createQuery("SELECT g.name FROM GroupEntity g").getResultList();
	}

	public String getLesGroupesWithID(){
		List<GroupEntity> groups = em.createQuery("SELECT g FROM GroupEntity g").getResultList();
		StringBuilder stb = new StringBuilder();
		for (GroupEntity g : groups)
		{
			stb.append(g.getId() + " - " + g.getName() + "\n");
		}
		return stb.toString();
	}

	public String getLesContactsWithID(){
		List<ContactEntity> contacts = em.createQuery("SELECT c FROM ContactEntity c").getResultList();
		StringBuilder stb = new StringBuilder();
		for (ContactEntity c : contacts)
		{
			stb.append(c.getId() + " - " + c.getFirstName() + "-" + c.getLastName() + "\n");
		}
		return stb.toString();
	}

	public void findGroupIdByName(String name){
		String sql="SELECT idGroup FROM GroupEntity ge WHERE ge.name = '"+name+"'";
		em.createQuery(sql).getSingleResult().toString();
	}


}

