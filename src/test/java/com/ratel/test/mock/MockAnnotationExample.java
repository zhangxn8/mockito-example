package com.ratel.test.mock;

import com.ratel.mockservices.Fruits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author zhangxn
 * @date 2022/1/6  23:24
 * @description Mock 注解被往往用来创建以及注入模拟实例。我们会用 mockito 框架创建一个模拟的实例类，
 * 而不是去真的创建需要的对象
 */
public class MockAnnotationExample {
    @Mock
    List<String> mockList;

    //@InjectMock creates an instance of the class and
    //injects the mocks that are marked with the annotations @Mock into it.
    @InjectMocks
    Fruits mockFruits;

    @BeforeEach
    public void setup() {
        //if we don't call below, we will get NullPointerException @Mock 注解可以理解为对 mock 方法的一个替代。
        //使用该注解时，要使用MockitoAnnotations.initMocks 方法，让注解生效。
        MockitoAnnotations.openMocks(this);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void test() {
        when(mockList.get(0)).thenReturn("Apple");
        when(mockList.size()).thenReturn(1);
        assertEquals("Apple", mockList.get(0));
        assertEquals(1, mockList.size());

        //mockFruits names is using mockList, below asserts confirm it
        assertEquals("Apple", mockFruits.getNames().get(0));
        assertEquals(1, mockFruits.getNames().size());

        mockList.add(1, "Mango");
        //below will print null because mockList.get(1) is not stubbed
        System.out.println(mockList.get(1));
    }

}
