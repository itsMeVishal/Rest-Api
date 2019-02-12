package com.vish.security.security.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Setter
/*@Data*/
@JsonSerialize
public class Product implements Serializable,Comparable<Product>{
	
	
	@Id
	@GeneratedValue
	@Getter
	private Integer id;
	@Getter
	private String name;
	@Getter
	private String color;
	@Getter
	@Setter
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	@Override
	public int compareTo(Product o) {
		
		return this.getName().compareTo(o.getName());
	}
	
}
