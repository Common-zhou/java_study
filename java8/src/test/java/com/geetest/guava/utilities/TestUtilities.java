package com.geetest.guava.utilities;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/25
 * @Time 10:46
 */
public class TestUtilities {
    final List<String> stringList = Arrays.asList("zhou", "bing", "Java", "Guava");
    final List<String> stringListWithNullValue = Arrays.asList("zhou", "bing", "Java", "Guava", null);

    @Test
    public void testJoiner() {
        String string = Joiner.on("#").join(stringList);
        assertThat(string, equalTo("zhou#bing#Java#Guava"));
    }

    /**
     * 不进行处理 会抛出空指针异常  这样可以捕获
     */
    @Test(expected = NullPointerException.class)
    public void testJoinerWithNullValue() {
        String string = Joiner.on("#").join(stringListWithNullValue);
        assertThat(string, equalTo("zhou#bing#Java#Guava"));
    }

    @Test
    public void testJoinerWithNullValueTo() {
        String string = Joiner.on("#").skipNulls().join(stringListWithNullValue);
        assertThat(string, equalTo("zhou#bing#Java#Guava"));
    }

    @Test
    public void testJoinerWithNullValueToDefault(){
        String string = Joiner.on("#").useForNull("DEFAULT").join(stringListWithNullValue);
        assertThat(string, equalTo("zhou#bing#Java#Guava#DEFAULT"));
    }

    @Test
    public void testJoinerWithWriter(){
        StringBuilder stringBuilder = Joiner.on("#").appendTo(new StringBuilder(), stringList);
        assertThat(stringBuilder.toString(), equalTo("zhou#bing#Java#Guava"));
    }

    //TODO 利用java8 stream实现上述功能
}
