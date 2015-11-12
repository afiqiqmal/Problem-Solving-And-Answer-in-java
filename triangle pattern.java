public static void main(String []args){
        int num = 6;
        
        for(int x=0;x<num;x++){
            for(int y=0;y<(num-x-1);y++){
                System.out.print(" ");
            }
            for(int z=0;z<=x;z++){
                System.out.print("*");
                for(int a=0;a<z;a = a+z){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
     }