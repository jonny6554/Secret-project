package Devoir_3;

import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Token> {

	@Override
	/**
	 * Retourne la valeur associé à la clé spécifiée.
	 * Dans le cas d'un conflit, elle retourne la valeur la plus à gauche.
	 * 
	 * @param key : symbole lu dans le programme de luca
	 * @throws NoSuchElementException : lance l'exception si le token recherché n'existe pas
	 * @throws NullPointerException : lance l'exception si le key est null
	 * @return
	 */
	public Token get(String key) throws NoSuchElementException,
			NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Retourne true si une association existe pour la clé spécifiée.
	 * 
	 * @param String : symbole lu dans le programme de luca
	 * @return
	 */
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	/**
	 * Crée une nouvelle association clé-valeur.
	 * 
	 * @param String : symbole lu dans le programme de luca
	 * @param Token : la valeur lue dans le programme de luca
	 * @throws NullPointerException  : lance l'exception si le key token est null
	 */
	public void put(String key, Token value) throws NullPointerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	/**
	 * Cette méthode remplace la valeur associé au clé spécifié.
	 * Dans le cas d'un conflit, elle remplace la valeur la plus à gauche.
	 * 
	 * @param String : symbole lu dans le programme de luca
	 * @throws NoSuchElementException : lance l'exception si le token n'existe pas
	 */
	public void replace(String key, Token value) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	/**
	 * Cette méthode permet d'enlevé la valeur associé à une clé.
	 * Dans le cas d'un conflit, elle enlève la valeur la plus à gauche.
	 * 
	 * @param String : symbole lu dans le programme de luca
	 * @return 
	 */
	public Token remove(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
