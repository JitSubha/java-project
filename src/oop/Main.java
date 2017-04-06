package oop;




public class Main {
	

	public static void main(String[] args) throws Exception {
	
		English http = new English();
		System.out.println(http.executePost("http://localhost/test", "action=login"));
	}
	
	


}
