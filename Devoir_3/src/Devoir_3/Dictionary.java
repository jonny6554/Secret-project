package Devoir_3;

import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Token> {

	/**
	 * L'atribut dictionnaire contient les paires d'associatoins.
	 */
	private Pair[] dictionary;

	/**
	 * Contient la valeur pour initialis� l'attribut
	 */
	private static final int INITIAL_SIZE_OF_DICTIONARY = 10;

	/**
	 * La longueur ajout� au dictionnaire lorsqu'il est remplit.
	 */
	private static final int SIZE_ADDED_TO_FULL_DICTIONARY = 5;

	/**
	 * Le constructeur de dictionnaire; elle initialise le param�tre
	 * dictionnaire.
	 */
	public Dictionary() {
		dictionary = new Pair[INITIAL_SIZE_OF_DICTIONARY];
		// Pair est statique; il n'est pas initialiser.
	}

	@Override
	/**
	 * Retourne la valeur associ� � la cl� sp�cifi�e.
	 * Dans le cas d'un conflit, elle retourne la valeur la plus � gauche.
	 * 
	 *
	 * @param key : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si le token recherch� n'existe pas
	 * @throws NullPointerException : lance l'exception si le key est null
	 * @return
	 */
	public Token get(String key) throws NoSuchElementException,
			NullPointerException {
		// Module
		try {
			for (Pair i : dictionary)
				if (key != null)
					if (i.key.toString() == key)
						if (i.value != null)
							return i.value;
						else
							// La valeur est nul, alors on lance une exception.
							throw new NullPointerException();
			// Car la cl� n'as pas �t� trouv�.
			throw new NoSuchElementException();

		} catch (NoSuchElementException e1) {
			System.out
					.println("L'�l�ment demand� n'existe pas; il n'y avait pas de token!");
		} catch (NullPointerException e2) {
			System.out.println("Il n'avait aucun �l�ment associ� au cl�!.");
		}
		// Pour la compilation
		return null;
	}

	@Override
	/**
	 * Retourne true si une association existe pour la cl� sp�cifi�e.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NullPointerException est g�n�r� lorsque la cl� sp�cifi� est null.
	 * @return
	 */
	public boolean contains(String key) throws NullPointerException {
		// D�claration des variables et dictionnaire des donn�es
		boolean resultat = false; // true ssi une valeur de ce type existe
		// Module
		try {
			if (key != null){
				for (Pair i : dictionary)
					if (i.key.toString() == key)
						resultat = true;
			}
			else
				throw new NullPointerException();
		} catch (NullPointerException e1) {
			System.out.println("La cl� sp�cifi� est null!");
		}
		// Retour de la variable r�sultat.
		return resultat;
	}

	@Override
	/**
	 * Cr�e une nouvelle association cl�-valeur.
	 * 
	 *
	 * @param String : symbole lu dans le programme de Luka
	 * @param Token : la valeur lue dans le programme de Luka
	 * @throws NullPointerException  : lance l'exception si la cl� est null.
	 */
	public void put(String key, Token value) throws NullPointerException {
		// TODO Auto-generated method stub
		try {
			// n
			if (key != null) {
				if (dictionary[dictionary.length - 1] != null)
					for (int i = 0; i < dictionary.length; i++)
						if (dictionary[i].key == null) {
							dictionary[i].value = value;
							dictionary[i].key = key;
						} else // Dictionnaire est de longueur maximale!
						{
							lengthenTheDictionary();
							put(key, value);
						}
			} else
				// la cl� est null
				throw new NullPointerException();
		} catch (NullPointerException e2) {
			System.out.println("La cl� est null!");
		}

	}

	@Override
	/**
	 * Cette m�thode remplace la valeur associ� au cl� sp�cifi�.
	 * Dans le cas d'un conflit, elle remplace la valeur la plus � gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la cl� n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la cl� sp�cifi� est null.
	 */
	public void replace(String key, Token value) throws NoSuchElementException, NullPointerException {
		//D�claration des variables et dictionnaire des donn�es
		boolean found = false; //Seulement vrai si on trouve la cl� � remplacer.
		//Module
		try {
				if (key != null)
					for (Pair i : dictionary){
						if(i.key == key){
							i.value = value;
							found = true;
						}
					}
				else //La cl� est null.
					throw new NullPointerException();
				if (!found)//Aucune valeur trouv�e afin de remplacer.
					throw new NoSuchElementException();			
		} catch (NoSuchElementException e1) {
			System.out.println("L'�l�ment demand� n'existaient pas!");
		}
		catch (NullPointerException e2){
			System.out.println("La cl� est null!");
		}
	}

	@Override

	/**
	 * Cette m�thode permet d'enlev� la valeur associ� � une cl�.
	 * Dans le cas d'un conflit, elle enl�ve la valeur la plus � gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la cl� n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la cl� sp�cifi� est null.
	 * @return 
	 */
	public Token remove(String key) throws NoSuchElementException, NullPointerException {
		try {
			//TODO: finish remove	
		} catch (NoSuchElementException e1) {
			System.out.println("L'�l�ment � enlev� n'existait pas!");
		}
		catch (NullPointerException e2){
			System.out.println("La cl� est null!");
		}
		return null;
	}
	/**
	 * Cette classe emmagasine une association String-Token. Elle est utilis� en
	 * tant que param�tre de la classe pour emmagasin� l'association des
	 * valeurs.
	 */
	private static class Pair {
		private Token value;
		private String key;
	}

	/**
	 * Cette classe agrandit la longueur du dictionnaire par la valeur sp�cifi�
	 * par la constante <code> SIZE_ADDED_TO_FULL_DICTIONARY </code>.
	 */
	private void lengthenTheDictionary() {
		// D�claration des variables et dictionnaire des donn�es.
		Pair[] tempDictionary = new Pair[dictionary.length
				+ SIZE_ADDED_TO_FULL_DICTIONARY];
		int counter = 0;
		// Module
		for (Pair i : dictionary)
			tempDictionary[++counter] = i;
		// La nouvelle dictionnaire prend la valeur de celle de la classe.
		dictionary = tempDictionary;
	}
}
