class test{
	public static void main(String[] args){
		for (int i=0;i<9;i++){
			Newclass obj = new NewClass();
		}System.out.println(obj.att);
	}
}
class NewClass{
	int att;
	NewClass(){
		att = 10;
	}
}