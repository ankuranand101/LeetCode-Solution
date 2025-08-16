// Change the class name to Solution 

public class 1323_maximum69Number {
    public int maximum69Number (int num) {
        int n = num;
        int c = 0;
        while(n!=0){
            c++;
            n = n/10; 
        }
        int[] arr = new int[c];
        for(int i = c-1; i>= 0; i--){
            arr[i] = num % 10;
            num = num / 10;
        }
        for(int i = 0; i<c; i++){
            if(arr[i] == 6){
                arr[i] = 9;
                break;
            }
        }
        int s = 0;
        for(int  i = 0; i< c; i++){
            s = s*10 + arr[i];
        }
        return s;
    }
}
