package com.bcorpse.springfeign;

import com.bcorpse.springfeign.client.BookClient;
import com.bcorpse.springfeign.controller.BookControllerFeignClientBuilder;
import com.bcorpse.springfeign.model.Book;
import com.bcorpse.springfeign.model.BookResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.hamcrest.CoreMatchers.*;
import org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringFeignApplicationTests {

	BookClient bookClient;

	@Before
	public void setup() {
		BookControllerFeignClientBuilder feignClientBuilder = new BookControllerFeignClientBuilder();
		bookClient = feignClientBuilder.getBookClient();
	}

	@Test
	public void givenBookClient_shouldRunSuccessfully() throws Exception {
		List<Book> books = bookClient.findAll().stream()
				.map(BookResource::getBook)
				.collect(Collectors.toList());

		assertTrue(books.size() > 2);
	}

	@Test
	public void givenBookClient_shouldFindOneBook() throws Exception {
		Book book = bookClient.findByIsbn("0151072558").getBook();
		assertThat(book.getAuthor(), containsString("Orwell"));
	}

	@Test
	public void givenBookClient_shouldPostBook() throws Exception {
		String isbn = UUID.randomUUID().toString();
		System.out.println(isbn);
		Book book = new Book(isbn, "Me", "It's me!", null, null);
		bookClient.create(book);
		book = bookClient.findByIsbn(isbn).getBook();

		assertThat(book.getAuthor(), is("Me"));
	}
}
