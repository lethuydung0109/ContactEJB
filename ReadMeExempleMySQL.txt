Pour exécuter cet exemple, il faut :

1) dans glassfish, avoir fait la connexion Glassfish-MySQL
==> cf. ReadMe sur la configuration de Glassfish branché avec un SGBD

2) dans glassfish, avoir créé un datasource nommé BDcontact 
==> cf. ReadMe sur la création d'un datasource mySQL

3) dans mySQL, avec sqlDeveloper (ou équivalent), avoir créé une table nommée CONTACT dans l’espace mySQLdb (donc le nom absolu de la table doit être mySQLdb.CONTACT) qui a les colonnes suivantes :
- id : intègre qui est la clé primaire
- firstName : chaîne de caractères
- lastName : chaîne de caractères
- email : : chaîne de caractères
IL FAUT OBLIGATOIREMENT RESPECTER CE NOMMAGE (nom absolu de la table, et noms des colonnes)

4) avoir inséré des rangées dans la table CONTACT


Ensuite, faire comme d’habitude :
- côté serveur, ant jar puis déployer l’archive dans glassfish
- côté client, ant compile puis lancer l’exécution du client avec la commande java