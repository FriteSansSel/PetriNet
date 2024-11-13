PETRINET
Ce projet est une implémentation en Java d'un réseau de Petri, un modèle mathématique utilisé 
pour représenter des systèmes travaillant sur des variables discrètes. Un réseau de Petri se 
compose de places, transitions et arcs, chacun jouant un rôle dans la simulation de la dynamique 
des systèmes.

Pré-requis:
JUnit5 (pour les tests)

Version eclipse : 2023-09
Version JRE : JDK 21
JDK compliance level 20

Structure :
Main : Point d'entrée du programme, gérant l'initialisation et l'exécution de la simulation du 
réseau de Petri.
PetriNet : Classe contenant les places et transitions. elle contient des méthodes permettant d'ajouter
et supprimer des places ou transition.
Place : représente un emplacement dans le réseau, où les jetons peuvent être stockés.
Transition : représente une transition, activée sous certaines conditions basées sur les jetons 
présents dans les places entrant.
Arc : classe abstraite représentant un arc générique connectant une place et une transition.
InArc : un arc entrant reliant une place à une transition.
OutArc : un arc sortant reliant une transition à une place.
InhibitorArc : un arc d'inhibition qui peut etre activé seulement si aucun jeton est présent dans 
la place.
ClearingArc : un arc de remise à zéro, s'activant seulement si une il y a au moins un jeton dans la 
place et supprime les jetons d'une place une fois la transition déclenchée.


Créer et exécuter le petrinet:

Étape 1 : Initialisation

Créer une instance du réseau de Petri :
Une instance de la classe PetriNet est créée, initialisant le réseau vide sans places ni transitions.

Ajouter des places :
Des places sont ajoutées au réseau de Petri avec un certain nombre de jetons. Par exemple, addPlace(2) 
crée une place contenant 2 jetons.

Ajouter des transitions :
Une transition est ajoutée au réseau, ce qui permet de spécifier des règles de transfert de jetons
 entre les places.
 
Créer des arcs d’entrée et de sortie :
Un arc d’entrée est défini pour une transition avec une place source et un poids. Par exemple, 
addArcIn(1, place1) spécifie qu'un jeton doit être prélevé dans place1 pour activer la transition.
Un arc de sortie est défini pour une transition avec une place cible et un poids. Par exemple,
addArcOut(2, place2) indique que la transition ajoutera 2 jetons à place2 lorsqu'elle sera activée.


Étape 2 : Déclenchement de la transition

La méthode trigger(transition1) est utilisée pour exécuter la transition. Lorsqu'une transition 
est déclenchée :
La transition vérifie si les conditions d'activation sont remplies (par exemple, que les places 
d'entrée ont suffisamment de jetons).
Si les conditions sont remplies, la transition retire les jetons nécessaires des places d'entrée 
et les ajoutes sur les places de sortie.


Étape 3 : Affichage

Supposons qu'il y ait 2 jetons dans place1 et 3 dans place2 avant le déclenchement de la transition,
le terminal affichera :
Before :
place1 : 2
place2 : 3

Après le déclenchement de la transition, si place1 perd 1 jeton, car inArc a un poids de 1, et place2 
reçoit 2 jetons, car outArc a un poids de 2, le terminal affichera :
After :
place1 : 1
place2 : 5

Notre implémentation n'est pas conforme à notre diagramme de classe. En effet, au départ nous hésitions sur l'utilité de rajouté une class mère Arc, mais nous avons finalement décidé de faire une classe mère Arc afin de vérifier que la place et le poids donnés au constructeur soient conforme (Place non nulle et poids posiif) dans le but de factoriser le code.

Nous avons rajouté un attribut id pour les classes Place et Transition afin de pouvoir distinguer facilement ces objets notamment pour la suppression et la gestion des doublons d'arcs.

Enfin nous avons rajouter des méthodes dans la classe PetriNet pour ajouter les Arcs, les Places et les Transitions et aussi pour les supprimer.

