public class PolskiZloty extends Pieniadz{
    private static double[] nominaly = {0.1,0.2,0.5,1.0,2.0,5.0,10.0,20.00000,50.0,100.0,200.0,500.0};

    public PolskiZloty(){
        nazwa_skrotowa="zł";
    }
    public void wydajResztewZlotych(double reszta){
        while(reszta>0.0){
            int i = nominaly.length-1;
            boolean stop=false;
            while(stop==false){
                if(reszta>=nominaly[i]){
                    reszta=reszta-nominaly[i];
                    reszta=Math.round(reszta*100d)/100d;
                    System.out.println(nominaly[i] + nazwa_skrotowa);
                    stop=true;
                    break;

                } else if (reszta<nominaly[i]) {
                    i--;
                }
            }
        }
    }
}
