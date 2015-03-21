package Devoir_3;

import java.util.NoSuchElementException;

/**
 * Une instance de Dictionary contient des pairs d'�l�ments clef-valeur (key-value)
 * qui peuvent �tre manipul� avec les m�thodes de la classe. Un map peut contenir des
 * associations clef-valeur dupliqu�s. Lorsque c'est le cas, au besoin, la m�thode 
 * appel�e fait r�f�rence � la derni�re valeur pour une clef donn�e. 
 * 
 * Un dictionnaire est analogue � une matrice de variables: chaque variable a un nom
 * (la clef) et chaque variable est associ� � une valeur (valeur de type <code> Token </code> 
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
	 * Indique le nombre d'�l�ments dans le dictionnaire.
	 */
	private int numberOfElements;

	/**
	 * Contient la valeur pour initialis� l'attribut
	 */
	private static final int INITIAL_SIZE_OF_DICTIONARY = 10;

	/**
	 * La longueur ajout� au dictionnaire lorsqu'il est remplit.
	 */
	private static final int SIZE_ADDED_TO_FULL_DICTIONARY = 5;

	/**
	 * Le constructeur de <code> dictionnaire </code> et <code> numberOfElements; 
	 * elle initialise les param�tres. Elle cr�� aussi de nouvelles instances de Pair 
	 * dans le dictionnaire. Par d�faut, la longueur initiale du dictionnaire
	 * est indiqu� par <code> INITIAL_SIZE_OF_DICTIONARY </code>.
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
	 * Retourne la valeur associ� � la clef sp�cifi�e.
	 * Dans le cas d'un conflit, elle retourne la valeur la plus � gauche.
	 * 
	 *
	 * @param key : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si le token recherch� n'existe pas
	 * @throws NullPointerException : lance l'exception si le key est null
	 * @return Retourne la valeur du Token associ� au clef
	 */
	public Token get(String key) throws NoSuchElementException,
			NullPointerException {
		//D�claration des variables et dictionnaire des donn�es
		Token resultat = null; //Le r�sultat de la m�thode.
		boolean found =false; //true seulement si l'�l�ment recherch� a �t� trouv�
		
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
			System.out.println("L'�l�ment demand� n'existe pas; la clef est null. La m�thode: get. "
							+ "Contenu de la clef: " + key);
			throw e1;
		} catch (NullPointerException e2) {
			System.out.println("Il n'avait aucun �l�ment associ� au clef! La m�thode: get. "
					+ "Contenu de la clef:" + key);
			throw e2;
		}
		
		//Retour de la variable r�sultat
		return resultat;
	}

	@Override
	/**
	 * Retourne true si une association existe pour la clef sp�cifi�e.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NullPointerException est g�n�r� lorsque la clef est null.
	 * @return faux ssi il n'y aucun association pour la clef donn�e
	 */
	public boolean contains(String key) throws NullPointerException {
		// D�claration des variables et dictionnaire des donn�es
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
			System.out.println("La clef sp�cifi� est null! M�thode: contains. Contenu de la clef: " + key);
			throw e1;
		}
		
		// Retour de la variable r�sultat.
		return resultat;
	}

	@Override
	/**
	 * Cr�e une nouvelle association clef-valeur.
	 * 
	 *
	 * @param String : symbole lu dans le programme de Luka
	 * @param Token : la valeur lue dans le programme de Luka
	 * @throws NullPointerException  : lance l'exception si la clef ou la valeur sp�cifi�e est null.
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
			System.out.println("La clef est null!  M�thode: put. Contenu de la clef: " + key 
					+ ". Contenu de la valeur: " + value + ".");
			throw e2;
		}

	}

	@Override
	/**
	 * Cette m�thode remplace la valeur associ� au clef sp�cifi�.
	 * Dans le cas d'un conflit, elle remplace la valeur la plus � gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la clef n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la clef sp�cifi� est null.
	 */
	public void replace(String key, Token value) throws NoSuchElementException, NullPointerException {
		//D�claration des variables et dictionnaire des donn�es
		boolean found = false; //Seulement vrai si on trouve la clef � remplacer.
		
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
				if (!found)//Aucune valeur trouv�e afin de remplacer.
					throw new NoSuchElementException();	
		} catch (NoSuchElementException e1) {
			System.out.println("L'�l�ment demand� n'existaient pas! M�thode: replace. Contenu de la clef: " + key 
					+ ". Contenu de la valeur: " + value + ".");
			throw e1;	
		}
		catch (NullPointerException e2){
			System.out.println("La clef est null! M�thode: replace. Contenu de la clef: " + key 
					+ ". Contenu de la valeur: " + value + ".");
			throw e2;
		}
	}

	@Override
	/**
	 * Cette m�thode permet d'enlev� la valeur associ� � une clef.
	 * Dans le cas d'un conflit, elle enl�ve la valeur la plus � gauche.
	 * 
	 * @param String : symbole lu dans le programme de Luka
	 * @throws NoSuchElementException : lance l'exception si la clef n'existe pas.
	 * @throws NullPointerException : lance l'exception lorsque la clef sp�cifi� est null.
	 * @return La valeur du token associ� � la clef enlev�.
	 */
	public Token remove(String key) throws NoSuchElementException, NullPointerException {
		//D�claration des variables et dictionnaire des donn�es
		Token resultat = null; //La valeur du token associ� � la clef � enlev�
		boolean found = false; // True ssi l'�l�ment est trouv�.
		//Module
		try {

			//Trouve la clef.
			if (key != null){
				for (int i =numberOfElements-1; i >= 0 ; i--) //On commence � chercher � l'�l�ment ajout� le plus r�cemment.
				{
					if (dictionary[i].key.equals(key)){
						resultat =  dictionary[i].value;
						dictionary[i].value = null; //Essuyage.
						dictionary[i].key = null;
						--numberOfElements;
						organizeStack(); //On enl�ve l'espace "null" cr��, si c'est le cas.
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
			System.out.println("L'�l�ment � enlev� n'existait pas! M�thode: remove. "
					+ "Contenu de la clef: " + key);
			throw e1;
		}
		catch (NullPointerException e2){
			System.out.println("La clef est null! M�thode: remove. Contenu de la clef: " + key);
			throw e2;
		}
		//Retour de la variable r�sultat.
		return resultat;
	}
	
	/**
	 * Cette classe emmagasine une association String-Token. Elle est utilis� en
	 * tant qu'attribut de la classe pour emmagasin� l'association des valeurs.
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
		Pair[] newDictionary = new Pair[dictionary.length //Nouvelle dictionnaire qui sera plus grand que le dernier
				+ SIZE_ADDED_TO_FULL_DICTIONARY];		  //Et remplacera l'actuel avec les m�mes valeurs.
		
		// Module
		//On associe les valeurs du dictionnaire actuel avec la nouvelle
		for (int i =0; i < dictionary.length; i++)
			newDictionary[i] = dictionary[i];
		//On cr�e les �l�ments null qui ne sont pas pr�sent dans le vieux dictionnaire
		for (int i = newDictionary.length - SIZE_ADDED_TO_FULL_DICTIONARY; i < newDictionary.length; i++)
			newDictionary[i] = new Pair();
		
		dictionary = newDictionary;
	}
	
	/**
	 * Cette m�thode r�organise le stack lorsqu'il y a exactement <b> une </b> valeur null
	 * centr� entre deux valeurs non null ou une valeur null au d�but de la matrice 
	 * <code> dictionary</code>. 
	 */
	private void organizeStack(){ 
		//D�claration des variables et dictionnaire des donn�es
		Pair temp =null; // Valeur temporaire pour faire l'�change.
		
		//Module
		for (int i = 1; i < (dictionary.length -1); i++)
		{  
			if (dictionary[0].key == null && dictionary[1].key != null) //Si la premi�re clef est null.
			{
				temp = dictionary[1];
				dictionary[1] = dictionary[0];
				dictionary[0] = temp;
			}
			//On v�rifie que l'�l�ment null trouv� n'est pas null des deux cot� pour que l'on ne 
			//change pas les valeurs nulls.
			if ((dictionary[i].key == null && dictionary[i-1].key != null && dictionary[i+1] !=null))
			{	//On fait des �changes r�p�t�s pour mettre le null � la fin
				for (int j = i+1; j < dictionary.length; j++){
					temp = dictionary[j];
					dictionary[j] = dictionary[j-1];
					dictionary[j-1] = temp;
				}
			}
		}
	}
}
