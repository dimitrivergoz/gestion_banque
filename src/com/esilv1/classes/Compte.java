package com.esilv1.classes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Compte {
	public class autorisationRetrait {

	}
	public String nom;
	public int id;
	public static int solde;
	public static Banque banque_client;
	public static Dictionary<Integer, String> lst_comptes_info_banque = new Hashtable<Integer, String>();
	public static Dictionary<Integer, String> lst_comptes_info_client = new Hashtable<Integer, String>();
	public static Dictionary<Integer, Integer> lst_comptes_info_client_solde = new Hashtable<Integer, Integer>();

	public Compte(String nom, int id, int solde, Banque banque_client) {
		this.nom = nom;
		this.id = id;
		Compte.solde = solde;
		Compte.banque_client = banque_client;
		lst_comptes_info_banque.put(id, banque_client.nom_banque);
		lst_comptes_info_client.put(id, nom);
		lst_comptes_info_client_solde.put(id, solde);
	}
	
	public static void depot(int account1) {
		System.out.println("Bienvenue dans la section \" Déposer de l'argent\"");
		Integer depot_amount = lireEntier("Combien voulez-vous deposer ?");
		if (depot_amount>0) {
			Compte.lst_comptes_info_client_solde.put(account1, Compte.lst_comptes_info_client_solde.get(account1)+depot_amount);
			Compte.solde = Compte.lst_comptes_info_client_solde.get(account1)+depot_amount;
			System.out.println("Votre compte a bien été credité de "+depot_amount+"€.\n Vous avez maintenant:"+Compte.lst_comptes_info_client_solde.get(account1)+"€");
		}
		else {
			System.out.println("Le montant doit être supérieur à 0€");
		}
	}
	public static void retrait(int account1) {
		System.out.println("Bienvenue dans la section \" Retirer de l'argent\"");
		Integer retrait_amount = lireEntier("Combien voulez-vous retirer ?");
		if (retrait_amount<=0) {
			System.out.println("Choisissez un montant supérieur à 0.");
		}
		else if (retrait_amount>Compte.lst_comptes_info_client_solde.get(account1)) {
			System.out.println("Malheuresement, vous n'avez pas les fonds nécessaires.");
		}
		else {
			Compte.solde = Compte.lst_comptes_info_client_solde.get(account1)-retrait_amount;
			Compte.lst_comptes_info_client_solde.put(account1, Compte.lst_comptes_info_client_solde.get(account1)-retrait_amount);
			System.out.println("Votre compte a bien été dépité de "+retrait_amount+"€.\n Vous avez maintenant:"+Compte.solde+"€");
		}
	}
	public static void consulterCompte(int account1) {
		System.out.println("Bienvenue dans la section \" Voir mon solde\"");
		System.out.println("Votre solde est de: "+Compte.lst_comptes_info_client_solde.get(account1)+"€.");
	}
	public static void autorisationRetrait(int account1, int account2, int amount) {
		if (Compte.lst_comptes_info_client_solde.get(account1)-amount < 0) {
			Compte.solde = Compte.lst_comptes_info_client_solde.get(account1)+amount;
			System.out.println("Transaction refusée ! Il vous manque l'argent necessaire. \n"+"Votre argent: "+ Compte.lst_comptes_info_client_solde.get(account1)+"€ < "+"le montant: "+amount+"€");
		}else {
			Compte.solde = Compte.solde-amount;
			System.out.println("Paiement effectué de: "+amount+"€ pour "+Compte.lst_comptes_info_client.get(account2));
			//System.out.println("==>Avant "+Compte.lst_comptes_info_client_solde.get(account2));
			Compte.lst_comptes_info_client_solde.put(account2, Compte.lst_comptes_info_client_solde.get(account2)+amount);
			Compte.lst_comptes_info_client_solde.put(account1, Compte.lst_comptes_info_client_solde.get(account1)-amount);
			//System.out.println("==>Après "+Compte.lst_comptes_info_client_solde.get(account2));
			System.out.println("==> Vous avez, désormais, "+Compte.lst_comptes_info_client_solde.get(account1)+"€ sur votre compte.");
		}
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSolde() {
		return solde;
	}
	
	public static String lireChaine(String message){
	 	String ligne = null;
	 	try{
	 		//conversion d'un flux binaire en un flux de caract�res (caract�res Unicode)
	 		InputStreamReader isr = new InputStreamReader(System.in);
	 		//construction d'un tampon pour optimiser la lecture du flux de caract�res
	 		BufferedReader br = new BufferedReader(isr);
	 		System.out.print(message);
	 		// lecture d'une ligne
	 		ligne = br.readLine();
	 	}
	 	catch (IOException e){
	 		System.err.println(e.getMessage());
	 	}
	 	return ligne;
	 }// fin lireChaine
	 public static int lireEntier(String message){
	 	return Integer.parseInt(lireChaine(message));
	 }
	 public static double lireReel(String message){
	 	return Double.parseDouble(lireChaine(message));
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