package com.ratel.test.verify;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.calls;

/**
 * @author zhangxn
 * @date 2022/1/7  21:38
 */
public class VerifyExamples {
    @Test
    void test() {
        List<String> mockList = mock(List.class);
        mockList.add("Pankaj");
        mockList.size();

        verify(mockList).add("Pankaj");
        verify(mockList).add(anyString());
        verify(mockList).add(any(String.class));
        verify(mockList).add(ArgumentMatchers.any(String.class));

        verify(mockList, times(1)).size();
        verify(mockList, atLeastOnce()).size();
        verify(mockList, atMost(2)).size();
        verify(mockList, atLeast(1)).size();
        verify(mockList, never()).clear();

        // all interactions are verified, so below will pass
        verifyNoMoreInteractions(mockList);
        mockList.isEmpty();
        // isEmpty() is not verified, so below will fail
        // verifyNoMoreInteractions(mockList);
        Map mockMap = mock(Map.class);
        Set mockSet = mock(Set.class);
        verify(mockList).isEmpty();


        mockMap.isEmpty();
        verify(mockMap, only()).isEmpty();

        // testing order of mock method calls
        // can skip methods but order should be followed
        InOrder inOrder = inOrder(mockList, mockMap);
        inOrder.verify(mockList).add("Pankaj");
        inOrder.verify(mockList, calls(1)).size();
        inOrder.verify(mockList).isEmpty();
        inOrder.verify(mockMap).isEmpty();

    }
}
