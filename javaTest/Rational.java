public class Rational
{
	private int num;
	private int den;
	
	private void simplify()
	{   
        int a = this.num;
        int b =this.den;
		if(b!=0)
		{
			while(b!=0)
			{
				int tmp=a;
				a=b;
				b=tmp%b;
			}
		    	
        }
        this.num  = this.num/a;
        this.den  = this.den/a;
	}
	
	public Rational(int num,int denom)
	{
        this.num=num;
        this.den=denom;
        simplify();
	}
	
	public Rational()
	{
		this(0,1);
	}
	
	public void mul(Rational r)
	{
		this.num*=r.num;
		this.den*=r.den;
		simplify();
	}
	
	
	public void add(Rational r)
	{
		this.num=this.num*r.den+this.den*r.num;
		this.den=this.den*r.den;
		simplify();
	}
	
	public String toString()
	{
		String res;
		if(this.den==1)
		{
			res=new String(this.num+"");
		}
		else
		{
			res=new String(this.num+"/"+this.den);
		}
		return res;
	}
	
	public static void main(String argc[])
	{
		Rational r1=new Rational(5,1);
		Rational r2=new Rational(10,15);
		r1.mul(r2);
		System.out.println(r1);
		System.out.println(r2);
		
	}
	
	
}