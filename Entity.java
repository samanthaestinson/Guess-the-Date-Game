package GuessMaster;

/**
*<h1>Guess Master!</h1>
*This is the class used by GuessMaster. 
* <p>
* 
*279 Assignment 1
* @author  Samantha Stinson 20009335
* @version 1.0
* @since   2018-02-11 
*/

public class Entity {
	//instance variables
	private String name;
	private Date born;
	
	//constructor
	public Entity(String name, Date birth) {
		//string is object, its own class
		this.name = name;
		this.born = new Date(birth);
	}
	
	//constructor
	public Entity(Entity entity) {
		this.name=entity.name;
		this.born= new Date(entity.born);
	}
	
	//Accessor 
	public String getName() {
		return name;
	}
	
	//Accessor 
	public Date getBorn() {
		//returning a pointer, should be returning a new date that copies born
		return new Date(born);
	}
	
	public String toString() {
		//System.out.println(""+name+", born on "+born+".");
		String sentance;
		String inbetween=", born on";
		String period= ".";
		sentance= name + inbetween + born + period;
		return sentance;
	}
	
   /**
   * This method compares the content of two entities.
   * @param entity The object to be compared
   * @return recursion
   */
	public boolean equals(Entity entity) {
		if (entity == null) {
			return false;
		}
		else{
			return (name.equals(entity.getName()) && born.equals(entity.getBorn()));
			}
	}
	
}
