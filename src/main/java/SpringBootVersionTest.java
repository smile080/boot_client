import org.springframework.boot.SpringBootVersion;

public class SpringBootVersionTest {
	public static void main(String[] args) {
		String version = SpringBootVersion.getVersion();
		System.out.println(version);
	}
}
