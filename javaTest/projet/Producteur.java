/*
Projet java pour le cours info-f-202  langage de programmation 2
class implementant la class Producteur qui est un thread

Nom : Vandemaele Romain
Section : INFO2
Professeur : Berten Vandy
*/

package infof202.projetJava;

import java.util.Random;

public class Producteur  extends Thread 
{
	private MultiBox<Integer> items_;
	private int boxNbr_; //indice dans la multibox ou va produire le producteur
	private int itemNumber_; //nombre d'objets qu'il va produire
	
	public Producteur(MultiBox<Integer> items,int boxNumber,int itemNumber)
	{
		items_=items;
		boxNbr_=boxNumber;
		itemNumber_=itemNumber;
	}
	
	public void run()
	{
		//méthode qui va être éxécutés au lancement du thread
		Integer value;
		int limit=50; //taille max de la valeur mise dans la multiBox
		Random numberGenerator=new Random();
		for(int i=0;i<itemNumber_;++i)
		{
			value=numberGenerator.nextInt(limit);
			items_.put(boxNbr_, value);
		}
	}
	
}
