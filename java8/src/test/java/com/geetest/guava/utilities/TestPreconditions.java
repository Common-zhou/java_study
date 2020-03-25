package com.geetest.guava.utilities;

import com.google.common.base.Preconditions;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/25
 * @Time 14:58
 */
public class TestPreconditions {
    @Test
    public void testCheckArgument(){
        boolean flag = true;
        Preconditions.checkArgument(flag);

        Preconditions.checkArgument(!flag, "flag is false");
    }

    @Test
    public void testCheckElementIndex(){
        Preconditions.checkElementIndex(1,10);
    }

    @Test
    public void testCheckNotNull(){
//        Preconditions.checkNotNull(null);

        Preconditions.checkNotNull(new ArrayList<>());

        Preconditions.checkNotNull(null, "hello");
    }


}
