package com.shareup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "profile_picture")
	private String profilePicture;

	@Column(name = "cover_picture")
	private String coverPicture;

	@Column(name = "aboutme")
	private String aboutme;
	
	@Column(name = "job")
	private String job;
	
	@Column(name = "hometown")
	private String hometown;
	
	@Column(name = "currenttown")
	private String currenttown;  
	
	@Column(name = "relationshipstatus")
	private String relationshipstatus;
	
	@Column(name = "interests")
	private String interests;
	
	@Column(name = "gender")
	private String gender;
	
	@JsonIgnore
    @ManyToMany
    @JoinTable(name="user_friend",
                joinColumns = {@JoinColumn(name="user_id")},
                inverseJoinColumns = {@JoinColumn(name="friend_id")})
    private List<User> friends = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="user_friend",
            joinColumns = {@JoinColumn(name="friend_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")})
    private List<User> friendOf;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="friendrequest_sent",
                joinColumns = {@JoinColumn(name="requester_id")},
                inverseJoinColumns = {@JoinColumn(name="recipient_id")})
    private List<User> friendRequestSent = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="friendrequest_recieved",
            joinColumns = {@JoinColumn(name="recipient_id")},
            inverseJoinColumns = {@JoinColumn(name="requester_id")})
    private List<User> friendRequestRecieved;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_following",
                joinColumns = {@JoinColumn(name="user_id")},
                inverseJoinColumns = {@JoinColumn(name="following_id")})
    private List<User> following = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "following", cascade = CascadeType.ALL)
    private List<User> followers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_blocked",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="blocked_id")})
    private List<User> blockedUsers = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "blockedUsers", cascade = CascadeType.ALL)
    private List<User> blockedBy = new ArrayList<>();
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_groups",
    		joinColumns = { @JoinColumn (name = "user_id")},
    		inverseJoinColumns = { @JoinColumn (name = "group_id")})
    private List<Group> groups = new ArrayList<>();

	@JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_saved_post",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<Post> savedPosts = new ArrayList<>();

	
	
	public User() {
		
	}
		
	public User(String email, String password, String firstName, String lastName, String role) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
  
	
	
	public String getCurrenttown() {
		return currenttown;
	}

	public void setCurrenttown(String currenttown) {
		this.currenttown = currenttown;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationshipstatus() {
		return relationshipstatus;
	}

	public void setRelationshipstatus(String relationshipstatus) {
		this.relationshipstatus = relationshipstatus;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getFriendOf() {
		return friendOf;
	}
	

	public List<User> getFriendRequestSent() {
		return friendRequestSent;
	}

	public void setFriendRequestSent(List<User> friendRequestSent) {
		this.friendRequestSent = friendRequestSent;
	}

	public List<User> getFriendRequestRecieved() {
		return friendRequestRecieved;
	}

	public void setFriendRequestRecieved(List<User> friendRequestRecieved) {
		this.friendRequestRecieved = friendRequestRecieved;
	}

	public void setFriendOf(List<User> friendOf) {
		this.friendOf = friendOf;
	}

	public List<User> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> following) {
		this.following = following;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	
	

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(String coverPicture) {
		this.coverPicture = coverPicture;
	}

	public List<User> getBlockedUsers() {
		return blockedUsers;
	}

	public void setBlockedUsers(List<User> blockedUsers) {
		this.blockedUsers = blockedUsers;
	}

	public List<User> getBlockedBy() {
		return blockedBy;
	}

	public void setBlockedBy(List<User> blockedBy) {
		this.blockedBy = blockedBy;
	}
	
    public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<Post> getSavedPosts() {
		return savedPosts;
	}

	public void setSavedPosts(List<Post> savedPosts) {
		this.savedPosts = savedPosts;
	}

	public void addSavedPost(Post post) {
        this.savedPosts.add(post);
		post.getSavedByUsers().add(this);
    }
 
    public void removeSavedPost(Post post) {
		this.savedPosts.remove(post);
		post.getSavedByUsers().remove(this);
    }

	public void addFriend(User friend) {
        this.friends.add(friend);
        friend.getFriends().add(this);
    }
    
    public void removeFriend(User friend) {
        this.friends.remove(friend);
        friend.getFriends().remove(this);
    }
    
    public void sendFriendRequest(User friend) {
    	this.friendRequestSent.add(friend);
        friend.getFriendRequestRecieved().add(this);
    }
    
    public void removeFriendRequest(User friend) {
    	this.friendRequestSent.remove(friend);
        friend.getFriendRequestRecieved().remove(this);
    }
    
    public void acceptFriendRequest(User friend) {
    	addFriend(friend);
    	removeFriendRequest(friend);
    }
    
    public void denyFriendRequest(User friend) {
    	removeFriendRequest(friend);
    }

    public void addFollower(User follower) {
        this.followers.add(follower);
        follower.following.add(this);
    }
    
    public void removeFollower(User follower) {
        this.followers.remove(follower);
        follower.following.remove(this);
    }

    public void blockUser(User user) {
        this.blockedUsers.add(user);
        user.blockedBy.add(this);
    }

	public void unblockUser(User user) {
        this.blockedUsers.remove(user);
        user.blockedBy.remove(this);
    }

    public boolean hasFriend(User user) {
        return this.getFriends() != null && this.getFriends().contains(user);
    }
    
    public boolean hasRequest(User user) {
        return this.getFriendRequestRecieved() != null && this.getFriendRequestRecieved().contains(user);
    }

    public boolean hasFollower(User user) {
        return this.getFollowers() != null && this.getFollowers().contains(user);
    }

    public boolean hasBlocked(User user) {
        return this.getBlockedUsers() != null && this.getBlockedUsers().contains(user);
    }

	public boolean isNewUser() {
		 if((this.getFriends().size() <= 0 && this.getFriendRequestSent().size() <= 0) ) {
//				 && this.getFollowing().size() <= 0
			return true;
		}
		return false;
    }
    
    @Transient
	public String getProfilePicturePath() {
		if (profilePicture == null ||(Long) id == null) return null;
		
		if(profilePicture.equals("default.png")) return "/data/user/default/profile_picture/default.png";
		
		return "/data/user/" + email + "/profile_picture/" + profilePicture;			
	}

	@Transient
	public String getCoverPicturePath() {
		if (coverPicture == null ||(Long) id == null) return null;
		
		// if(profilePicture.equals("default.png")) return "/data/user/default/profile_picture/default.png";
		
		return "/data/user/" + email + "/cover_picture/" + coverPicture;			
	}

	@Transient
	public int getNumberOfFriends() {
		return this.getFriends().size();			
	}

	@Transient
	public int getNumberOfFollowers() {
		return this.getFollowers().size();			
	}

	@Transient
	public int getNumberOfFollowing() {
		return this.getFollowing().size();			
	}

}
