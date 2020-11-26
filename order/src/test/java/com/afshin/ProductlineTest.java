package com.afshin;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductlineTest {
	private ProductlineDao productlineDao=new ProductlineDao();

	@Test
	public void findallTest() {
		List<Productline> productlines= productlineDao.findall();
        for (Productline productline:productlines){System.out.println(productline);}
        Assert.assertEquals("Productline count" ,productlines.size()==7,true);
	}
	@Test
	public void someColumnTest() {
		List<?> list= productlineDao.someColumn();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			System.out.println(row[0] + ", " + row[1]);
		}
	}
	@Test
	public void whereClauseTest() {
		List<?> list= productlineDao.whereClause("Ships");
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			System.out.println(row[0] + ", " + row[1]);
		}
	}
	@Test
	public void aggregationTest() {
		List<?> list= productlineDao.aggregation();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			System.out.println(row[0] + ", " + row[1]);
		}
	}
	@Test
	public void joinedQueryTest() {
		List<?> list= productlineDao.joinedQuery();
		for (int i = 0; i < list.size(); i++) {
			Object[] row = (Object[]) list.get(i);
			System.out.println(row[0] + ", " + row[1]+ ", " + row[2]+ ", " + row[3]);
		}
	}
}
