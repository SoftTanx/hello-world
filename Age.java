package day02;
import java.util.*;
public class Age
{

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入您的年龄：");
		int age =sc.nextInt();
		sc.close();
		System.out.println("您输入的年龄是："+age);
		if(age>=18){
			System.out.println("您已经成年啦！");
		}
		else{
			System.out.println("很遗憾，您未成年！");
		}

	}

}
