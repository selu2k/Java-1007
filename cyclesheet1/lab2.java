import java.util.*;

class Transaction
{
	
	public static void main(String[] args)
	{
		int i;
		int charge = 0;
		for(i=0; i<args.length;i=i+3)
		{
			String name = args[i];
			int tot = Integer.parseInt(args[i+1]);
			int trans = Integer.parseInt(args[i+2]);
			int abstrans = Math.abs(trans);
			if(trans>=0)
			{
				tot = tot + trans;
				System.out.println(name);
				System.out.println(tot);
			}
			else
			{
				if(abstrans>tot || abstrans > 25000)
				{
					System.out.println(name);
				    System.out.println("Failed Transaction");
					System.out.println(tot);
				}
				else
				{
					if(abstrans <= 500)
					{
						charge = 5;
					}
					else if(abstrans <= 1000)
					{
						charge = 8;
					}
					else if(abstrans <= 5000)
					{
						charge = 10;
					
					}
					else if(abstrans <= 15000)
					{
						charge = 12;
					}
					else if(abstrans <= 25000)
					{
						charge = 15;
					}
					System.out.println(name);
					System.out.println(tot-charge-abstrans);
				}
			}
		}
	}
}