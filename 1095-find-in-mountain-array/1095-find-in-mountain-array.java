/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int peak = findPeakofArray(mountainArr, start , end);
        int index = binarySearch(mountainArr,start,peak,target,true);
        if(index != -1){
            return index;
        }
        else{
            return binarySearch(mountainArr, peak , end , target , false);
        }
    }


        private int findPeakofArray(MountainArray mountainArr,int start,int end){
            while(start<end){
                int mid = start + (end - start)/2;
                if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                    end = mid;
                }
                else{
                    start = mid + 1;
                }
            }
            return start;
        }

        private int binarySearch(MountainArray mountainArr, int start, int end , int target,boolean isAscending){
             while(start<=end){
                int mid = start + (end - start)/2;
                if(mountainArr.get(mid)==target){
                    return mid;
                }
                if (isAscending){
                 if(mountainArr.get(mid)<target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
             }
             else{
                if(mountainArr.get(mid) < target){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
             }
        }
        return -1;
    }
}
