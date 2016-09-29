package test;

public class Random {
	public static void main(String[] args) {
		        float matrix[][]={{1,4},{2,5},{5,1},{4,2}};
		        float result[]={19,26,19,20};
		        float theta[]={2,5};
		        float loss = (float) 10.0;
		        for(int i =0 ;i<100&&loss>0.001;++i)
		        {
		                float error_sum=(float) 0.0;
		                int j=i%4;
		                {
		                        float h = (float) 0.0;
		                        for(int k=0;k<2;++k)
		                        {
		                                h += matrix[j][k]*theta[k];

		                        }
		                        error_sum = result[j]-h;
		                        for(int k=0;k<2;++k)
		                        {
		                                theta[k] = (float) (theta[k]+0.01*(error_sum)*matrix[j][k]);
		                        }
		                }
		                System.out.println(theta[0]+","+theta[1]);
		                float loss1 = (float) 0.0;
		                for(int j1=0;j1<4;j1++)
		                {
		                        float sum=(float) 0.0;
		                        for(int k = 0;k<2;++k)
		                        {
		                                sum += matrix[j1][k]*theta[k];
		                        }
		                        loss1 += (sum-result[j1])*(sum-result[j1]);
		                }
		                System.out.println(loss1);
		        }
		}
}
