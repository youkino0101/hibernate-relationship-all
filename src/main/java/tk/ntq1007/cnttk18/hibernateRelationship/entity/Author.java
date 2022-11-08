package tk.ntq1007.cnttk18.hibernateRelationship.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "author")
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "fullname")
	private String fullname;
	
	@OneToOne
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Post> posts;
}
