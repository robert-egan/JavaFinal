public class BinaryInteger{
	
	private String value;
	
	BinaryInteger(String s){
		char[] list = s.toCharArray();
		for (int i=0;i<list.length;i++) {
			if (list[i] != '0' & list[i] != '1') {
				throw new RuntimeException();
			}
		}
		value = s;
	}
	
	public String toString() {
		return value;
	}
	
	public int length() {
		return this.value.length();
	}
	
	public BinaryInteger not() {
		String b = null ;
		
		for (int i=0;i<value.length();i++) {
			char a = value.charAt(i);
			if (a=='1') {
				b += '0';
			}
			else {
				b += '1';
			}
		}
		b=b.substring(4);
		BinaryInteger temp = new BinaryInteger(b);
		return temp;
	}
	
	public BinaryInteger xor(BinaryInteger b) {
		char[] listA = value.toCharArray();
		char[] listB = b.value.toCharArray();
		String c =null;
		if (listA.length != listB.length) {
			throw new RuntimeException();
		}
		for(int i=0;i<listA.length;i++) {
			if(listA[i]==listB[i]) {
				c+='0';
			}
			else if(listA[i]=='1' | listB[i]=='1'){
				c+='1';
			}
		}
		c=c.substring(4);
		BinaryInteger temp = new BinaryInteger(c);
		return temp;
		
	}
	
	public int leadingZeros() {
		char[] list = this.value.toCharArray();
		int count = 0;
		for(int i=0;i<list.length;i++) {
			if(list[i]=='1') {
				break;
			}
			count++;
		}
		return count;
	}
	
	public boolean isGreaterThan(BinaryInteger b) {
		int valueA = 0;
		int valueB = 0;
		char[] listA = this.value.toCharArray();
		char[] listB = b.value.toCharArray();
		int converter = 1;
		for (int i=0;i<listA.length;i++) {
			if(listA[i]=='1') {
				valueA += converter;
			}
			converter *= 2;
		}
		for (int i=0;i<listB.length;i++) {
			if(listB[i]=='1') {
				valueB += converter;
			}
			converter *= 2;
		}
		return (valueA > valueB);
	}
	
	public static void main(String args[]) {
		BinaryInteger a = new BinaryInteger("00011110");
        BinaryInteger b = new BinaryInteger("01010000");
        System.out.println("a                = " + a);
        System.out.println("b                = " + b);
        System.out.println("a.length()       = " + a.length());
        System.out.println("a.not()          = " + a.not());
        System.out.println("a.xor(b)         = " + a.xor(b));
        System.out.println("a.leadingZeros() = " + a.leadingZeros());
        System.out.println("a.isGreaterThan(b) = " + a.isGreaterThan(b));
	}
}