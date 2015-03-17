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
	
	/**
	 * Retourne la valeur associé à la clé spécifiée.
	 * Dans le cas d'un conflit, elle retourne la valeur la plus à gauche.
	 * 
	 * @param key la clé est associé à une valeur.
	 * @return on retourne la valeur associé à la clé donnée
	 * @throws NoSuchElementException est généré lorsqu'aucun valeur est associé à la clé.
//	 * @throws NullPointerException est généré lorsque la clé spécifié est null.
	 */
	public abstract V get(K key)throws NoSuchElementException, NullPointerException;
	
	/**
	 * Retourne true si une association existe pour la clé spécifiée.
	 * 
	 * @param key est la clé est associé à une valeur.
	 * @return est vrai seulement s'il existe une association pour la clé donnée
	 * @throws NullPointerException si la clé spécifié est null.
	 */
	public abstract boolean contains(K key) throws NullPointerException;
	
	/**
	 * Crée une nouvelle association clé-valeur.
	 * 
	 * @param key est la clé qui sera associé à la valeur donnée
	 * @param value est la valeur qui sera associé à la clé donné.
	 * @throws NullPointerException si la clé spécifié est null.
	 */
	public abstract void put(K key, V value) throws NullPointerException;
	
	/**
	 * Cette méthode remplace la valeur associé au clé spécifié.
	 * Dans le cas d'un conflit, elle remplace la valeur la plus à gauche.
	 * 
	 * @param key est la clé pour laquelle la valeur sera remplacé
	 * @param value est la nouvelle valeur à associé au clé.
	 * @throws NoSuchElementException est généré lorsqu'il n'y a pas de clé existent que l'on peut remplacer.
	 * @throws NullPointerException est généré si la clé spécifié est null.
	 */
	public abstract void replace(K key, V value) throws NoSuchElementException, NullPointerException;
	
	/**
	 * Cette méthode permet d'enlevé la valeur associé à une clé.
	 * Dans le cas d'un conflit, elle enlève la valeur la plus à gauche.
	 * 
	 * @param key est la clé pour laquelle l'association sera enlevé.
	 * @return la valeur qui vient d'être enlevé.
	 * @throws NoSuchElementException  est généré lorsqu'il n'y a pas de clé existent que l'on peut enlever.
	 * @throws NullPointerException est généré si la clé spécifié est null.
	 */
	public abstract  V remove(K key) throws NoSuchElementException, NullPointerException;
}
