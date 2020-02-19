public class RationalLowerTriangularMatrix extends Rational
{
	private Rational m[][];
	
	public RationalLowerTriangularMatrix(int size)
	{
		this.m=new Rational[size][];
		for(int i=0;i<this.m.length;++i)
		{
			m[i]=new Rational[i+1];
			for(int j=0;j<this.m[i].length;++j)
			{
				this.m[i][j]=new Rational();
			}
		}
		
	}
	
	public void setValue(int i, int j, Rational r)
	{
		if(i<this.m.length && j<=i)
		{
			this.m[i][j]=r;
		}
		else
		{
			//gestion exception
		}
		
	}
	
	public Rational getValue(int i, int j)
	{
		if(i<this.m.length && j<=i)
		{
			return this.m[i][j];
		}
		else
		{
			//gestion exception
			return this.m[0][0];
			
		}
		
	}

	
	public Rational getSum()
	{
		Rational res=new Rational();
		for(int i=0;i<this.m.length;++i)
		{
			for(int j=0;j<this.m[i].length;++j)
			{
				res.add(this.m[i][j]);
			}
		}
		return res;
	}
	
	public Rational getDeterminant()
	{
		Rational res=new Rational(1,1);
		for(int i=0;i<this.m.length;++i)
		{
			res.mul(this.m[i][i]);
		}
		
		return res;
	}
	
	public String toString()
	{
		String res=new String("");
		for(int i=0;i<this.m.length;++i)
		{
			for(int j=0;j<this.m[i].length;++j)
			{
				res+=this.m[i][j].toString()+" ";
			}
			res+="\n";
		}
		
		return res;
	}
	
	public static void main(String argc[])
	{
		RationalLowerTriangularMatrix g= new RationalLowerTriangularMatrix(3);
		Rational m00=new Rational(1,2);
		Rational m10=new Rational(1,4);
		Rational m11=new Rational(1,8);
		Rational m20=new Rational(1,16);
		Rational m21=new Rational(1,32);
		Rational m22=new Rational(1,64);
		
		g.setValue(0, 0, m00);
		g.setValue(1, 0, m10);
		g.setValue(1, 1, m11);
		g.setValue(2, 0, m20);
		g.setValue(2, 1, m21);
		g.setValue(2, 2, m22);
		
		Rational s=g.getDeterminant();
		System.out.println(s);
		
		
	}

}
