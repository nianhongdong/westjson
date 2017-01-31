package com.github.bingoohuang.westjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/30.
 */
public class HelloWordTest {
    @Test
    public void hello() {
        val person = new Person("bingoo", 123);
        val json = new WestJson().json(person);
        assertThat(json).isEqualTo("{age:123,name:bingoo}");
    }

    @Test
    public void helloParse() {
        val person = new Person("bingoo", 123);
        val parsed = new WestJson().parse("{age:123,name:bingoo}", Person.class);
        assertThat(parsed).isEqualTo(person);
    }

    @Test
    public void helloBlank() {
        val person = new Person("bin goo", 123);
        val json = new WestJson().json(person);
        assertThat(json).isEqualTo("{age:123,name:bin goo}");
    }

    @Test
    public void helloBlankParse() {
        val person = new Person("bin goo", 123);
        val parsed = new WestJson().parse("{age:123,name:bin goo}", Person.class);
        assertThat(parsed).isEqualTo(person);
    }

    @Test
    public void helloQuote() {
        val person = new Person("bin\"goo", 123);
        val json = new WestJson().json(person);
        assertThat(json).isEqualTo("{age:123,name:bin\\\"goo}");
    }

    @Test
    public void helloQuoteParse() {
        val person = new Person("bin\"goo", 123);
        val parsed = new WestJson().parse("{age:123,name:bin\\\"goo}", Person.class);
        assertThat(parsed).isEqualTo(person);
    }

    @Test
    public void helloComma() {
        val person = new Person("bin,goo", 123);
        val json = new WestJson().json(person);
        assertThat(json).isEqualTo("{age:123,name:bin\\,goo}");
    }

    @Test
    public void helloCommaParse() {
        val person = new Person("bin,goo", 123);
        val parsed = new WestJson().parse("{age:123,name:bin\\,goo}", Person.class);
        assertThat(parsed).isEqualTo(person);
    }

    @Test
    public void hello2Comma() {
        val person = new Person("bin,,goo", 123);
        val json = new WestJson().json(person);
        assertThat(json).isEqualTo("{age:123,name:\"bin,,goo\"}");
    }

    @Test
    public void hello2CommaParse() {
        val person = new Person("bin,,goo", 123);
        val parsed = new WestJson().parse("{age:123,name:\"bin,,goo\"}", Person.class);
        assertThat(parsed).isEqualTo(person);
    }


    @Data @AllArgsConstructor @NoArgsConstructor
    private static class Person {
        private String name;
        private int age;
    }
}