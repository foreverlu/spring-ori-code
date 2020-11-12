package org.springframework.learning;

import org.springframework.core.GenericTypeResolver;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caoweiwei
 * @date 2020/10/26  6:26 下午
 */
public class Test1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("0");
		list.add("1");
		System.out.println(list);

		if(list.contains("0")) {
			list.remove("0");
		}
		System.out.println(list);

	}
}
