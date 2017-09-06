
	
	import java.util.HashMap;
	import java.util.TreeMap;

	public class RomanNumerals {
		private TreeMap<Integer, String> map;
		private HashMap<String,Integer> hashmap;
		
		public RomanNumerals(){
			this.map = new TreeMap<Integer, String> ();
			fillMap(this.map);
			this.hashmap = new HashMap<String,Integer>();
			fillHash();
		}
		
		
		public String romanizer (int numberToConvert){
			
			
			int floor = map.floorKey(numberToConvert);
			
			if(floor == numberToConvert){
				
				return map.get(floor);
			}
			
			if(numberToConvert > floor){
				
				return map.get(floor) + romanizer(numberToConvert - floor);
			}else{
				
				return null;
			}
			
		}
		
		public int romanConverter(String romanNum){
			if(!romanNum.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")){
				System.out.println("wrong format");
				return -1;
			}
			if(romanNum.length()== 0){
				return 0;
			}else if(romanNum.length()>=2){
					String sub = romanNum.substring(0, 2);
					if(this.hashmap.containsKey(sub)){
						return this.hashmap.get(sub) + romanConverter(romanNum.substring(2));
					}else{
						sub = romanNum.substring(0, 1);
						if(this.hashmap.containsKey(sub)){
							return this.hashmap.get(sub)+romanConverter(romanNum.substring(1));
						}else{
							System.out.println("wrong format of roman numerals");
							return -1;
						}
					}
			}else{
				String sub = romanNum.substring(0, 1);
				if(this.hashmap.containsKey(sub)){
					trimMap(sub);
					return this.hashmap.get(sub)+romanConverter(romanNum.substring(1));
				}else{
					System.out.println("wrong format of roman numerals");
					return -1;
				}
			}
		}
		
		private void fillMap( TreeMap<Integer,String> map){
			map.put(1000, "M");
	        map.put(900, "CM");
	        map.put(500, "D");
	        map.put(400, "CD");
	        map.put(100, "C");
	        map.put(90, "XC");
	        map.put(50, "L");
	        map.put(40, "XL");
	        map.put(10, "X");
	        map.put(9, "IX");
	        map.put(5, "V");
	        map.put(4, "IV");
	        map.put(1, "I");
		}
		
		private void fillHash(){
			this.hashmap.put("M", 1000);
			this.hashmap.put("CM", 900);
			this.hashmap.put("D", 500);
	        this.hashmap.put("CD", 400);
	        this.hashmap.put("C", 100);
	        this.hashmap.put("XC", 90);
	        this.hashmap.put("L",50 );
	        this.hashmap.put("XL", 40);
	        this.hashmap.put("X", 10);
	        this.hashmap.put("IX", 9);
	        this.hashmap.put("V", 5);
	        this.hashmap.put("IV", 4);
	        this.hashmap.put("I", 1);
			
		}
		
		private void trimMap(String sub){
			if(sub.equals("D")){
			}
		}
		

	}


