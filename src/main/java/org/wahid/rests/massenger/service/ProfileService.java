package org.wahid.rests.massenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.wahid.rests.massenger.database.DatabaseClass;
import org.wahid.rests.massenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("wahid",new Profile(1l,"wahid","khan","Pune"));
	}
	
	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>( profiles.values());
	}
	public Profile getProfile(String name){
		return profiles.get(name);
	}
	public Profile addProfile(Profile profileName){
		profileName.setId(profiles.size()+1);
		profiles.put(profileName.getProfileName(),profileName);
		return profileName;
	}
	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0){
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	public Profile removeProfile(String profileName ) {
		return profiles.remove(profileName);
		
	}
}
