/*

                               *                               
                              * *                              
                             *   *                             
                            * * * *                            
                           *       *                           
                          * *     * *                          
                         *   *   *   *                         
                        * * * * * * * *                        
                       *               *                       
                      * *             * *                      
                     *   *           *   *                     
                    * * * *         * * * *                    
                   *       *       *       *                   
                  * *     * *     * *     * *                  
                 *   *   *   *   *   *   *   *                 
                * * * * * * * * * * * * * * * *                
               *                               *               
              * *                             * *              
             *   *                           *   *             
            * * * *                         * * * *            
           *       *                       *       *           
          * *     * *                     * *     * *          
         *   *   *   *                   *   *   *   *         
        * * * * * * * *                 * * * * * * * *        
       *               *               *               *       
      * *             * *             * *             * *      
     *   *           *   *           *   *           *   *     
    * * * *         * * * *         * * * *         * * * *    
   *       *       *       *       *       *       *       *   
  * *     * *     * *     * *     * *     * *     * *     * *  
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   * 
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

*/
public static Vector < String > sierpinski(int n) {
    Vector < String > down = new Vector < String > (Arrays.asList("*"));
    String space = " ";
    for (int i = 0; i < n; i++) {
        Vector < String > newDown = new Vector < String > ();
        for (String x: down)
            newDown.add(space + x + space);
        for (String x: down)
            newDown.add(x + " " + x);

        down = newDown;
        space += space;
    }
    return down;
}

public static void main(String[] args) {
    for (String x: sierpinski(5))
        System.out.println(x);
}