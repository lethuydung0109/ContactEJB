import javax.naming.InitialContext;
import java.io.*;
import java.util.*;

public class Testeur {
    
    private static exoContacts.session.filRougeItf refBean ;
    
    public static void main(String[] args) throws Exception {
        
		Scanner sc,s;
		String input;
	    int somme=0;
	    String id,mdp,group="";
	    int ins;
				
        try {            
            InitialContext ctx = new InitialContext();
            refBean = (exoContacts.session.filRougeItf) ctx.lookup("demo");
        }
        catch (Exception ex) {
            System.err.println("erreur dans le lookup");
            ex.printStackTrace();
        }
       			
		sc = new Scanner(System.in);
	    
	    System.out.println("Veuillez vous connectez svp");
	    System.out.println("id :  ");
	    id=sc.nextLine();
	    
	    System.out.println("mdp :  ");
	    mdp =sc.nextLine();
	    
	    if (id.equals(mdp))
	    {
	        System.out.println("Vous êtes connecté(e) ! ");
	        System.out.println("\n Enter 'q' to exit.");
	        
	        while (true) {
	            
				System.out.println("\n Que souhaitez vous faire ? "+"\n"+
				"1 - Créer un contact \n"+
				"2 - Créer un groupe \n"+
				"3 - Ajouter un contact à mon groupe \n"+
				"4 - Afficher tous les contacts d'un groupe");
				
				System.out.println(" \n Tapez le numéro de l'instruction à exécuter ");	        
				ins=Integer.parseInt(sc.nextLine());
				
				System.out.println(" Instruction "+ins+" choisie");
				
					if(ins==1) {
						System.out.println(" Veuillez saisir les coordonnees du contact \n");						
						System.out.println(" Nom :");						
						String nom=sc.nextLine();
						
						System.out.println(" Prenom :");						
						String prenom=sc.nextLine();
						
						System.out.println(" Email :");
						String email=sc.nextLine();
						
						System.out.println(" Tel :");
						String tel=sc.nextLine();
						
						refBean.addContact(nom,prenom,email,tel);						
						System.out.println("\n Le contact "+nom+","+prenom+","+email+","+tel+" a bien été créé");
					}
					else if(ins==2){
						System.out.println(" Veuillez saisir le nom du group \n");						
						System.out.println(" Nom du groupe :  ");						
						String nomgroup=sc.nextLine();								
						
						refBean.addGroup(nomgroup);						
						System.out.println("\n Le group "+nomgroup+" a bien été créé");
					}
					else if(ins==3) {
						System.out.println(" Voici les groupes existants \n");
						String lesGroupes = refBean.getLesGroupesWithID();
						System.out.println(lesGroupes);

						System.out.println(" Saisissez le groupeID dans lequel vous souhaitez ajouter un contact \n");
						String idGroup = sc.nextLine();
						
						System.out.println(" Veuillez saisir l'ID du contact \n");
						System.out.println(" IDContact :");
						String idContact=sc.nextLine();
						refBean.addContactToGroup(Long.parseLong(idContact), Long.parseLong(idGroup));
//						Thread.sleep(10000);
					} else {
						System.out.println("\n Voici les numéros des contacts de votre groupe");
						List<String> lesNumeros = refBean.getLesGroupes();
						for (String tel : lesNumeros)
							System.out.println(tel);
					}
				}
			} else {
				System.out.println("Vos identifiants sont incorrects ");
				sc.close();	
			}		
    }
}

