### SupRails 

#### Déploiement sur glashfish depuis Intellij :

* Ouvrez ce projet avec Intellij avec file > open > <dossier_du_projet>
* Cliquez droit sur src/java > Mark directory As > Sources Root (le dossier doit passer au bleu)
* Créez un repertoire "out" à la racine de votre projet.
* Cliquez droit sur la racine du projet puis Open Module Settings (ou appuyez sur F4)
* Onglet Project : 
    ** Choisissez une JDK 8 dans le menu déroulant
    ** Choisissez java 8 dans project language level
    ** Selectionnez le repertoire out (créé ci dessus) dans Project compiler output.
* Onglet Modules :
    ** Cliquez sur le + vert a droite : Library... choisissez Glassfish X.X.X et Glassfish X.X.X-EJB
    ** Cliquez sur le + vert à droite : Jars or directories ... chosissez le repertoire web/WEB-INF/lib
* Onglet Facets : Appuyez sur le + vert puis Chosissez Web et ensuite selectionnez le seul choix proposer puis OK.
* Assurez vous que le chemin vers le repertoire web est correct (par défaut idea le place dans .idea mais c'est incorrect)
* Cliquez sur create artifact en bas a droite.
* Cliquez sur apply puis ok
* Buildez votre projet
* Cliquez sur le menu déroulant à coté du bouton de build en haut a droite. Puis cliquez sur edit configurations...
* Cliquez sur le + vert en haut puis choisissez glassfish > local
* Paramètrez votre glassfish installé en local.
* Selectionnez domain1 dans la liste déroulante
* Dans l'onglet deployment cliquez sur le + vert pour ajouter votre artifact.
* Cliquez sur apply puis OK.
* Lancez votre serveur glasshfish, le navigateur souvrira tout seul sur la page d'accueil.

