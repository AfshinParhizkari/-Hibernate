package com.afshin.Dao;

import com.afshin.Entity.Productline;
import com.afshin.Dao.ProductlineDao;
import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */
public class ProductlineTest {
	private ProductlineDao productlineDao=new ProductlineDao();

	@Test
	public void findallTest() {
		List<Productline> productlines= productlineDao.findall();
        for (Productline productline:productlines){System.out.println(productline);}
        Assert.assertEquals("Productline count" ,productlines.size()==7,true);
	}
	@Test
	public void findbyidTest(){
		Productline pl =new Productline();
		System.out.println(productlineDao.findbyid("Planes"));
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

	@Test
	public void insertTest(){
		Productline pl=new Productline();
		pl.setProductLine("dbmodel");
		pl.setTextDescription("order database model in graphic's way");
		pl.setHtmlDescription("https://github.com/AfshinParhizkari");
		try{
		//System.out.println(Paths.get("").toAbsolutePath().toString());
			System.out.println(Paths.get("","/main/webapp/statics/images/","OrderDB_Model.jpg"));
		pl.setImage(Files.readAllBytes(Paths.get(System.getProperty("user.dir"),"/src/main/webapp/statics/images/","OrderDB_Model.jpg")));
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		productlineDao.insert(pl);
		System.out.println(productlineDao.findbyid("dbmodel"));
	}
	@Test
	public void updateTest(){
		/* wrong way to update!
		Productline pl=new Productline();
		pl.setProductLine("dbmodel");*/
		Productline pl=productlineDao.findbyid("dbmodel");
		pl.setTextDescription("just update order database model");
		pl.setHtmlDescription("https://www.linkedin.com/in/afshin-parhizkari/");
		try{pl.setImage(Files.readAllBytes(Paths.get(System.getProperty("user.dir"),"/src/main/webapp/statics/images/","b52changed.jpg")));}
		catch (Exception e) {
			System.out.println(e.toString());
		}		productlineDao.update(pl);
		System.out.println(productlineDao.findbyid("dbmodel"));
	}
	@Test
	public void deleteTest(){
		Productline pl=productlineDao.findbyid("dbmodel");
		productlineDao.delete(pl);
	}
}
