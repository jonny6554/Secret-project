package Devoir_3;

/**
 * 
 * @author Mathieu
 * exception qui arrive lorsqu'une erreur dans le texte Luca �crit est d�tect�e
 */
public class LukasSyntaxException extends RuntimeException{

	public LukasSyntaxException(String message){
		super(message);
	}
	
	public LukasSyntaxException(){
		
	}
	
}
