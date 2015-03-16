package Devoir_3;

import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Token> {

	@Override
	/**
	 * Retourne la valeur associ� � la cl� sp�cifi�e.
	 * Dans le cas d'un conflit, elle retourne la valeur la plus � gauche.
	 * 
	 * @param key : symbole lu dans le programme de luca
	 * @throws NoSuchElementException : lance l'exception si le token recherch� n'existe pas
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
	 * Retourne true si une association existe pour la cl� sp�cifi�e.
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
	 * Cr�e une nouvelle association cl�-valeur.
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
	 * Cette m�thode remplace la valeur associ� au cl� sp�cifi�.
	 * Dans le cas d'un conflit, elle remplace la valeur la plus � gauche.
	 * 
	 * @param String : symbole lu dans le programme de luca
	 * @throws NoSuchElementException : lance l'exception si le token n'existe pas
	 */
	public void replace(String key, Token value) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	/**
	 * Cette m�thode permet d'enlev� la valeur associ� � une cl�.
	 * Dans le cas d'un conflit, elle enl�ve la valeur la plus � gauche.
	 * 
	 * @param String : symbole lu dans le programme de luca
	 * @return 
	 */
	public Token remove(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
