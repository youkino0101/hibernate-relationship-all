package tk.ntq1007.cnttk18.hibernateRelationship.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "post_category", 
	joinColumns = { @JoinColumn(name = "category_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "post_id") })
	private List<Post> posts;
}
