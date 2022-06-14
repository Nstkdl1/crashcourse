package demo.streamapi;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import demo.streamapi.models.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import demo.streamapi.models.Product;
import demo.streamapi.repos.CustomerRepo;
import demo.streamapi.repos.OrderRepo;
import demo.streamapi.repos.ProductRepo;

@Slf4j
@DataJpaTest
public class StreamApiTest {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise1() {
		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll()
		.stream()
		.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
		.filter(p -> p.getPrice() > 100)
		.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
    @DisplayName("Obtain a list of order with products belong to category \"Baby\"")
	public void exercise2() {
		long startTime = System.currentTimeMillis();
		List<Order> orders = orderRepo.findAll()
				.stream()
				.filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		orders.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category \"Toys\" and then apply 10% discount")
	public void exercise3() {
		long startTime = System.currentTimeMillis();
		List<Product> products = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
				.map(p -> p.withPrice(p.getPrice() * 0.9))
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		products.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between feb1 and apr1")
	public void exercise4() {
		long startTime = System.currentTimeMillis();
		List<Product> products = orderRepo.findAll()
				.stream()
				.filter(o -> o.getCustomer().getTier() == 2)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				.flatMap(o -> o.getProducts().stream())
				.distinct()
				.collect(Collectors.toList());
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		products.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain sum, average, max, min, count for all products of category \"Books\"")
	public void exercise5() {
		long startTime = System.currentTimeMillis();
		DoubleSummaryStatistics stats = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.mapToDouble(p -> p.getPrice())
				.summaryStatistics();
		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		System.out.println(String.format("сумма = %1$f, среднее = %2$f, максимум = %3$f, минимум = %4$f, количество = %5$d",
		stats.getSum(), stats.getAverage(), stats.getMax(), stats.getMin(), stats.getCount()));
	}

}
