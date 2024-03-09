/* Name >> Omm Devgoswami
 * Registration Number >> 22410014223
 * Section >> 2241006
 * Branch >> B.Tech (CSE)
*/
import java.util.Scanner;
public class Affine_Chiper 
{
	
	public static String encrypt(String plaintext , char ar[][] , int K1 , int K2 )
		{String en = "";
		 for (int i =0; i < plaintext.length();i++)
		 	{char encry = plaintext.charAt(i);
		 	 for (int j = 0; j <= 26 ;j++)
		 		 {if (encry == (ar[0][j]))
		 			 {int n_1 = ((j*K1+K2)%26);
		 			  en += (ar[1][n_1]);
		 			 }
		 		  else if (encry == (ar[1][j]))
		 		 	 {int n_1 = ((j*K1+K2)%26);
		 		 	  en += (ar[0][n_1]);
		 		 	 }
		 		 }
		 	}
		 return en;
		}
	
	
	public static String decrypt(String chipertext , char ar[][] , int K1 , int K2)
		{String de = "";
		 System.out.println("The encrypted message is: "+chipertext);
		 for (int i =0; i < chipertext.length(); i++)
		 	{char decry = chipertext.charAt(i);
			 for (int j =0; j <= 26; j++)
			 	{if (decry == (ar[0][j]))
			 		{int n_2 = (((j+26-K2)*K1)%26);
			 		 de += (ar[1][n_2]);
			 		}
			 	 else if (decry == (ar[1][j]))
		 		 	{int n_2 = (((j+26-K2)*K1)%26);
		 		 	de += (ar[0][n_2]);
		 		 	}
			 	}
			 
		 	}
		return de;
		}
	
	static int modInverse (int x, int y)
		{for (int i = 1; i < y; i++)
			{if (((x%y)*(i%y))%y == 1)
				 {return i;}
			}
		 return 1;
		}
	
	public static void main(String[] args) 
		{Scanner obj = new Scanner(System.in);
		 System.out.print("Enter the text message :");
		 String plaintext = obj.nextLine();
		 System.out.print("Enter the value of Multiplicative Key : ");
		 int K1 = obj.nextInt();
		 System.out.print("Enter the value of Additive Key : ");
		 int K2 = obj.nextInt();
		 obj.close();
		 char ar[][] = new char[2][27];
		 char alpha_a = 'a';
		 for (int m = 0; m < 27; m++)
		 	{ar[0][m] = alpha_a;
			 alpha_a ++;
		 	}
		 char alpha_A = 'A';
		 for (int n = 0; n < 27; n++)
		 	{ar[1][n] = alpha_A;
			 alpha_A ++;
		 	}
		 
		 String chipertext = encrypt(plaintext,ar,K1,K2);
		 K1 = modInverse(K1,26);
		 String newPlaintext = decrypt(chipertext,ar,K1,K2);
		 System.out.println("The final decrypted message is: "+newPlaintext);
	}

}
