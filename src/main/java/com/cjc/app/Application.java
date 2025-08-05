package com.cjc.app;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.cjc.app.model.Product;
import com.cjc.app.repository.ProductRepository;

@SpringBootApplication
public class Application {
             
           int x=10;        
        public void m1(){
         System.out.println("M1 --- Method");
}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ProductRepository repository = context.getBean("productRepository",ProductRepository.class);
		
		
		//getDataPagination(repository);
		
		//Sorting By Price
		
		Sort sort = Sort.by(Direction.DESC,"price");
		
		List<Product> list = repository.findAll(sort);
		Iterator<Product> itr = list.iterator();
		
		while(itr.hasNext()) {
			Product product = itr.next();
			System.out.println(product);
		}
	}

	private static void getDataPagination(ProductRepository repository) {
		//Pagination Concepts : 3 Products
		PageRequest pageRequest = PageRequest.of(0, 3);
		
		  Page<Product> page = repository.findAll(pageRequest);
		   
		  List<Product> list = page.getContent();
		  
		  for(Product pr:list) {
			  System.out.println(pr);
		  }
	}

	private static void getDataByName(ProductRepository repository) {
		Product pro = repository.findByPname("TV").get();
		System.out.println(pro);
	}

	private static void getDataById(ProductRepository repository) {
		Product product = repository.findById(3).get();
		
		System.out.println(product);
	}

	private static void insertData(ProductRepository repository) {
		Product pr=new Product("TV", "Black", 520000.0, "Electronics");
		Product pr1=new Product("DVD", "Silver", 14000.0, "Electronics");
		Product pr2=new Product("Bat", "Skinny", 200.0, "Games");
		Product pr3=new Product("Books", "White", 520.0, "Education");
		
		List<Product> list = Arrays.asList(pr,pr1,pr2,pr3);
		
		repository.saveAll(list);
	}

}
