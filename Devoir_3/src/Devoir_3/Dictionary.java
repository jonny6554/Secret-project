package Devoir_3;

import java.util.NoSuchElementException;

/**
 * Une instance de Dictionary contient des pairs d'éléments clef-valeur (key-value)
 * qui peuvent être manipulé avec les méthodes de la classe. Un map peut contenir des
 * associations clef-valeur dupliqués. Lorsque c'est le cas, au besoin, la méthode 
 * appelée fait référence à la dernière valeur pour une clef donnée. 
 * 
 * Un dictionnaire est analogue à une matrice de variables: chaque variable a un nom
 * (la clef) et chaque variable est associé à une valeur (valeur de type <code> Token </code> 
 * (<code> String </code> ou <code> int </code>))
 * 
 * @author Jonathan Horton (jhort062@uottawa.ca) et Mathieu Harter (matem12345@hotmail.fr)
 * @version sqrt(1.0)
 */
public class Dictionary implements Map<String, Token> {

	/**
	 * L'atribut dictionnaire contient les paires d'associatoins.
	 */
	private Pair[] dictionary;
	
	/**
	 * Indique le nombre d'éléments dans le dictionnaire.
	 */
	private int numberOfElements;

	/**
	 * Contient la valeur pour initialisé l'attribut
	 */
	private static final int INITIAL_SIZE_OF_DICTIONARY = 10;

	/**
	 * La longueur ajouté au dictionnaire lorsqu'il est remplit.
	 */
	private static final int SIZE_ADDED_TO_FULL_DICTIONARY = 5;

	/**
	 * Le constructeur de <code> dictionnaire </code> et <code> numberOfElements; 
	 * elle initialise les paramètres. Elle créé aussi de nouvelles instances de Pair 
	 * dans le dictionnaire. Par défaut, la longueur initiale du dictionnaire
	 * est indiqué par <code> INITIAL_SIZE_OF_DICTIONARY </code>.
	 */
	public Dictionary() {
		numberOfElements = 0;
		dictionary = new Pair[INITIAL_SIZE_OF_DICTIONARY];
		// Pair est statique; il n'est pas initialiser.
		for (int i = 0; i < dictionary.length; i++)
			dictionary[i] = new Pair();
	}

	@Override
	/**
	 * Retourne la valeur associé à la clef spécifiée.
	 * Dans le cas d'un conflit, elle retourne la valeur la plus à gauche.
	 * 
	 *
	 * @param key : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si le token recherché n'existe pas
	 * @throws NullPointerException : lance l'exception si le key est null
	 * @return Retourne la valeur du Token associé au clef
	 */
	public Token get(String key) throws NoSuchElementException,
			NullPointerException {
		//Déclaration des variables et dictionnaire des données
		Token resultat = null; //Le résultat de la méthode.
		boolean found =false; //true seulement si l'élément recherché a été trouvé
		
		// Module
		try {
				if (key != null){
					for (int i = numberOfElements-1; i >= 0; i--)
						if (dictionary[i].key.equals(key)){
							resultat = dictionary[i].value;
							found = true;
							break;
						}
				}
				else 	// La valeur est nul, alors on lance une exception.
					throw new NullPointerException();
			if(!found)
				throw new NoSuchElementException();

		} catch (NoSuchElementException e1) {
			System.out.println("L'élément demandé n'existe pas; la clef est null. La méthode: get. "
							+ "Contenu de la clef: " + key);
			throw e1;
		} catch (NullPointerException e2) {
			System.out.println("Il n'avait aucun élément associé au clef! La méthode: get. "
					+ "Contenu de la clef:" + key);
			throw e2;
		}
		
		//Retour de la variable résultat
		return resultat;
	}

	@Override
	/**
	 * Retourne true si une association existe pour la clef spécifiée.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NullPointerException est généré lorsque la clef est null.
	 * @return faux ssi il n'y aucun association pour la clef donnée
	 */
	public boolean contains(String key) throws NullPointerException {
		// Déclaration des variables et dictionnaire des données
		boolean resultat = false; // true ssi une valeur de ce type existe
		
		// Module
		try {
			if (key != null){
				for (int i = numberOfElements - 1; i >=0; i--)
					if (dictionary[i].key == key)
						resultat = true;
			}
			else //La clef est null
				throw new NullPointerException();
		} catch (NullPointerException e1) {
			System.out.println("La clef spécifié est null! Méthode: contains. Contenu de la clef: " + key);
			throw e1;
		}
		
		// Retour de la variable résultat.
		return resultat;
	}

	@Override
	/**
	 * Crée une nouvelle association clef-valeur.
	 * 
	 *
	 * @param String : symbole lu dans le programme de Luka
	 * @param Token : la valeur lue dans le programme de Luka
	 * @throws NullPointerException  : lance l'exception si la clef ou la valeur spécifiée est null.
	 */
	public void put(String key, Token value) throws NullPointerException {
		//Module
		try {
			if (key != null && value != null) {
				if (dictionary[dictionary.length - 1].key == null){
					dictionary[numberOfElements].key = key;
					dictionary[numberOfElements++].value = value;
				}
				else // Dictionnaire est de longueur maximale!
				{
					lengthenTheDictionary();
					put(key, value);
				}
			} 
			else	// la clef ou la valeur est null
				throw new NullPointerException();
			
		} catch (NullPointerException e2) {
			System.out.println("La clef est null!  Méthode: put. Contenu de la clef: " + key 
					+ ". Contenu de la valeur: " + value + ".");
			throw e2;
		}

	}

