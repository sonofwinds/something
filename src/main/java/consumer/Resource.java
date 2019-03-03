package consumer;

/**
 * 生产者消费者资源
 * 
 * @author 晨
 *
 */
public class Resource {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Resource [name=" + name + ", age=" + age + "]";
	}

}
