//Design an `Author` class with fields name and biography; add a method to update the biography text.

package Assignment1;
public class Author {
	private String name;
	private String biography;
	public Author(String name) {
		this.name = name;
		this.biography = "";
	}
	public Author(String name, String biography) {
		this.name = name;
		this.biography = biography;
	}
	public void updateBiography(String newBiography) {
		this.biography = newBiography;
	}
	public void displayAuthor() {
		System.out.println("Author Name: " + name);
		System.out.println("Biography: " + biography);
	}
	public static void main(String[] args) {
		Author author1 = new Author("J.K. Rowling");
		author1.updateBiography("J.K. Rowling is a British author, best known for the Harry Potter series.");
		author1.displayAuthor();
		Author author2 = new Author("George Orwell", "George Orwell was an English novelist, essayist, and critic.");
		author2.displayAuthor();
	}
}
