package zhishidian.equals;

public class Equals {

	public static void main(String[] args) {
		    int int1 = 12;  
	        int int2 = 12;
	        Integer Integer1 = new Integer(12);  
	        Integer Integer2 = new Integer(12);  
	        Integer Integer3 = new Integer(127);  
	        Integer a1 = 127;  
	        Integer b1 = 127;  
	        Integer a = 128;  
	        Integer b = 128;  
	        String s1 = "str";  
	        String s2 = "str";  
	        String str1 = new String("str");  
	        String str2 = new String("str");  
	  
	        System.out.println("int1==Integer1:" + (int1 == Integer1));
	        //true
	        System.out.println("Integer1==Integer2:" + (Integer1 == Integer2));  
	        //false
	        System.out.println("Integer3==b1:" + (Integer3 == b1));
	        //false
	        System.out.println("a1==b1:" + (a1 == b1));
	        //true
	        System.out.println("a==b:" + (a == b));  
	        //false
	        System.out.println("s1==s2:" + (s1 == s2));
	        //true
	        System.out.println("s1==str1:" + (s1 == str1));
	        //false
	        System.out.println("str1==str2:" + (str1 == str2));
	        //false
	        //基本数据类型和装箱类型比较，装箱类型（integer）会自动拆箱为基本数据类型（int）
	       //首先，Integer/String a = 1/"a",这种写法时，数据会存放在常量池中，
	       //Integer型例外，对于-128到127之间的数，确实会存放在常量池中，但是其他区间的数字则会在堆中分配内存地址
	       //而new String()/new Integer() 这种新建对象的方式则会在堆中新分配一个内存空间
	}

}