	@Override
	/**
	 * Cette méthode remplace la valeur associé au clef spécifié.
	 * Dans le cas d'un conflit, elle remplace la valeur la plus à gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la clef n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la clef spécifié est null.
	 */
	public void replace(String key, Token value) throws NoSuchElementException, NullPointerException {
		//Déclaration des variables et dictionnaire des données
		boolean found = false; //Seulement vrai si on trouve la clef à remplacer.
		
		//Module		
		try {
				if (key != null && value != null)
					for (int i = numberOfElements-1; i >= 0; i--){
						if(dictionary[i].key == key){
							dictionary[i].value = value;
							found = true;
							break;
						}
					}
				else //La clef est null.
					throw new NullPointerException();
				if (!found)//Aucune valeur trouvée afin de remplacer.
					throw new NoSuchElementException();	
		} catch (NoSuchElementException e1) {
			System.out.println("L'élément demandé n'existaient pas! Méthode: replace. Contenu de la clef: " + key 
					+ ". Contenu de la valeur: " + value + ".");
			throw e1;	
		}
		catch (NullPointerException e2){
			System.out.println("La clef est null! Méthode: replace. Contenu de la clef: " + key 
					+ ". Contenu de la valeur: " + value + ".");
			throw e2;
		}
	}

	@Override
	/**
	 * Cette méthode permet d'enlevé la valeur associé à une clef.
	 * Dans le cas d'un conflit, elle enlève la valeur la plus à gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la clef n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la clef spécifié est null.
	 * @return La valeur du token associé à la clef enlevé.
	 */
	public Token remove(String key) throws NoSuchElementException, NullPointerException {
		//Déclaration des variables et dictionnaire des données
		Token resultat = null; //La valeur du token associé à la clef à enlevé
		boolean found = false; // True ssi l'élément est trouvé.
		//Module
		try {

			//Trouve la clef.
			if (key != null){
				for (int i =numberOfElements-1; i >= 0 ; i--) //On commence à chercher à l'élément ajouté le plus récemment.
				{
					if (dictionary[i].key.equals(key)){
						resultat =  dictionary[i].value;
						dictionary[i].value = null; //Essuyage.
						dictionary[i].key = null;
						--numberOfElements;
						organizeStack(); //On enlève l'espace "null" créé, si c'est le cas.
						found = true;
						break;
					}
				}
			}
			else //Alors la clef est null.
				 throw new NullPointerException();
			if (!found)
				throw new NoSuchElementException();
				
		} catch (NoSuchElementException e1) {
			System.out.println("L'élément à enlevé n'existait pas! Méthode: remove. "
					+ "Contenu de la clef: " + key);
			throw e1;
		}
		catch (NullPointerException e2){
			System.out.println("La clef est null! Méthode: remove. Contenu de la clef: " + key);
			throw e2;
		}
		//Retour de la variable résultat.
		return resultat;
	}
	
	/**
	 * Cette classe emmagasine une association String-Token. Elle est utilisé en
	 * tant qu'attribut de la classe pour emmagasiné l'association des valeurs.
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
		Pair[] newDictionary = new Pair[dictionary.length //Nouvelle dictionnaire qui sera plus grand que le dernier
				+ SIZE_ADDED_TO_FULL_DICTIONARY];		  //Et remplacera l'actuel avec les mêmes valeurs.
		
		// Module
		//On associe les valeurs du dictionnaire actuel avec la nouvelle
		for (int i =0; i < dictionary.length; i++)
			newDictionary[i] = dictionary[i];
		//On crée les éléments null qui ne sont pas présent dans le vieux dictionnaire
		for (int i = newDictionary.length - SIZE_ADDED_TO_FULL_DICTIONARY; i < newDictionary.length; i++)
			newDictionary[i] = new Pair();
		
		dictionary = newDictionary;
	}
	
	/**
	 * Cette méthode réorganise le stack lorsqu'il y a exactement <b> une </b> valeur null
	 * centré entre deux valeurs non null ou une valeur null au début de la matrice 
	 * <code> dictionary</code>. 
	 */
	private void organizeStack(){ 
		//Déclaration des variables et dictionnaire des données
		Pair temp =null; // Valeur temporaire pour faire l'échange.
		
		//Module
		for (int i = 1; i < (dictionary.length -1); i++)
		{  
			if (dictionary[0].key == null && dictionary[1].key != null) //Si la première clef est null.
			{
				temp = dictionary[1];
				dictionary[1] = dictionary[0];
				dictionary[0] = temp;
			}
			//On vérifie que l'élément null trouvé n'est pas null des deux coté pour que l'on ne 
			//change pas les valeurs nulls.
			if ((dictionary[i].key == null && dictionary[i-1].key != null && dictionary[i+1] !=null))
			{	//On fait des échanges répétés pour mettre le null à la fin
				for (int j = i+1; j < dictionary.length; j++){
					temp = dictionary[j];
					dictionary[j] = dictionary[j-1];
					dictionary[j-1] = temp;
				}
			}
		}
	}
}
