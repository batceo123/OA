package com.service;

import java.sql.ResultSet;


public class liuService
{
	public static String shifouchidao(String shijian1,String shijian2)
	{
		String s="";
		
		String s1=shijian1;
		String s2=shijian2;

		java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		java.util.Calendar c1=java.util.Calendar.getInstance();
		java.util.Calendar c2=java.util.Calendar.getInstance();

		try

		{
		    c1.setTime(df.parse(s1));
		    c2.setTime(df.parse(s2));
		}
		catch(java.text.ParseException e)
		{
		   System.err.println("��ʽ����ȷ");
		}

		int result=c1.compareTo(c2);

		if(result==0)
		{
			System.out.println("c1���c2");
			s="����";
		}

		if(result<0)
		{
			System.out.println("c1С��c2");
			s="����";
		}
		
		if(result>0)
		{
			System.out.println("c1>��c2");
			s="�ٵ�";
		}

		return s;
	}
	
	
	
	
	public static String shifouzaotui(String shijian1,String shijian2)
	{
		String s="";
		
		String s1=shijian1;
		String s2=shijian2;

		java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		java.util.Calendar c1=java.util.Calendar.getInstance();
		java.util.Calendar c2=java.util.Calendar.getInstance();

		try

		{
		    c1.setTime(df.parse(s1));
		    c2.setTime(df.parse(s2));
		}
		catch(java.text.ParseException e)
		{
		   System.err.println("��ʽ����ȷ");
		}

		int result=c1.compareTo(c2);

		if(result==0)
		{
			System.out.println("c1���c2");
			s="����";
		}

		if(result<0)
		{
			System.out.println("c1С��c2");
			s="����";
		}
		
		if(result>0)
		{
			System.out.println("c1>��c2");
			s="����";
		}

		return s;
	}
}
