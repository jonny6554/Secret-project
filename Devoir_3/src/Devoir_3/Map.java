package Devoir_3;

import java.util.NoSuchElementException;

/**
 * Un map est responsable pour la création de l'association clé-valeur.
 * Elle peut contenir des clés dupliquées: lorsque c'est le cas, les méthodes
 * get, put, replace, et remove se réfère à la dernière valeur pour une clé donnée.
 * 
 * @param <K> représente le clé à associé à une valeur. (le clé est le nom de la variable)
 * @param <V> représente la valeur actuelle. (la valeur est la valeur associé avec cette variable)
 * @author Jonathan Horton (#numéroÉtudiant : 7710257) & Mathieu Harter (#numéroÉtudiant : 7377180)
 * @version sqrt(1.0)
 */
public interface Map<K,V> {
	
	public abstract V get(K key)throws NoSuchElementException, NullPointerException;
	
	public abstract boolean contains(K key);
	
	public abstract void put(K key, V value) throws NullPointerException;
	
	public abstract void replace(K key, V value) throws NoSuchElementException;
	
	public abstract  V remove(K key);
}
