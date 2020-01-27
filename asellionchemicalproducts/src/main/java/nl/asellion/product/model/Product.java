package nl.asellion.product.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "products")
@ApiModel(description="All details about the product. ")
public class Product {

	@ApiModelProperty(notes = "The database generated product ID")
	private int id;

	@ApiModelProperty(notes = "The product name")
	private String name;

	@ApiModelProperty(notes = "The product currentprice")
	private BigDecimal currentprice;

	@ApiModelProperty(notes = "The product lastupdate date with timestamp")
	private Date lastupdate;
	
	@ApiModelProperty(notes = "The product description")
	private String description ;
	
	

	public Product() {

	}

	public Product(String name, BigDecimal currentprice,String description) {
		this.name = name;
		this.currentprice = currentprice;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "currentPrice",nullable = false)
	public BigDecimal getCurrentprice() {
		return currentprice;
	}

	public void setCurrentprice(BigDecimal currentprice) {
		this.currentprice = currentprice;
	}
	
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "lastUpdate", updatable = false)
	@CreationTimestamp
	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

}
