import java.util.*;

/**
 * Created by Hafiq Iqmal on 14/8/2016.
 * PROMED CS 2012
 */


public class MatrixReloaded{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        int cases = scan.nextInt();
        String [] ans = new String[cases];

        for(int x=0;x<cases;x++){
            String binary = scan.next();
            long len = binary.length();
            boolean range = (len > 100 && len < 65535);
            int count = 0;
            if(range){
                for(int y=0;y<len;y++){
                    if(binary.charAt(y) == '1'){
                        int z = y+1;
                        while(true){
                            if(binary.charAt(z) == '0'){
                                y = z;
                                count++;
                                break;
                            }
                            if(z>=len){
                                break;
                            }
                            z++;
                        }
                    }
                    else{
                        y++;
                    }
                }
                ans[x] = "Cases #"+(x+1)+": "+count;
            }
            else{
                ans[x] = "Cases #"+(x+1)+": -1";
            }
        }

        for (int x=0;x<cases;x++){
            System.out.println(ans[x]);
        }
    }
}