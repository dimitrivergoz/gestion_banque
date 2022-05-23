package com.esilv1.test;
import java.util.*;
import com.esilv1.classes.Banque;
import com.esilv1.classes.Compte;


public class TestBanque {
	public static Dictionary<String, String> lstbanques = new Hashtable<String, String>();
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Banque b1 = new Banque("Credit Agricole", "3 rue Labas");
		Banque b2 = new Banque("BNP", "32323 rue ici");
		Compte c1 = new Compte("Dimitri",21, 100, b1);
		Compte c2 = new Compte("Robert",1, 200000, b2);
		
		Boolean finish = false;
		Boolean connected_to_the_bank  = false;
		
		do {String b11 = com.esilv1.classes.Compte.lireChaine("Quel est le nom de votre banque ? \n");
		if(((Hashtable<String, String>) TestBanque.lstbanques).containsKey(b11)) {
			System.out.println("Bienvenue chez "+b11);
			connected_to_the_bank = true;
			int account1 = 0;
			do {
				account1 = com.esilv1.classes.Compte.lireEntier("Quel est l'ID de votre compte ? \n");
				if (Compte.lst_comptes_info_banque.get(account1)== null) {
					System.out.println("Ce compte n'existe pas !");
				}
			}while(Compte.lst_comptes_info_client.get(account1)== null); 
			
			if (Compte.lst_comptes_info_banque.get(account1).equals(b11)) {
				System.out.println("Bonjour "+Compte.lst_comptes_info_client.get(account1)+",");
				do {
					System.out.println("===================================");
					Integer choix_user = com.esilv1.classes.Compte.lireEntier("Que voulez-vous faire ? \n"
							+ "1: Créditer un compte \n"
							+ "2: Voir mon solde \n"
							+ "3: Retirer de l'argent \n"
							+ "4: Deposer de l'argent \n"
							+ "5: quitter \n"
							+ "=================================== \n");
					if (choix_user == 1) {
						Integer account2 = 0;
						do {
							account2 = com.esilv1.classes.Compte.lireEntier("Saisissez l'ID du compte que vous voulez créditer: \n");
							if (Compte.lst_comptes_info_client.get(account2)== null) {
								System.out.println("Ce compte n'existe pas !");
							}
							else if (account2==account1) {
								System.out.println("Cela est inutile de vous envoyer votre propre argent !");
								account2= 0;
							}
						}while(Compte.lst_comptes_info_client.get(account2)== null);
						int montant_a_debite = com.esilv1.classes.Compte.lireEntier("Combien d'argent voulez-vous envoyer à "+Compte.lst_comptes_info_client.get(account2)+" ? \n");
						Banque.transfert(account1,account2,montant_a_debite);
					}
					
					else if (choix_user == 2) {
						Compte.consulterCompte(account1);
						
					}
					else if (choix_user == 3) {
						Compte.retrait(account1);
					}
					else if (choix_user == 4) {
						Compte.depot(account1);
					}
					else if (choix_user == 5) {
						finish = true;
					}
					else {
						System.out.println("Veuillez taper: 1,2,3 ou 4");
					}
				}while(finish !=true);
				if (finish == true) {
					System.out.println("Merci d'avoir choisi "+b11+" ! \n A bientôt.");
				}
			}
			else {
				System.out.println("Vous vous êtes trompés de banque");
				connected_to_the_bank = false;
			}
			}
	else {
		System.out.println("Cette banque n'existe pas !!!!!!");
		
	}
}while(connected_to_the_bank != true);
		
		
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