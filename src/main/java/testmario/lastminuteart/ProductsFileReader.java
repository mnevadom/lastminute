package testmario.lastminuteart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductsFileReader {
	
	private List<String> orders;
	
	public ProductsFileReader(String dir) {
		// TODO Auto-generated constructor stub
		
		try (Stream<Path> walk = Files.walk(Paths.get(dir))) {

			List<String> orders = walk.filter(Files::isRegularFile)
					.map(x -> x.toString()).collect(Collectors.toList());
			
			

			orders.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<String> getFiles(){
		return orders;
	}
	
	public List<String> getProducts(String file){
		return new String(Files.readAllBytes(Paths.get(file)));
	}

}
