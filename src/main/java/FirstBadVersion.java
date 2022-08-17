public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int i=1;
        int j=n;
        int mid = (i+j)/2;
        while(i<=j){

            mid = (i+j)/2;

            if(isBadVersion(mid))
                j = mid-1;

            else
                i= mid+1;

        }
        return  (i+j)/2;
    }


    public static boolean isBadVersion(int k ){
        if(k >=2)
            return true;
        return false;
    }
}
