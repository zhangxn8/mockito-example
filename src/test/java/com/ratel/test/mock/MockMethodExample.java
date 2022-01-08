package com.ratel.test.mock;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author zhangxn
 * @date 2022/1/7  20:41
 */
public class MockMethodExample {
    @Test
    public void test() {
        //1. using Mockito.mock() method
        List<String> mockList = mock(List.class);
        when(mockList.size()).thenReturn(5);
        assertTrue(mockList.size()==5);
    }
}
