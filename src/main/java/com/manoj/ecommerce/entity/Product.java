package com.manoj.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
//@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

	public Long getId() {
		return id;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public String getSku() {
		return sku;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public boolean isActive() {
		return active;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
