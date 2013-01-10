package plugins.util;

import java.io.Serializable;


public class Pair  implements Serializable{

	private static final long serialVersionUID = -5045921247761978327L;
	
	public static final String TAB = "\1";


	public Pair() {
	}
	
	public Pair(String val) {
		super();
		String s[] = val.split(TAB);
		this.first = s[0];
		this.second = Boolean.parseBoolean( s[1] );
	}
	
	public Pair(String first, Boolean second) {
		super();
		this.first = first;
		this.second = second;
	}

	
	private String first;
		
	private Boolean second;


	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public Boolean getSecond() {
		return second;
	}

	public void setSecond(Boolean second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return first + TAB + second;
	}
	
	
		
}
