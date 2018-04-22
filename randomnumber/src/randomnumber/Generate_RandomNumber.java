/*Generate 500 random numbers and print the nth smallest number in a programming language of your choice.*/

package randomnumber;

import java.util.Arrays;
import java.util.Random;


/**
 * Method Generate 500 random numbers and print the nth smallest number 
 */
public class Generate_RandomNumber {

		public static void main(String[] args) {

			Generate_RandomNumber generate_randomnumber = new Generate_RandomNumber();	
			System.out.println(generate_randomnumber.createnumbers(15,5000,3,500));
		}

		private int createnumbers(int min, int max, int n, int size) {
			int nth_number=0;
			Random random = new Random();
			int[] randomnumberlist = new int[size];

			for(int i=0;i<500;i++)
			{
				randomnumberlist[i]=random.nextInt((max - min)+1)+min;
			}
			
			Arrays.sort(randomnumberlist);
			
			/*for(int num:randomnumberlist)
			System.out.print(num+" ");*/
	       
			nth_number = randomnumberlist[n-1];

			return nth_number;
		}
		


	}

