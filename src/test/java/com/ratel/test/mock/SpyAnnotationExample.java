package com.ratel.test.mock;

import com.ratel.mockservices.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author zhangxn
 * @date 2022/1/7  21:10
 * @description spy 的参数是对象示例，mock 的参数是 class。
 * 被 spy 的对象，调用其方法时默认会走真实方法。mock 对象不会。
 */
public class SpyAnnotationExample {

    @Spy
    Utils mockUtils;

    @Spy
    List<String> spyList = new ArrayList<>();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test() {
        when(mockUtils.process(1, 1)).thenReturn(5);
        //mocked method
        assertEquals(5, mockUtils.process(1, 1));
        //real method called since it's not stubbed
        assertEquals(20, mockUtils.process(19, 1));

        when(spyList.size()).thenReturn(5);
        assertEquals(5, spyList.size());

        spyList.add("Pankaj");
        spyList.add("Lisa");
        assertEquals("Pankaj", spyList.get(0));
        assertEquals("Lisa", spyList.get(1));
    }
}
