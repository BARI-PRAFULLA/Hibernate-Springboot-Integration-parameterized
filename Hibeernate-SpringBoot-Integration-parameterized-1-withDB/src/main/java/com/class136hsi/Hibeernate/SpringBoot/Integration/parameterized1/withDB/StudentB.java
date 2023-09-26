package com.class136hsi.Hibeernate.SpringBoot.Integration.parameterized1.withDB;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentB {
             
	           @Id
	           int id;
	           String name;
	           
			public StudentB() {
				super();
				// TODO Auto-generated constructor stub
			}

			public StudentB(int id, String name) {
				super();
				this.id = id;
				this.name = name;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			@Override
			public String toString() {
				return "StudentB [id=" + id + ", name=" + name + "]";
			}
	           
}
