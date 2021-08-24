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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "Swapimage")
	private String Swapimage;
	
	
	@Column(name = "music")
	private String music;
	
	@Column(name = "video")
	private String video;
	
	@Column(name = "published")
	private String published;
	
	@Column(name = "last_edited")
	private String lastEdited;
	
	@Column(name = "views")
	private int views;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="userTag_id", referencedColumnName = "id")
	private User userTag;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="group_id", referencedColumnName = "id")
	private Group group;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	private List<Comment> comments = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	private List<Reaction> reactions = new ArrayList<>();

	@ManyToMany( mappedBy = "savedPosts", cascade = CascadeType.PERSIST)
	private List<User> savedByUsers = new ArrayList<>();

	// @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "post_id", referencedColumnName = "id")
	// private List<User> savedByUsers = new ArrayList<>();
	
	public Post() {

	}
	
	public Post(String content, String image, String music, String video, String published, String lastEdited,
			int views, User user) {
		super();
		this.content = content;
		this.image = image;
		this.music = music;
		this.video = video;
		this.published = published;
		this.lastEdited = lastEdited;
		this.views = views;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSwapimage() {
		return Swapimage;
	}

	public void setSwapimage(String swapimage) {
		Swapimage = swapimage;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(String lastEdited) {
		this.lastEdited = lastEdited;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public User getUserTag() {
		return userTag;
	}

	public void setUserTag(User userTag) {
		this.userTag = userTag;
	}

	public List<User> getSavedByUsers() {
		return savedByUsers;
	}

	public void setSavedByUsers(List<User> savedByUsers) {
		this.savedByUsers = savedByUsers;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Transient
	public String getPostImagePath() {
		if (image == null ||(Long) id == null) return null;
		return "/user-post/" + id + "/" + image;
			
	}
	@Transient
	public String getSwapImagePath() {
		if (Swapimage == null ||(Long) id == null) return null;
		return "/user-post/" + id + "/" + Swapimage;
			
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}
	
	public void addReaction(Reaction reaction) {
        this.reactions.add(reaction);
    }

	public void removeReaction(Reaction reaction) {
        this.reactions.remove(reaction);
    }

	
	
}
