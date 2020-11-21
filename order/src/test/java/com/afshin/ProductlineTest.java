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
		List<Productline> productlines = productlineDao.someColumn();
		for (Productline productline:productlines){System.out.println(productline);}
/*		for (int i = 0; i < productlines.size(); i++) {
			Object[] row = (Object[]) productlines.get(i);
			System.out.println(row[0] + ", " + row[1]);
		}*/
	}
}
