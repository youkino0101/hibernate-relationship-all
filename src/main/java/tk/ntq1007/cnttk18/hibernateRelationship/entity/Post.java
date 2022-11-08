package tk.ntq1007.cnttk18.hibernateRelationship.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "likes")
	private int likes;
	
	@Column(name = "published_on")
	private String published_on;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "post_category", 
	joinColumns = { @JoinColumn(name = "post_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "category_id") })
	private List<Category> categories;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "post_tag", 
	joinColumns = { @JoinColumn(name = "post_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "tag_id") })
	private List<Tag> tags;
}
