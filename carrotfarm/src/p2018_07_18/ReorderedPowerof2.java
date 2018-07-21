package p2018_07_18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 2018. 7. 21..
 */
public class ReorderedPowerof2 {

	public static void main(String[] args) {


		int[] inputs = {1, 10, 16, 24, 46, 453686452};

		for (int i=0;i<inputs.length;i++) {
			boolean result = new ReorderedPowerof2().reorderedPowerOf2(inputs[i]);
			System.out.println(result);
		}
	}

	public boolean reorderedPowerOf2(int N) {
		boolean result = true;

		String n = N + "";

		int[] arr = new int[n.length()];
		for (int i = 0; i < n.length(); i++) {
			arr[i] = (Integer.parseInt(n.charAt(i) + ""));
		}

		result = perm(arr, 0, n.length(), n.length());
		return result;
	}

	private boolean isPowerOf2(int[] arr) {

		int N = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		N = Integer.parseInt(sb.toString());
//		System.out.println(N);
		boolean result = ((N & (N - 1)) == 0);
//		System.out.println(result);
		return result;
	}

	//	http://gorakgarak.tistory.com/522
	public boolean perm(int[] arr, int depth, int n, int k) {

		boolean result = false;

		if (depth == k) {
			if (arr[0]!=0) {
				if (isPowerOf2(arr)) {
					return true;
				}
			}
		}

		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			if (perm(arr, depth + 1, n, k)) {
				return true;
			}
			swap(arr, i, depth);
		}
		return result;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// 참고용
	public  void print(int[] arr, int k) {
		for (int i = 0; i < k; i++) {
			if (i == k - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
	}
}



