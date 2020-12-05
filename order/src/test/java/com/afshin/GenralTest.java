package com.afshin;

import com.afshin.General.GregorianDate;
import org.junit.Test;

import java.util.Date;

/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */

public class GenralTest {

    @Test
    public void shamsitomiladiTest(){
        Date miladidate = GregorianDate.shamsi2miladi(1399,9-1,8);
        System.out.println(GregorianDate.miladiStr(miladidate));
        Date shamsidate = GregorianDate.miladi2shamsi(miladidate);
        System.out.println(GregorianDate.shamsiStr(shamsidate));
    }
}