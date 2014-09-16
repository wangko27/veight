/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.test;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.veight.utils.ImageUtils;
/**
 *
 * @author Administrator
 */
public class ImageCutTest {
    
    public ImageCutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void cut() throws Exception{
        File srcfile=new File("d://aa.png");
        File destfile=new File("d://c9c.png");
        ImageUtils.cutImage(srcfile, destfile, 0, 0, 1366, 768);
        System.out.println("我是测试文件");
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
