package bit.com.a.dto;

public class BbsSerchDto {
	private String choice;
	private String search;
	private int pagenumber;
	
	public BbsSerchDto() {
	}

	public BbsSerchDto(String choice, String search, int pagenumber) {
		super();
		this.choice = choice;
		this.search = search;
		this.pagenumber = pagenumber;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}

	@Override
	public String toString() {
		return "BbsSerchDto [choice=" + choice + ", search=" + search + ", pagenumber=" + pagenumber + "]";
	}
	
}
