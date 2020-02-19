/*
Projet java pour le cours info-f-202  langage de programmation 2
class principale qui lance les threads

Nom : Vandemaele Romain
Section : INFO2
Professeur : Berten Vandy
*/

package infof202.projetJava;



public class Main
{
	public static void main(String[] args)
	{

		int producteur=Integer.parseInt(args[0]);
		int consommateur=Integer.parseInt(args[1]);
		int size=producteur>consommateur?consommateur:producteur,i,item=2;//size definit la taille de la multibox et item le nombre min d'item consommé/produit
		MultiBox<Integer> box=new MultiBox<Integer>(size);
		Consommateur c=new Consommateur(box,0,item),cPrime=new Consommateur(box,0,item);
		Producteur p=new Producteur(box,0,item),pPrime=new Producteur(box,0,item);
		int r,m;
		if(producteur>consommateur)
		{
			r=(producteur/consommateur)-1;
			m=producteur%consommateur;
			//lancement d'un thread cosommateur et producteur  pour chaque case
			for(i=0;i<size;++i)
			{
				c=new Consommateur(box,i,item+r*item+(i<m?item:0));
				c.start();
				p=new Producteur(box,i,item+consommateur);
				p.start();
			}
			for(i=0;i<(producteur-consommateur);++i)
			{
				//lancement threads supplementaire
				pPrime=new Producteur(box,i%size,item);
				pPrime.start();
			}
		}
		else 
		{
			r=(consommateur/producteur)-1;
			m=consommateur%producteur;
			for(i=0;i<size;++i)
			{
				c=new Consommateur(box,i,item);
				c.start();
				p=new Producteur(box,i,item+consommateur+r*item+(i<m?item:0));
				p.start();
			}
			for(i=0;i<(consommateur-producteur);++i)
			{
				cPrime=new Consommateur(box,i%size,item);
				cPrime.start();
			}
		}
		
		try
		{
			//on attend que les threads se terminent
			c.join();
			p.join();
			cPrime.join();
			pPrime.join();
		}
		catch(InterruptedException e){e.printStackTrace();}
		System.out.println("The process is finished");
		
	}
}
