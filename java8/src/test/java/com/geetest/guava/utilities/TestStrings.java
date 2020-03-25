package com.geetest.guava.utilities;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.Test;

import java.nio.charset.Charset;

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
    public void testStrings() {
        //nullToEmpty  如果值是null返回空字符串  否则返回原字符串
        assertThat(Strings.nullToEmpty("hello"), equalTo("hello"));
        assertThat(Strings.nullToEmpty(null), equalTo(""));

        assertThat(Strings.emptyToNull("hello"), equalTo("hello"));
        assertThat(Strings.emptyToNull(null), equalTo(null));
        assertThat(Strings.emptyToNull(""), equalTo(null));

        assertThat(Strings.isNullOrEmpty(""), equalTo(true));
        assertThat(Strings.isNullOrEmpty(null), equalTo(true));

        assertThat(Strings.padStart("hello", 3, 'P'), equalTo("hello"));
        assertThat(Strings.padStart("hello", 10, 'P'), equalTo("PPPPPhello"));

        assertThat(Strings.padEnd("hello", 3, 'p'), equalTo("hello"));
        assertThat(Strings.padEnd("hello", 10, 'P'), equalTo("helloPPPPP"));

        assertThat(Strings.repeat("hello", 3), equalTo("hellohellohello"));
//        String repeat = Strings.repeat(null, 3);

        assertThat(Strings.commonPrefix("hello", "heappy"), equalTo("he"));
        assertThat(Strings.commonSuffix("hello", "hallo"), equalTo("llo"));


    }

    @Test
    public void testCharsets() {
        Charset charset = Charset.forName("UTF-8");
        assertThat(Charsets.UTF_8, equalTo(charset));
    }

    @Test
    public void testCharMatcher() {
        assertThat(CharMatcher.javaDigit().matches('5'), equalTo(true));
        assertThat(CharMatcher.javaDigit().matches('x'), equalTo(false));
        assertThat(CharMatcher.is('A').countIn("A boy can do everything for a girl"), equalTo(1));

    }
}
