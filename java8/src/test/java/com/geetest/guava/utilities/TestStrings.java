package com.geetest.guava.utilities;

import com.google.common.base.Strings;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/25
 * @Time 19:51
 */
public class TestStrings {
    @Test
    public void testStrings(){
        //nullToEmpty  如果值是null返回空字符串  否则返回原字符串
        assertThat(Strings.nullToEmpty("hello"), equalTo("hello"));
        assertThat(Strings.nullToEmpty(null), equalTo(""));


    }
}
