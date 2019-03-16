package multi_agent_project_2019;

import java.util.ArrayList;
import java.util.UUID;

public class Community {
	private String communityName;
	private String communityType;
	private String ownerName;
	private ArrayList<String> members;
	
	public Community(String ownerName,String communityName,String communityType) {
		String uniqueID = UUID.randomUUID().toString();
		this.ownerName = ownerName;
		this.communityName = communityName;
		this.communityType = communityType;
		members = new ArrayList<>();
	}
	public Community(String ownerName,String communityName,String communityType,ArrayList<String> memebers) {
		String uniqueID = UUID.randomUUID().toString();
		this.ownerName = ownerName;
		this.communityName = communityName;
		this.communityType = communityType;
		members = new ArrayList<>(memebers);
	}
	public void addMemember(String memeber) {
		this.members.add(memeber);
	}
	public ArrayList<String> getMembers() {
		return members;
	}
	public String getCommunityName() {
		return communityName;
	}
	public String getCommunityType() {
		return communityType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res = "";
		res = res+communityName+"-";
		res = res+communityType+"-";
		res = res +ownerName+"-";
		for(String s:members) {
			res += s+"-";
		}
		return res;
	}
	@Override
	public boolean equals(Object obj) {
		if(this.communityName.equals(((Community)obj).getCommunityName()))
				return true;
		return false;
	}
}
