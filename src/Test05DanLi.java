class DanLi
{
	//private static DanLi danLi;//count1=0,count2=0
	//private static DanLi danLi=new DanLi();//count1=1,count2=0
	public static int count1;
	public static int count2=0;
	private static DanLi danLi=new DanLi();//count1=1,count2=1
	private DanLi()
	{
		count1++;
		count2++;
	}
	
	public static DanLi getInstance(){
		return danLi;
	}
}

public class Test05DanLi {
	public static void main(String[] args) {
		DanLi myDanLi=DanLi.getInstance();
		System.out.println("count1:"+DanLi.count1);
		System.out.println("count2:"+DanLi.count2);
	}
}