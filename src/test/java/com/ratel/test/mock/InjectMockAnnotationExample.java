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
 * @date 2022/1/7  20:42
 * @description @InjectMocks: 创建一个实例，
 *      其余用@Mock（或@Spy）注解创建的mock将被注入到用该实例中。
 */
public class InjectMockAnnotationExample {
    @Mock
    List<String> mockList;

    //@InjectMock creates an instance of the class and
    //injects the mocks that are marked with the annotations @Mock into it.
    @InjectMocks
    Fruits mockFruits;

    @BeforeEach
    public void setup() {
        //if we don't call below, we will get NullPointerException
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
