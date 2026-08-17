class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1]){
                // here , we are in descending part of array,
                //so this may be ans , but also look at left side.
                end = mid;
            }
            else{
                // here, we are in ascending part of array,
                start = mid + 1;
                // since we know mid element < mid + 1 element
            }
        }
        // in the end, start == end
        //and pointing to the largest number because of the 2 checks above
        return start;
    }
}