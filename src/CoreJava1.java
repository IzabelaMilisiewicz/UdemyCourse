
public class CoreJava1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 5;
		String myString = "My first string";
		char letter = 'r';
		double dec1 = 6.99;
		boolean myCard = true;
		
		System.out.println(num + " test tekstu drukowanego");
		System.out.println(myString);
		
		//Arrays - multiple values in one variable
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		//above way helps when we will read some data from selenium and we don't know yet what data it will be
		
		int[] arr2 = {1,2,3,4,5,6,22,55,85,74};
		System.out.println(arr2[2]);
		
		//for loop
//		for(int i = 0; i < arr.length; i++)
//		{
//			System.out.println(arr[i]);
//		}
		for (int i=0; i<arr2.length; i++)
		{
			System.out.println(arr2[i]);
		}
	
	String[] name = {"test", "Iza", "Rys"};
	for (int i=0; i<name.length; i++)
	{
		System.out.println(name[i]);
	}
	for (String s: name) //z name przy kazdej iteracji bież imie, zawsze trzeba dac typ zmiennej s
	{
		System.out.println(s);
	}

}
}