package Devoir_3;

import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Token> {

	/**
	 * L'atribut dictionnaire contient les paires d'associatoins.
	 */
	private Pair[] dictionary;

	/**
	 * Contient la valeur pour initialisé l'attribut
	 */
	private static final int INITIAL_SIZE_OF_DICTIONARY = 10;

	/**
	 * La longueur ajouté au dictionnaire lorsqu'il est remplit.
	 */
	private static final int SIZE_ADDED_TO_FULL_DICTIONARY = 5;

	/**
	 * Le constructeur de dictionnaire; elle initialise le paramètre
	 * dictionnaire.
	 */
	public Dictionary() {
		dictionary = new Pair[INITIAL_SIZE_OF_DICTIONARY];
		// Pair est statique; il n'est pas initialiser.
	}

	@Override
	/**
	 * Retourne la valeur associé à la clé spécifiée.
	 * Dans le cas d'un conflit, elle retourne la valeur la plus à gauche.
	 * 
	 *
	 * @param key : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si le token recherché n'existe pas
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
			// Car la clé n'as pas été trouvé.
			throw new NoSuchElementException();

		} catch (NoSuchElementException e1) {
			System.out
					.println("L'élément demandé n'existe pas; il n'y avait pas de token!");
		} catch (NullPointerException e2) {
			System.out.println("Il n'avait aucun élément associé au clé!.");
		}
		// Pour la compilation
		return null;
	}

	@Override
	/**
	 * Retourne true si une association existe pour la clé spécifiée.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NullPointerException est généré lorsque la clé spécifié est null.
	 * @return
	 */
	public boolean contains(String key) throws NullPointerException {
		// Déclaration des variables et dictionnaire des données
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
			System.out.println("La clé spécifié est null!");
		}
		// Retour de la variable résultat.
		return resultat;
	}

	@Override
	/**
	 * Crée une nouvelle association clé-valeur.
	 * 
	 *
	 * @param String : symbole lu dans le programme de Luka
	 * @param Token : la valeur lue dans le programme de Luka
	 * @throws NullPointerException  : lance l'exception si la clé est null.
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
				// la clé est null
				throw new NullPointerException();
		} catch (NullPointerException e2) {
			System.out.println("La clé est null!");
		}

	}

	@Override
	/**
	 * Cette méthode remplace la valeur associé au clé spécifié.
	 * Dans le cas d'un conflit, elle remplace la valeur la plus à gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la clé n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la clé spécifié est null.
	 */
	public void replace(String key, Token value) throws NoSuchElementException, NullPointerException {
		//Déclaration des variables et dictionnaire des données
		boolean found = false; //Seulement vrai si on trouve la clé à remplacer.
		//Module
		try {
				if (key != null)
					for (Pair i : dictionary){
						if(i.key == key){
							i.value = value;
							found = true;
						}
					}
				else //La clé est null.
					throw new NullPointerException();
				if (!found)//Aucune valeur trouvée afin de remplacer.
					throw new NoSuchElementException();			
		} catch (NoSuchElementException e1) {
			System.out.println("L'élément demandé n'existaient pas!");
		}
		catch (NullPointerException e2){
			System.out.println("La clé est null!");
		}
	}

	@Override

	/**
	 * Cette méthode permet d'enlevé la valeur associé à une clé.
	 * Dans le cas d'un conflit, elle enlève la valeur la plus à gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la clé n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la clé spécifié est null.
	 * @return 
	 */
	public Token remove(String key) throws NoSuchElementException, NullPointerException {
		try {
			//TODO: finish remove	
		} catch (NoSuchElementException e1) {
			System.out.println("L'élément à enlevé n'existait pas!");
		}
		catch (NullPointerException e2){
			System.out.println("La clé est null!");
		}
		return null;
	}
	/**
	 * Cette classe emmagasine une association String-Token. Elle est utilisé en
	 * tant que paramètre de la classe pour emmagasiné l'association des
	 * valeurs.
	 */
	private static class Pair {
		private Token value;
		private String key;
	}

	/**
	 * Cette classe agrandit la longueur du dictionnaire par la valeur spécifié
	 * par la constante <code> SIZE_ADDED_TO_FULL_DICTIONARY </code>.
	 */
	private void lengthenTheDictionary() {
		// Déclaration des variables et dictionnaire des données.
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
