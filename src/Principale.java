import java.util.Scanner;

public class Principale {
    static boolean nostamp=true;
	public static void riempi(int[] v) {
		for (int i=0;i<v.length;i++) {
			v[i]=(int)Math.floor((Math.random()*99)+1);
		}
	}
	
	public static void stampa(int[] v) {
		if (nostamp) return;
		for (int i=0;i<v.length;i++) {
			System.out.print(v[i]+" ");
		}
		System.out.println();
	}
	
	public static int ordinaBubble(int v[]) {
		int contaloop=0;
		for (int j=0;j<v.length-1; j++) {
			for (int i=0;i<v.length-1;i++) {
				contaloop++;
				if ( v[i]>v[i+1] ) {
					int x=v[i];
					v[i]=v[i+1];
					v[i+1]=x;
				}
			}
		}
		return contaloop;
	}
	
	public static int ordinaBubbleSentinella(int v[]) {
		int contaloop=0;
		boolean sentinella;
		do {
			sentinella=false;
			for (int i=0;i<v.length-1;i++) {
				contaloop++;
				if ( v[i]>v[i+1] ) {
					int x=v[i];
					v[i]=v[i+1];
					v[i+1]=x;
					sentinella=true;
				}
			}
		} while(sentinella);
		return contaloop;
	}
	
	public static int ordinaBubbleSentinellaOpti(int v[]) {
		int contaloop=0;
		boolean sentinella;
		int n=v.length-1;
		do {
			sentinella=false;
			for (int i=0;i<n;i++) {
				contaloop++;
				if ( v[i]>v[i+1] ) {
					int x=v[i];
					v[i]=v[i+1];
					v[i+1]=x;
					sentinella=true;
				}
			}
			n--;
		} while(sentinella);
		return contaloop;
	}
	
	public static int ordinaIngenuo(int v[]) {
		int contaloop=0;
		for (int i=0;i<v.length-1; i++) {
			for (int j=i+1;j<v.length;j++) {
				contaloop++;
				if ( v[i]>v[j] ) {
					int x=v[i];
					v[i]=v[j];
					v[j]=x;
				}
			}
		}
		return contaloop;
	}
	
	public static void copia (int[] s, int[] d) {
		for(int i=0; i<s.length; i++) {
			d[i]=s[i];
		}
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		// Dichiarazione del vettore
		int n;
		do {
			System.out.println("quanto vuoi che il vettore sia grande?");
			n=sc.nextInt();
		} while (n<2 || n>10000000);
		
		int[] myvect = new int [n];
		int[] myvect2 =  new int [n];
		
		// Riempiemento del vettore
		riempi(myvect);
		stampa(myvect);
		
		
		// Ordinamento del vettore
		copia(myvect, myvect2);
		System.out.println(ordinaIngenuo(myvect2)+" ripetizioni Ingenuo");
		stampa(myvect2);
		
		// Ordinamento del vettore
		copia(myvect, myvect2);
		System.out.println(ordinaBubble(myvect2)+" ripetizioni Bubble");
		stampa(myvect2);
		
		// Ordinamento del vettore
		copia(myvect, myvect2);
		System.out.println(ordinaBubbleSentinella(myvect2)+" ripetizioni Bubble con sentinella");
		stampa(myvect2);
		
		// Ordinamento del vettore
		copia(myvect, myvect2);
		System.out.println(ordinaBubbleSentinellaOpti(myvect2)+" ripetizioni Bubble con sentinella ottimizzato");
		stampa(myvect2);

	}

}
