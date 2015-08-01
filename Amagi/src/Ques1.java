
public class Ques1 {

	static int max(int a ,int b)
	{
		if(a>b)
			return a ;
		else
			return b;
	}
	
	/// recusive appraoch
	public static int highestprice(int[] current,int[] gains,int totalmoney,int i)
	{
		if( totalmoney<0 || i==current.length)
			return 0;
		
		if(totalmoney-current[i]<0)
			return highestprice(current, gains, totalmoney, i+1);
		
		return max(highestprice(current, gains, totalmoney, i+1),gains[i]+highestprice(current, gains, totalmoney-current[i], i+1));
	}
	
	public static int highestpriceDP(int[] current,int[] gains,int totalmoney)
	{
		/*if( totalmoney<0 || i==current.length)
			return 0;
		
		if(totalmoney-current[i]<0)
			return highestprice(current, gains, totalmoney, i+1);
		
		return max(highestprice(current, gains, totalmoney, i+1),gains[i]+highestprice(current, gains, totalmoney-current[i], i+1));*/
		
		int[][] memo = new int[current.length][totalmoney+1];
		
		for( int i =0;i<current.length;i++)
		{
			for( int w=0;w<=totalmoney;w++)
			{
				if (i==0 || w==0)
		               memo[i][w] = 0;
		           else if (current[i-1] <= w)
		        	   memo[i][w] = max(gains[i-1] + memo[i-1][w-current[i-1]],  memo[i-1][w]);
		           else
		        	   memo[i][w] = memo[i-1][w];
			}
		}
		
		return memo[current.length-1][totalmoney];
		
	}
	
	public static void main(String[] args)
	{
		int[] current = {200,300,250,100,300,50};
		int[] future = {250,400,400,120,330,50}; // 50+100+150+20 is max.since 200+300+250+100=850<1000
		int[] gains = new int[current.length];
		
		for(int i=0;i<gains.length;i++)
			gains[i]=future[i]-current[i];
	
		//int[] gains = {60, 100, 120};
		//int current[] = {10, 20, 30};
		System.out.println("Via Recusion ans. is : ");
		System.out.println(highestprice(current, gains, 50,0));
		
		System.out.println("Via DP ans. is : ");
		System.out.println(highestpriceDP(current, gains, 1000));
	}
	
}
