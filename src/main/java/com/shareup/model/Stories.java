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
@Table(name="stories")
public class Stories {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name = "image")
private String image;

@Column(name = "video")
private String video;

@Column(name = "date")
private String date;

@Column(name = "Lastdate")
private String Lastdate; 

@Column(name = "views")
private Integer views;



@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name="user_id", referencedColumnName = "id")
private User user;



public Stories() {

}
public Stories(long id, String image, String video, String date,String lastdate, Integer views, User user) {
	super();
	this.id = id;
	this.image = image;
	this.video = video;
	this.date = date;
	this.Lastdate=lastdate;
	this.views = views;
	this.user = user;
}



public String getLastdate() {
	return Lastdate;
}
public void setLastdate(String lastdate) {
	Lastdate = lastdate;
}
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getVideo() {
	return video;
}

public void setVideo(String video) {
	this.video = video;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public Integer getViews() {
	return views;
}

public void setViews(Integer views) {
	this.views = views;
}
@Transient
public String getStoriesImagePath() {
	if (image == null ||(Long) id == null) return null;
	return "/user-stories/" + id + "/" + image;
		
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


}

