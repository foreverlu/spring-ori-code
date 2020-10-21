package org.springframework.learning;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.learning.domain.User;
import org.springframework.util.NumberUtils;
import org.springframework.validation.DataBinder;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoweiwei
 * @date 2020/9/29  4:46 下午
 */
public class Test {

	public static void main(String[] args) {

		//测试将数字 1，2，3，4，5，7，9，10，11 聚合成 1-5，7，9-11
		Integer[] nums = new Integer[]{1,2,3,4,6,7,8,11};
		List<Integer> numList = new ArrayList<>(Arrays.asList(nums));
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> tmpList = new ArrayList<>();
		int x =0;
		int y=0;
		int flag = numList.get(y);
		for(Integer num : numList){
			y++;
			if(!num.equals(flag)){
				x++;
				if(y<numList.size()-1){
					flag = numList.get(y);
				}

			}else {
				flag++;
			}
			if(x>result.size()-1){
				result.add(new ArrayList<>());
			}
			List<Integer> integers = result.get(x);
			if(null == integers){
				integers = new ArrayList<>();
			}
			integers.add(num);

		}

		System.out.println(result);




		Integer[] array = new Integer[]{1, 2, 3, 4, 6, 7, 8, 9, 11};
		int[][] arrays = new int[array.length][array.length];
		//二维数组的i和j
		int i = 0;
		int j = 0;
		//记录当前最大值为数组的第一个，减一是为了保证后面数组的第一个大于最大值，添加进入二维数组
		int max = array[0] - 1;
		for (int k = 0; k < array.length; k++) {
			//当不是连续数字的时候，放到下一个数组里面，并且把j设置为0，最大值为当前值-1
			if (array[k] != max + 1) {
				i++;
				j = 0;
				max = array[k] - 1;
			}
			arrays[i][j] = array[k];
			max = array[k];
			j++;

		}

//		for(int m=0;m<arrays.length;m++){
//			int[] array1 = arrays[m];
//			for(int n=0;n<array1.length;n++){
//				System.out.print(arrays[m][n]);
//			}
//			System.out.println();
//		}

		BeanWrapper beanWrapper = new BeanWrapperImpl();
		DataBinder dataBinder = new DataBinder(beanWrapper);
	}
}
