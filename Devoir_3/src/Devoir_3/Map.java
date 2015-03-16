package Devoir_3;

import java.util.NoSuchElementException;

/**
 * Un map est responsable pour la cr�ation de l'association cl�-valeur.
 * Elle peut contenir des cl�s dupliqu�es: lorsque c'est le cas, les m�thodes
 * get, put, replace, et remove se r�f�re � la derni�re valeur pour une cl� donn�e.
 * 
 * @param <K> repr�sente le cl� � associ� � une valeur. (le cl� est le nom de la variable)
 * @param <V> repr�sente la valeur actuelle. (la valeur est la valeur associ� avec cette variable)
 * @author Jonathan Horton (#num�ro�tudiant : 7710257) & Mathieu Harter (#num�ro�tudiant : 7377180)
 * @version sqrt(1.0)
 */
public interface Map<K,V> {
	
	public abstract V get(K key)throws NoSuchElementException, NullPointerException;
	
	public abstract boolean contains(K key);
	
	public abstract void put(K key, V value) throws NullPointerException;
	
	public abstract void replace(K key, V value) throws NoSuchElementException;
	
	public abstract  V remove(K key);
}
