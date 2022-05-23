module GestionBanque {
}

/**
On souhaite �crire un programme Java pour simuler l�op�ration de transfert d�argent d�un compte bancaire sur un autre.
On propose de structurer le programme en trois classes : la classe Compte, la classe Banque et la classe principale TestBanque.


Chaque objet de la classe Compte doit avoir la responsabilit� de mettre � jour la valeur des soldes concern�s par les op�rations de retrait et de d�p�t. 


Pour ce faire, la classe Compte doit �tre structur�e par trois attributs (titulaire, numero et solde) et doit proposer les m�thodes suivantes :
depot(), retrait(), consulterCompte et autorisationRetrait().




Les objets de la classe Banque sont structur�s par le nom et l�adresse de la banque. 
Cette classe propose pour l�instant l�unique m�thode transfert(), qui prend en argument, le montant du transfert, le compte � d�biter et le compte � cr�diter.


La classe principale doit permettre sur la base de plusieurs exemples, de simuler diverses op�rations de transfert.
**/