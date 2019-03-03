package zhishidian.equals;

import java.util.HashSet;
import java.util.Set;

import pojo.User;

public class HashCodeTest {

	public static void main(String[] args) {
		User u1 = new User();
		u1.setName("yang");
		u1.setAge(1);
		User u2 = new User();
		u2.setName("yang");
		u2.setAge(2);
		Set s1 = new HashSet<User>();
		s1.add(u1);
		s1.add(u2);
        System.out.println(s1.size());
	}

}
