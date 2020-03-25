package com.geetest.guava.utilities;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Description:
 * @Author: zhou
 * @Date: 2020/3/25
 * @Time 12:36
 */
public class TestSplitter {
    @Test
    public void testSplitterOnSplitToList() {
        List<String> stringList = Splitter.on("|").splitToList("zhou|bing|java|guava");
        assertThat(stringList.size(), equalTo(4));
    }

    @Test
    public void testSplitterFixedLength() {
        List<String> stringList = Splitter.fixedLength(3).splitToList("aaabbbcccddd");
        assertThat(stringList.size(), equalTo(4));
        assertThat(stringList.get(0), equalTo("aaa"));
        assertThat(stringList.get(3), equalTo("ddd"));
    }

    @Test
    public void testSplitterLimit() {
        List<String> stringList = Splitter.on("|").limit(3).splitToList("aaa|bbb|ccc|ddd|eee");
        assertThat(stringList.size(), equalTo(3));

        List<String> stringList1 = Splitter.on("|").limit(3).splitToList("aaa|bbb");
        assertThat(stringList1.size(), equalTo(2));
    }

    @Test
    public void testSplitterOmitEmptyStrings() {
        List<String> stringList = Splitter.on("|").omitEmptyStrings().splitToList("aaa|bbb||||ccc");
        System.out.println(stringList);
        assertThat(stringList.size(), equalTo(3));
    }

    @Test
    public void testSplitterTrim() {
        List<String> stringList = Splitter.on("|").omitEmptyStrings().trimResults().splitToList("  aaa|  bbb||||ccc  ");
        System.out.println(stringList);
        assertThat(stringList.size(), equalTo(3));
        assertThat(stringList.get(0), equalTo("aaa"));
        assertThat(stringList.get(2), equalTo("ccc"));

        List<String> stringList1 = Splitter.on("|").omitEmptyStrings().splitToList("  aaa|  bbb||||ccc  ");
        System.out.println(stringList1);

    }

    @Test
    public void testSplitterWithKeySeparator(){
        Map<String, String> stringMap = Splitter.on("|").withKeyValueSeparator("=").split("aaaa=AAA|bbb=BBB|ccc=CCC");
        assertThat(stringMap.get("aaaa"), equalTo("AAA"));
        assertThat(stringMap.get("bbb"), equalTo("BBB"));
        assertThat(stringMap.get("ccc"), equalTo("CCC"));
    }
}
