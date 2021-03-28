package po;

import java.util.Date;

public class Book {
	private String title;
	private String isbn;
	private String author;
	private Double price;
	private String press;
	private Integer edition;
	private Date published;//导入java.util.Date
	private Integer pages;
	private Integer words;
	private String packaging;
	private String format;
	private String form;
	
	public Book() {
		super();
	}

	public Book(String title, String isbn, String author, Double price, String press, Integer edition, Date published,
			Integer pages, Integer words, String packaging, String format, String form) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.press = press;
		this.edition = edition;
		this.published = published;
		this.pages = pages;
		this.words = words;
		this.packaging = packaging;
		this.format = format;
		this.form = form;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getWords() {
		return words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", author=" + author + ", price=" + price + ", press="
				+ press + ", edition=" + edition + ", published=" + published + ", pages=" + pages + ", words=" + words
				+ ", packaging=" + packaging + ", format=" + format + ", form=" + form + "]";
	}

}
