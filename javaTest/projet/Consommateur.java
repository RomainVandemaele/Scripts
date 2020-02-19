/*
Projet java pour le cours info-f-202  langage de programmation 2
class implementant la class Consommateur qui est un thread

Nom : Vandemaele Romain
Section : INFO2
Professeur : Berten Vandy
*/

package infof202.projetJava;

public class Consommateur extends Thread 
{
	private MultiBox<Integer> items_;
	private int boxNbr_; //indice dans quel case de la multibox ou va consommer le consommateur
	private int itemNumber_; //nombre d'objets qu'il va consommer
	
	public Consommateur(MultiBox<Integer> items,int boxNumber,int itemNumber)
	{
		items_=items;
		boxNbr_=boxNumber;
		itemNumber_=itemNumber;
	}
	
	public void run()
	{
		for(int i=0;i<itemNumber_;++i)
		{
			items_.getItem(boxNbr_);
			
		}
		items_.getAll();
		
	}
	
}
