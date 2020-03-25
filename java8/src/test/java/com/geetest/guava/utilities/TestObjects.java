package com.geetest.guava.utilities;

import com.google.common.base.Objects;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/25
 * @Time 18:51
 */
public class TestObjects {
    @Test
    public void testEqual(){
        boolean hello = Objects.equal(null, "hello");
        assertThat(hello, equalTo(false));
    }

    @Test
    public void testHashCode(){
        int hashCode = Objects.hashCode("hello", "world", null);
        System.out.println(hashCode);
    }
}
