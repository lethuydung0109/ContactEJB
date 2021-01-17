package exoContacts.session;

import javax.ejb.Remote;
import java.util.*;

@Remote()
public interface filRougeItf {
	public void addContact(String nom, String prenom, String email, String phone);
	public void addGroup(String nom);
	public void addContactToGroup(long idContact, long idGroup);
	public List<String> getLesNoms();
	public List<String> getLesNumeros(String groupName);
	public List<String> getLesGroupes();
	public String getLesGroupesWithID();
	public String getLesContactsWithID();
	public void findGroupIdByName(String name);
}
