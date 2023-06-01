package com.pratice.UserService.Entities;

import javax.persistence.*;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_users")
public class User

{
	@Id
	@Column(name="id")
	private String  userId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="about")
	private String about;

	@Transient  //it dose not store in to databse
	private List<Rating> ratings=new ArrayList<>();
	//private List<Rating> ratings;

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", about=" + about + "]";
	}
}
