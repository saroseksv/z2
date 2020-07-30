package sample;

public class Massiv {

    private double a,b;
    public double[] K=new double[10];

    public String[] Y=new String[10];

    public  void FillK(){
        for(int i=0;i<10;i++)
            K[i]=Math.random()*100;
    }

    public void FillY(){
        int sk=0;
        Y[0]="-";
        for(int i=1;i<10;i++)
        {
            sk+=(int)K[i-1];
            Y[i]=String.valueOf(Math.sqrt(Math.pow(Math.cos(K[i]),2)/(a*a+b*b-Math.sin(K[i])))*sk);
        }
    }
    public Massiv(double va, double vb){
        a=va;
        b=vb;
        FillK();
        for(int i=0;i<10;i++) Y[i]="";
    }

}
