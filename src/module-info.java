module GestionBanque {
}

/**
On souhaite écrire un programme Java pour simuler l’opération de transfert d’argent d’un compte bancaire sur un autre.
On propose de structurer le programme en trois classes : la classe Compte, la classe Banque et la classe principale TestBanque.


Chaque objet de la classe Compte doit avoir la responsabilité de mettre à jour la valeur des soldes concernés par les opérations de retrait et de dépôt. 


Pour ce faire, la classe Compte doit être structurée par trois attributs (titulaire, numero et solde) et doit proposer les méthodes suivantes :
depot(), retrait(), consulterCompte et autorisationRetrait().




Les objets de la classe Banque sont structurés par le nom et l’adresse de la banque. 
Cette classe propose pour l’instant l’unique méthode transfert(), qui prend en argument, le montant du transfert, le compte à débiter et le compte à créditer.


La classe principale doit permettre sur la base de plusieurs exemples, de simuler diverses opérations de transfert.
**/