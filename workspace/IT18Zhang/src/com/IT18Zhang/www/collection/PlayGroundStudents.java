package com.IT18Zhang.www.collection;

import java.util.ArrayList;
import java.util.List;

import com.IT18Zhang.www.StringTest;

public class PlayGroundStudents {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		PlayGround pg=new PlayGround("HengShui School Playground");
		for(int grdNum=0;grdNum<PlayGround.TOTAL_GRADES;grdNum++)
		{
			Grade grd = new Grade("grade-"+(grdNum+1));
			for(int clsNum=0;clsNum<Grade.CLASS_PER_GRADE;clsNum++)
			{
				Class cls = new Class("class-"+(clsNum+1));
				for(int stuNum=0;stuNum<Class.STUDENDS_PER_CLASS;stuNum++)
					cls.addStudent( new Student("tom-"+(grdNum+1)+"-"+(clsNum+1)+"-"+(stuNum+1)));
				grd.addClass(cls);
			}
			pg.addGrade(grd);
		}
		
		System.out.println("playground call the roll:");
		pg.CallTheRoll();
		
	}

}


class PlayGround
{
	static final int TOTAL_GRADES = 6;
	
	List<Grade> schoolList = new ArrayList<Grade>(TOTAL_GRADES);
	private String name;
	
	public PlayGround(String name)
	{
		this.name = name;
	}
	
	public boolean addGrade(Grade g)
	{
		if(schoolList.size()<TOTAL_GRADES)
		{
			schoolList.add(g);		
			return true;
		}
		return false;
	}
	
	public void CallTheRoll()
	{
		System.out.println("*****"+name+"*****");
		for(Grade g:schoolList)
		{
			g.CallTheRoll();
		}
	}
	
}

class Grade
{
	static final int CLASS_PER_GRADE = 10;
	
	List<Class> gradeList = new ArrayList<Class>(CLASS_PER_GRADE);
	private String name;
	
	public Grade(String name)
	{
		this.name = name;
	}
	
	public boolean addClass(Class c)
	{
		if(gradeList.size()<CLASS_PER_GRADE)
		{
			gradeList.add(c);		
			return true;
		}
		return false;
	}
	
	public void CallTheRoll()
	{
		System.out.println("====="+name+"=====");
		for(Class c:gradeList)
		{
			c.CallTheRoll();
		}
	}
	
}

//class Student is defined in EqualDemo.java
class Class
{
	static final int STUDENDS_PER_CLASS = 60;
	
	private String name;
	private List<Student> classList = new ArrayList<Student>(STUDENDS_PER_CLASS);
	
	public Class(String name)
	{
		this.name = name;
	}
	
	public boolean addStudent(Student s)
	{
		if(classList.size()<STUDENDS_PER_CLASS)
		{
			classList.add(s);		
			return true;
		}
		return false;
	}
	
	public void CallTheRoll()
	{
		int i=0;
		
		System.out.println("-----"+name+"-----");
		for(Student s:classList)
		{
			System.out.print(s.getName()+" ");
			if(++i>=6)
			{
				i=0;
				System.out.println("");
			}
		}
		System.out.println("");
	}
	
}