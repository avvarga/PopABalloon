package com.avvarga.popaballoon.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "rewards")
public class Reward {
	
//	Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String name;
	
	@Lob
	@NotEmpty
	private String description;
	
	private String image;
	
	@Min(0)
	private Long price;
	
	@Min(0)
	private Long stock;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
//	Relations
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "users_rewards",
			joinColumns = @JoinColumn (name="reward_id"),
			inverseJoinColumns = @JoinColumn (name = "user_id"))
	private List <User> winners;
	
//	Constructor
	public Reward() {
		
	}
	
	public Reward(String name, String description, String image, Long price, Long stock) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.stock = stock;
	}
	
//	Auto created/updated at
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

//  Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getWinners() {
		return winners;
	}

	public void setWinners(List<User> winners) {
		this.winners = winners;
	}

}
