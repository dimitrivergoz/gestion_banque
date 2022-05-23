package com.esilv1.classes;

import java.util.*;
import com.esilv1.test.*;
public class Banque {
	public String nom_banque;
	public String adresse_banque;
	ArrayList<Compte> lstcomptes;
	
	public Banque(String nom_banque, String adresse_banque) {
		super();
		this.nom_banque = nom_banque;
		this.adresse_banque = adresse_banque;
		TestBanque.lstbanques.put(nom_banque, adresse_banque);
	}
	Boolean finish = false;
	Boolean connected_to_the_bank  = false;
	Boolean connected_to_the_client_id  = false;
	Boolean check_account  = false;
	
	public static void transfert(Integer account1, Integer account2, int amount) {
		System.out.println("Pour: "+Compte.lst_comptes_info_client.get(account2)+",");
		Compte.autorisationRetrait(account1, account2, amount);
	}

	

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