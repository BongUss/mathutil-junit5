/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bongu.mathutil.core;

import static com.bongu.mathutil.core.MathUtil.*;
//import static la danh rieng cho nhung ham static
//goi ham ma bo qua ten class
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Admin
 */
public class MathUtilTest {
    
    //chơi DDT, tách data ra khỏi câu lệnh kiểm thử, tham số hóa data này
    //vào trong câu lệnh kiểm thử
    public static Object[][] initData() {
        return new Integer[][] {
                {1, 1},
                {2, 2},
                {5, 120},
                {6, 120}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //tên của hàm cung cấp data, ngầm định thứ tự của các phần tử của mảng, thay bằng tham số hàm
    public void testGetFactorialGivenRightArgReturnsWell(int input, long expected) {
        assertEquals(expected, getFactorial(input));
    }
    
//    @Test
//    public void testGetFactorialGivenRightArgReturnsWell() {
//        assertEquals(120, getFactorial(5));
//    }
    
    //bắt ngoại lệ khi đưa data cà chớn!!!
    //@Test(expected = tên ngoại lệ.class) - JUnit 4 hoy, JUnit 5 không xài vậy
    @Test
    public void testGetFactorialGivenWrongArgThrowException() {
        //xài biểu thức Lambda
        //hàm nhận tham số thứ 2 là 1 cái object implement cái functional interface
        //tên là Executable - có 1 hàm duy nhất, không code
        //tên là execute()
        //chơi chậm
//        Executable excObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };

        //Executable exObject = () -> getFactorial(-5);
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
