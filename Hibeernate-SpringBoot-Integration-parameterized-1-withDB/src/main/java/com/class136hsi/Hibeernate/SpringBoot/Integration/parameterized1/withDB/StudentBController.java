package com.class136hsi.Hibeernate.SpringBoot.Integration.parameterized1.withDB;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentBController {
           
	           @Autowired
	             SessionFactory sf;  
	           
	         @GetMapping("singalRecord/{id}")
	         public  StudentB showsingalRecord(@PathVariable int id)
	           {
	        	   Session ss=sf.openSession();
	        	   
	        	   StudentB sb=ss.load(StudentB.class, id);
	        	   
	        	   System.out.println(sb);
	        	   
	        	  return sb;
	           }
	           @GetMapping("allrecord")
	           public List<StudentB> allrecord()
	                   {
	                	   Session ss=sf.openSession();
	                	   
	                	   String select= "from StudentB";
	                	 Query q= ss.createQuery(select);
	                	  
	                	 List<StudentB> list=q.list();
	                	   
	                	   System.out.println("StudentB table");
	                	   
	                	   for(StudentB d:list)
	                	   {
	                		   System.out.println(d.getId()+" "+d.getName());
	                	   }
	                	   
	                	   return list;
	                	   
	                   }
	           @PostMapping("insertsb")
		       public  StudentB insert(@RequestBody StudentB studentB)
		       {
		    	   Session ss=sf.openSession();
		    	   
		    	  Transaction tx=ss.beginTransaction();
		    	   
		            ss.save(studentB);
		            
		            tx.commit();
		    	   
		    	           return studentB;
	        	 
	        	   
	           }
	       @PutMapping("updatesb")
	       public  StudentB update(@RequestBody int id)
	       {
	    	   Session ss=sf.openSession();
	    	   
	    	   StudentB sb=ss.load(StudentB.class, id);
	    	   
	    	   System.out.println(sb);
	    	   
	    	           return sb;
	       }
	           
	       @DeleteMapping("delete/{id}")
	         public  StudentB delete(@PathVariable int id)
	           {
	        	   Session ss=sf.openSession();
	        	   Transaction tx=ss.beginTransaction();
	        	   StudentB sb=ss.load(StudentB.class, id);
	        	   
	        	   System.out.println(sb);
	        	   ss.delete(sb);
	        	   tx.commit();
	        	  return sb;
	            }  
	             
}
