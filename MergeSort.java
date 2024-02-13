public class MergeSort {
  public static void printarr(int arr[]) {
      for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
      }
  }

  public static void mergesort(int arr[], int si, int ei) {
      if (si >= ei) {
          return;
      }
      int mid = si + (ei - si) / 2;
      mergesort(arr, si, mid);
      mergesort(arr, mid + 1, ei);
      merge(arr, si, ei, mid);
  }

  // Merge method to sort the remaining parts
  public static void merge(int arr[], int si, int ei, int mid) {
      int temp[] = new int[ei - si + 1];
      int i = si;
      int j = mid + 1;
      int k = 0;
      while (i <= mid && j <= ei) {
          if (arr[i] > arr[j]) {
              temp[k] = arr[i];
              i++;
          } else {
              temp[k] = arr[j];
              j++;
          }
          k++;
      }
      // For leftover elements in left sorted part
      while (i <= mid) {
          temp[k++] = arr[i++];
      }
      // For leftover elements in right sorted part
      while (j <= ei) {
          temp[k++] = arr[j++];
      }
      // Copying elements from temp back to arr
      for (i = 0; i < temp.length; i++) {
          arr[si + i] = temp[i];
      }
  }

  public static void main(String[] args) {
      int arr[] = {6, 3, 9, 5, 2, 8};
      mergesort(arr, 0, arr.length - 1);
      printarr(arr);
  }
}
