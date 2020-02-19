/*
Projet java pour le cours info-f-202  langage de programmation 2
class implementant la class MultiBox 

Nom : Vandemaele Romain
Section : INFO2
Professeur : Berten Vandy
*/

package infof202.projetJava;
import java.util.Vector;


public class MultiBox<Type>
{
	private Vector<Type> box_;
	private boolean askAll_=false; //indique si un getAll est en cours
	
	
	public MultiBox(int size)
	{
		box_=new Vector<Type>(size);
		//au debut il n'y a rien dans la multibox
		for(int i=0;i<size;++i)
		{
			box_.add(null);
		}
	}
	
	synchronized public void put(int pos, Type value)
	{
		//méthode permettant d'insérer un objet à une position précisé
		
		while(box_.get(pos)!=null) //le producer doit attendre que la case soit vide pour la remplir
		{
			
			try{this.wait();}
			catch(InterruptedException e){}
		}
		//mise à jour des attributs
		box_.setElementAt(value, pos);
		this.notifyAll(); //evite qu'un producteur reveille un autre producteur
	}
	
	synchronized public Type getItem(int pos)
	{
		//méthode permettant d'obtenir un objet dans une case(d'indice pos) de la multibox
		
		while(box_.get(pos)==null || askAll_) //Le consumer est mit en attente si la case est vide et s'il y a un getAll en cours pour éviter la famine
		{
			try{this.wait();}
			catch(InterruptedException e){}
		}
		
		Type res=box_.get(pos);
		box_.setElementAt(null, pos);
		this.notifyAll();
		return res;
		
	}
	
	synchronized public Vector<Type> getAll()
	{
		//méthode qui permet d'obtenir toute la multibox
		while(askAll_) //evite 2 getAll en meme temps
		{
			try{this.wait();}
			catch(InterruptedException e){}
		}
		askAll_=true;	
		boolean test=true; //indique si on doit tester si la multibox est pleine
		
			
		while(test)
		{
			boolean full=true; //indique si la multibox est pleine
			int i=0;
			while(i<box_.capacity() && full)
			{
				if(box_.get(i)==null)
				{
					full=false;
				}
				++i;
			}
				
			if(full)
			{
				test=false;
			}
			else
			{
				try{this.wait();} //si la box n'est pas rempli on attend
				catch(InterruptedException e){}
			}
		}
		
		askAll_=false; //on peut mettre askAll à false car il n'y a plus de wait donc on ne peut pas passer à un getItem ou getAll grace au verrou global
		//obtention des item
		for(int j=0;j<box_.capacity();++j)
		{
			getItem(j);
		}
		this.notifyAll();
		
		return box_;
		
	}
	
}
