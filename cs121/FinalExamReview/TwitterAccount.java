import java.util.ArrayList;

public class TwitterAccount {
	
	/* Instance Variables Step 1 */
	private String id;
	private String email;
	private ArrayList<String> hashtags;
	
	/* Constructor Step 2 */
	public TwitterAccount(String id, String email) {
		this.id = id;
		this.email = email;
		hashtags = new ArrayList<String>();
		
	}
	
	/* Methods */
	
	/* Accessor / Getter methods Step 3 */
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	/* Mutator / Setter methods Step 3 */
	public void setId(String x) {
		id = x;
	}
	
	public void setEmail(String x) {
		email = x;
	}
	
	/* Step 4 */
	public void addHashtag(String tag)  {
		hashtags.add(tag);
	}
	
	/* Step 5 */
	public boolean checkHashtag(String tag) {
		
		boolean result = false;
		for (String s: hashtags) {
			if (s.equals(tag)) {
				result = true;
			}
		}
		return result;
		
		return hashtags.contains(tag);
	}
	
	/* Step 6 */
	public static void main(String[] args) {
		
		/* Step 6 part 1 */
		TwitterAccount bob = new TwitterAccount("1234", "bob@hotmail.com");
		
		/* Step 6 part 2 */
		bob.addHashtag("#winning");
		bob.addHashtag("#myface");
		
		/* Step 6 part 3 */
		/* Check for existing hashtag */
		if (bob.checkHashtag("#winning")) {
			System.out.println("Passed: contains #winning test" );
		} else {
			System.out.println("Failed: contains #winning test" );
		}
		
		/* Check for non-existing hashtag */
		if (! bob.checkHashtag("#loosing")) {
			System.out.println("Passed: does not contain #loosing test" );
		} else {
			System.out.println("Failed: does not contain #loosing test" );
		}
		
	}
	

}
